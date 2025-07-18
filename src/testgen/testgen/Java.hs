-- Copyright 2025 Humberto Gomes, José Lopes, Mariana Rocha
--
-- Licensed under the Apache License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
--
--     http://www.apache.org/licenses/LICENSE-2.0
--
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.

{-# LANGUAGE FlexibleInstances #-}

-- | Java code generation utilities
module Java
  (
    JavaData(..)
  , toJavaExpressionList
  , indent
  , decorateTest
  , assertTrue
  , assertEquals
  , assertSame
  , assertThrows
  , javaImports
  , runJava
  ) where

import Data.Char (isAscii, ord)
import Data.List (intercalate, isPrefixOf)
import Numeric (showHex)

import System.Process
  (
    StdStream(CreatePipe)
  , createProcess
  , proc
  , std_in
  , std_out
  , std_err
  , waitForProcess
  )
import System.IO (Handle, hClose, hGetContents, hPutStr)
import Control.Exception (bracket, evaluate)

-- JavaData definition
class JavaData a where
  -- | Gets the equivalent Java name for this Haskell type
  javaTypeName :: a      -- ^ Input value
               -> String -- ^ Java type name

  -- |
  -- Creates a Java expression that evaluates to the given value.
  --
  -- Example output: @Arrays.asList(1, 2, 3)@
  toJavaExpression :: a      -- ^ Input value
                   -> String -- ^ Java expression

  -- |
  -- Creates a Java variable declaration, where the variable is initialized to the given value
  --
  -- Example output: @List<Integer> list = Arrays.asList(1, 2, 3)@
  toJavaVariable :: String   -- ^ Variable name
                 -> a        -- ^ Input value
                 -> [String] -- ^ Java variable declation (lines of code)
  toJavaVariable name obj =
    [javaTypeName obj ++ " " ++ name ++ " = " ++ toJavaExpression obj ++ ";"]

-- Basic scalar types

instance JavaData Bool where
  javaTypeName = const "bool"
  toJavaExpression False = "false"
  toJavaExpression True = "true"

instance JavaData Int where
  javaTypeName = const "int"
  toJavaExpression = show

instance JavaData Integer where
  javaTypeName = const "int"
  toJavaExpression = show

instance JavaData Float where
  javaTypeName = const "float"
  toJavaExpression f = show f ++ "f"

instance JavaData Double where
  javaTypeName = const "double"
  toJavaExpression = show

pad :: Int -> a -> [a] -> [a]
pad n f xs = replicate (n - length xs) f ++ xs

toJavaCharacter '"' = "\\\""
toJavaCharacter '\'' = "\\'"
toJavaCharacter '\\' = "\\\\"
toJavaCharacter '\t' = "\\t"
toJavaCharacter '\b' = "\\b"
toJavaCharacter '\n' = "\\n"
toJavaCharacter '\r' = "\\r"
toJavaCharacter '\f' = "\\f"
toJavaCharacter c
  | isAscii c = [c]
  | otherwise = "\\u" ++ pad 4 '0' (showHex (ord c) "")

instance JavaData Char where
  javaTypeName = const "char"
  toJavaExpression c = "\'" ++ toJavaCharacter c ++ "\'"

instance JavaData String where
  javaTypeName = const "String"
  toJavaExpression s = "\"" ++ concat (map toJavaCharacter s) ++ "\""

-- Lists

-- | Creates the expression for a list of Java objects
toJavaExpressionList :: JavaData a => [a]    -- ^ List of Java objects
                                   -> String -- ^ Java expression
toJavaExpressionList xs = "Arrays.asList(" ++ intercalate ", " (map toJavaExpression xs) ++ ")"

instance JavaData [Bool] where
  javaTypeName = const "List<Boolean>"
  toJavaExpression = toJavaExpressionList

instance JavaData [Int] where
  javaTypeName = const "List<Integer>"
  toJavaExpression = toJavaExpressionList

instance JavaData [Integer] where
  javaTypeName = const "List<Integer>"
  toJavaExpression = toJavaExpressionList

instance JavaData [Float] where
  javaTypeName = const "List<Float>"
  toJavaExpression = toJavaExpressionList

instance JavaData [Double] where
  javaTypeName = const "List<Double>"
  toJavaExpression = toJavaExpressionList

instance JavaData [String] where
  javaTypeName = const "List<String>"
  toJavaExpression = toJavaExpressionList

-- Utilities

-- | Indents a sequence of lines with 4 spaces
indent :: [String] -> [String]
indent = map ("    " ++)

-- |
-- Puts the body of a test in a method declaration
--
-- Example output:
--
-- @
-- \@Test
-- void testName() {
--     testContents
-- }
-- @
decorateTest :: String   -- ^ Name of the test method
             -> [String] -- ^ Lines constituting the body of the test method
             -> [String] -- ^ Lines of the test method
decorateTest name test = concat [["@Test", "void " ++ name ++ "() {"], indent test, ["}"]]

-- Assertions

-- | @assertTrue@ statement generator
assertTrue :: String -- ^ A Java boolean expression
           -> String -- ^ A Java assertion statement
assertTrue c = "assertTrue(" ++ c ++ ");"

-- | @assertEquals@ statement generator
assertEquals :: String -- ^ A Java expression for the expected value
             -> String -- ^ A Java expression for the obtained value
             -> String -- ^ A Java assertion statement
assertEquals e g = "assertEquals(" ++ e ++ ", " ++ g ++ ");"

-- | @assertSame@ statement generator
assertSame :: String -- ^ A Java expression for the expected value
           -> String -- ^ A Java expression for the obtained value
           -> String -- ^ A Java assertion statement
assertSame e g = "assertSame(" ++ e ++ ", " ++ g ++ ");"

-- | @assertThrows@ statement generator
assertThrows :: String -- ^ Name of the expected exception class
             -> [String] -- ^ Lines where the exception should occur
             -> [String] -- ^ A Java assertion statement
assertThrows e b =
  [
    "assertThrows("
  , ("    " ++ e ++ ".class,")
  , "    () -> {"
  ] ++ (indent (indent b)) ++
  [
    "    }"
  , ");"
  ]

-- JVM interop

-- | Runs Java code with classes the project classes loaded
runJava :: [String]    -- ^ Java statements
        -> IO [String] -- ^ Lines output by the statements
runJava statements = do
  (Just stdin, Just stdout, Just stderr, process) <- createProcess
    (proc "jshell" ["--class-path=../../build/libs/ATS.jar"])
    { std_in = CreatePipe, std_out = CreatePipe, std_err = CreatePipe }

  bracket
    (return ())
    (\_ -> do
      hClose stdin
      hClose stdout
      hClose stderr
    )
    (\_ -> do
      hPutStr stdin (unlines statements)
      hClose stdin

      output <- hGetContents stdout
      evaluate (length output) -- Force deep strict evaluation
      let outputLines = lines output

      waitForProcess process
      return $ filter (not . isPrefixOf "|  ") outputLines
    )

-- Useful code

-- | Modules imported during testing
javaImports :: [String]
javaImports =
  [
    "import java.util.*;"
  , ""
  , "import MakeItFit.MakeItFit;"
  , "import MakeItFit.activities.Activity;"
  , "import MakeItFit.activities.implementation.PushUp;"
  , "import MakeItFit.activities.implementation.Running;"
  , "import MakeItFit.activities.implementation.Trail;"
  , "import MakeItFit.activities.implementation.WeightSquat;"
  , "import MakeItFit.users.Gender;"
  , "import MakeItFit.users.User;"
  , "import MakeItFit.users.types.Amateur;"
  , "import MakeItFit.users.types.Occasional;"
  , "import MakeItFit.users.types.Professional;"
  , "import MakeItFit.utils.MakeItFitDate;"
  ]
