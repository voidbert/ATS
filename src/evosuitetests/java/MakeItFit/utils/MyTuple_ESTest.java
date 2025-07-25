/*
 * This file was automatically generated by EvoSuite
 * Wed Jun 04 19:56:52 GMT 2025
 */

package MakeItFit.utils;

import MakeItFit.utils.MyTuple;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.evosuite.runtime.EvoAssertions.*;
import static org.junit.Assert.*;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true,
                     useVFS                = true,
                     useVNET               = true,
                     resetStaticState      = true,
                     useJEE                = true)
public class MyTuple_ESTest extends MyTuple_ESTest_scaffolding {

    @Test(timeout = 4000)
    public void test00() throws Throwable {
        Integer                  integer0 = new Integer(654);
        MyTuple<Object, Integer> myTuple0 = new MyTuple<Object, Integer>(")", integer0);
        MyTuple<Object, Integer> myTuple1 = myTuple0.clone();
        int                      int0     = myTuple0.compareTo(myTuple1);
        assertEquals(0, int0);
    }

    @Test(timeout = 4000)
    public void test01() throws Throwable {
        MyTuple<String, Object> myTuple0 =
            new MyTuple<String, Object>((String) null, (Object) null);
        Object object0 = myTuple0.getItem2();
        assertNull(object0);
    }

    @Test(timeout = 4000)
    public void test02() throws Throwable {
        MyTuple<String, String> myTuple0 = new MyTuple<String, String>(")", ")");
        Object                  object0  = myTuple0.getItem1();
        assertEquals(")", object0);
    }

    @Test(timeout = 4000)
    public void test03() throws Throwable {
        Integer                  integer0 = new Integer((-1191));
        MyTuple<Object, Integer> myTuple0 = new MyTuple<Object, Integer>(",mINg%,X<", integer0);
        MyTuple<Object, Integer> myTuple1 = new MyTuple<Object, Integer>(myTuple0, integer0);
        int                      int0     = myTuple0.compareTo(myTuple1);
        assertEquals(29, int0);
    }

    @Test(timeout = 4000)
    public void test04() throws Throwable {
        Integer                                  integer0 = new Integer(654);
        MyTuple<Object, MyTuple<String, Object>> myTuple0 =
            new MyTuple<Object, MyTuple<String, Object>>((Object) null,
                                                         (MyTuple<String, Object>) null);
        MyTuple<String, Integer> myTuple1 =
            new MyTuple<String, Integer>("(K@V=*7(|Pu%q!0-)mM", integer0);
        // Undeclared exception!
        try {
            myTuple0.equals(myTuple1);
            fail("Expecting exception: NullPointerException");

        } catch (NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //
            verifyException("MakeItFit.utils.MyTuple", e);
        }
    }

    @Test(timeout = 4000)
    public void test05() throws Throwable {
        Integer                  integer0 = new Integer(3232);
        MyTuple<Integer, String> myTuple0 = new MyTuple<Integer, String>(integer0, (String) null);
        // Undeclared exception!
        try {
            myTuple0.compareTo(myTuple0);
            fail("Expecting exception: NullPointerException");

        } catch (NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //
            verifyException("org.evosuite.runtime.System", e);
        }
    }

    @Test(timeout = 4000)
    public void test06() throws Throwable {
        Integer                  integer0 = new Integer(0);
        Object                   object0  = new Object();
        MyTuple<Integer, Object> myTuple0 = new MyTuple<Integer, Object>(integer0, object0);
        boolean                  boolean0 = myTuple0.equals(object0);
        assertFalse(boolean0);
    }

    @Test(timeout = 4000)
    public void test07() throws Throwable {
        Integer                   integer0 = new Integer(12);
        Integer                   integer1 = new Integer(12);
        MyTuple<Integer, Integer> myTuple0 = new MyTuple<Integer, Integer>(integer0, integer1);
        MyTuple<Integer, Integer> myTuple1 = new MyTuple<Integer, Integer>(integer1, integer1);
        int                       int0     = myTuple1.compareTo(myTuple0);
        assertEquals((-1), int0);
    }

    @Test(timeout = 4000)
    public void test08() throws Throwable {
        MyTuple<String, String> myTuple0 =
            new MyTuple<String, String>("(null, null)", "(null, null)");
        Integer                                   integer0 = new Integer((-7));
        MyTuple<MyTuple<String, String>, Integer> myTuple1 =
            new MyTuple<MyTuple<String, String>, Integer>(myTuple0, integer0);
        MyTuple<Object, String> myTuple2 = new MyTuple<Object, String>(myTuple1, "(null, null)");
        boolean                 boolean0 = myTuple2.equals((Object) null);
        assertFalse(boolean0);
    }

    @Test(timeout = 4000)
    public void test09() throws Throwable {
        MyTuple<String, String> myTuple0 =
            new MyTuple<String, String>("(null, null)", "(null, null)");
        Integer                                   integer0 = new Integer((-7));
        MyTuple<MyTuple<String, String>, Integer> myTuple1 =
            new MyTuple<MyTuple<String, String>, Integer>(myTuple0, integer0);
        boolean boolean0 = myTuple1.equals(myTuple1);
        assertTrue(boolean0);
    }

    @Test(timeout = 4000)
    public void test10() throws Throwable {
        MyTuple<String, String> myTuple0 =
            new MyTuple<String, String>("(null, null)", "(null, null)");
        Integer                                   integer0 = new Integer((-7));
        MyTuple<MyTuple<String, String>, Integer> myTuple1 =
            new MyTuple<MyTuple<String, String>, Integer>(myTuple0, integer0);
        MyTuple<Object, Object> myTuple2 = new MyTuple<Object, Object>(integer0, "(null, null)");
        boolean                 boolean0 = myTuple1.equals(myTuple2);
        assertFalse(boolean0);
    }

    @Test(timeout = 4000)
    public void test11() throws Throwable {
        MyTuple<Integer, Integer> myTuple0 =
            new MyTuple<Integer, Integer>((Integer) null, (Integer) null);
        String string0 = myTuple0.toString();
        assertEquals("(null, null)", string0);
    }

    @Test(timeout = 4000)
    public void test12() throws Throwable {
        MyTuple<String, String> myTuple0 =
            new MyTuple<String, String>("(null, null)", "(null, null)");
        Integer                                   integer0 = new Integer((-7));
        MyTuple<MyTuple<String, String>, Integer> myTuple1 =
            new MyTuple<MyTuple<String, String>, Integer>(myTuple0, integer0);
        MyTuple<Object, String> myTuple2 = new MyTuple<Object, String>(myTuple1, "(null, null)");
        MyTuple<Object, MyTuple<Object, String>> myTuple3 =
            new MyTuple<Object, MyTuple<Object, String>>((Object) null, myTuple2);
        Object object0 = myTuple3.getItem1();
        assertNull(object0);
    }

    @Test(timeout = 4000)
    public void test13() throws Throwable {
        MyTuple<String, String> myTuple0 =
            new MyTuple<String, String>("(null, null)", "(null, null)");
        Integer                                   integer0 = new Integer((-7));
        MyTuple<MyTuple<String, String>, Integer> myTuple1 =
            new MyTuple<MyTuple<String, String>, Integer>(myTuple0, integer0);
        MyTuple<MyTuple<String, String>, Integer> myTuple2 = myTuple1.clone();
        boolean                                   boolean0 = myTuple2.equals(myTuple1);
        assertTrue(boolean0);
    }

    @Test(timeout = 4000)
    public void test14() throws Throwable {
        Integer                 integer0 = new Integer((-7));
        MyTuple<Object, Object> myTuple0 = new MyTuple<Object, Object>(integer0, "(null, null)");
        Object                  object0  = myTuple0.getItem2();
        assertEquals("(null, null)", object0);
    }
}
