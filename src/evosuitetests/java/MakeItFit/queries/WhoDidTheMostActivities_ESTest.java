/*
 * This file was automatically generated by EvoSuite
 * Wed Jun 04 20:22:50 GMT 2025
 */

package MakeItFit.queries;

import java.util.UUID;

import MakeItFit.activities.implementation.PushUp;
import MakeItFit.activities.implementation.Running;
import MakeItFit.queries.WhoDidTheMostActivities;
import MakeItFit.users.Gender;
import MakeItFit.users.User;
import MakeItFit.users.UserManager;
import MakeItFit.users.types.Amateur;
import MakeItFit.users.types.Occasional;
import MakeItFit.utils.MakeItFitDate;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.System;
import org.evosuite.runtime.mock.java.util.MockUUID;
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
public class WhoDidTheMostActivities_ESTest extends WhoDidTheMostActivities_ESTest_scaffolding {

    @Test(timeout = 4000)
    public void test00() throws Throwable {
        WhoDidTheMostActivities whoDidTheMostActivities0 = new WhoDidTheMostActivities();
        UserManager             userManager0             = new UserManager();
        MakeItFitDate           makeItFitDate0           = new MakeItFitDate();
        MakeItFitDate           makeItFitDate1           = makeItFitDate0.plusDays((-798));
        Gender                  gender0                  = Gender.Male;
        System.setCurrentTimeMillis(5);
        Amateur amateur0 = new Amateur("MakeItFit.queries.WhoDidTheMostActivities",
                                       5,
                                       gender0,
                                       5,
                                       5,
                                       5,
                                       5,
                                       "MakeItFit.queries.WhoDidTheMostActivities",
                                       "MakeItFit.queries.WhoDidTheMostActivities",
                                       "MakeItFit.queries.WhoDidTheMostActivities");
        amateur0.setWeight(0.0F);
        userManager0.insertUser(amateur0);
        UUID    uUID0    = MockUUID.randomUUID();
        Running running0 = new Running(uUID0,
                                       makeItFitDate1,
                                       (-798),
                                       "MakeItFit.queries.WhoDidTheMostActivities",
                                       "MakeItFit.queries.WhoDidTheMostActivities",
                                       5,
                                       5);
        amateur0.addActivity(running0);
        MakeItFitDate makeItFitDate2 = new MakeItFitDate();
        User          user0 =
            whoDidTheMostActivities0.executeQuery(userManager0, makeItFitDate2, makeItFitDate0);
        assertEquals(5, user0.getAge());
    }

    @Test(timeout = 4000)
    public void test01() throws Throwable {
        WhoDidTheMostActivities whoDidTheMostActivities0 = new WhoDidTheMostActivities();
        UserManager             userManager0             = new UserManager();
        MakeItFitDate           makeItFitDate0           = new MakeItFitDate();
        MakeItFitDate           makeItFitDate1           = makeItFitDate0.plusDays((-798));
        Gender                  gender0                  = Gender.Other;
        System.setCurrentTimeMillis(5);
        Amateur amateur0 = new Amateur("", 5, gender0, 5, 5, 5, 5, "", "", "");
        amateur0.setLevel(0);
        userManager0.insertUser(amateur0);
        UUID    uUID0    = MockUUID.randomUUID();
        Running running0 = new Running(uUID0, makeItFitDate1, (-798), "", "", 5, 5);
        amateur0.addActivity(running0);
        MakeItFitDate makeItFitDate2 = new MakeItFitDate();
        User          user0 =
            whoDidTheMostActivities0.executeQuery(userManager0, makeItFitDate2, makeItFitDate0);
        assertEquals(Gender.Other, user0.getGender());
    }

    @Test(timeout = 4000)
    public void test02() throws Throwable {
        WhoDidTheMostActivities whoDidTheMostActivities0 = new WhoDidTheMostActivities();
        UserManager             userManager0             = new UserManager();
        MakeItFitDate           makeItFitDate0           = new MakeItFitDate();
        MakeItFitDate           makeItFitDate1           = makeItFitDate0.plusDays((-798));
        Gender                  gender0                  = Gender.Male;
        Amateur                 amateur0 = new Amateur("MakeItFit.queries.WhoDidTheMostActivities",
                                       5,
                                       gender0,
                                       5,
                                       5,
                                       5,
                                       5,
                                       "MakeItFit.queries.WhoDidTheMostActivities",
                                       "MakeItFit.queries.WhoDidTheMostActivities",
                                       "MakeItFit.queries.WhoDidTheMostActivities");
        userManager0.insertUser(amateur0);
        amateur0.setAge(0);
        UUID    uUID0    = MockUUID.randomUUID();
        Running running0 = new Running(uUID0,
                                       makeItFitDate1,
                                       (-798),
                                       "MakeItFit.queries.WhoDidTheMostActivities",
                                       "MakeItFit.queries.WhoDidTheMostActivities",
                                       5,
                                       5);
        amateur0.addActivity(running0);
        MakeItFitDate makeItFitDate2 = makeItFitDate1.plusDays((-798));
        User          user0 =
            whoDidTheMostActivities0.executeQuery(userManager0, makeItFitDate2, makeItFitDate0);
        assertEquals("MakeItFit.queries.WhoDidTheMostActivities", user0.getAddress());
    }

    @Test(timeout = 4000)
    public void test03() throws Throwable {
        WhoDidTheMostActivities whoDidTheMostActivities0 = new WhoDidTheMostActivities();
        UserManager             userManager0             = new UserManager();
        MakeItFitDate           makeItFitDate0           = new MakeItFitDate();
        Gender                  gender0                  = Gender.Male;
        Amateur                 amateur0 = new Amateur("MakeItFit.queries.WhoDidTheMostActivities",
                                       5,
                                       gender0,
                                       5,
                                       5,
                                       5,
                                       5,
                                       "MakeItFit.queries.WhoDidTheMostActivities",
                                       "MakeItFit.queries.WhoDidTheMostActivities",
                                       "MakeItFit.queries.WhoDidTheMostActivities");
        amateur0.setWeight(0.0F);
        userManager0.insertUser(amateur0);
        UUID    uUID0    = MockUUID.randomUUID();
        Running running0 = new Running(uUID0,
                                       makeItFitDate0,
                                       (-798),
                                       "MakeItFit.queries.WhoDidTheMostActivities",
                                       "MakeItFit.queries.WhoDidTheMostActivities",
                                       5,
                                       5);
        amateur0.addActivity(running0);
        User user0 = whoDidTheMostActivities0.executeQuery(userManager0);
        assertEquals("MakeItFit.queries.WhoDidTheMostActivities", user0.getAddress());
    }

    @Test(timeout = 4000)
    public void test04() throws Throwable {
        WhoDidTheMostActivities whoDidTheMostActivities0 = new WhoDidTheMostActivities();
        UserManager             userManager0             = new UserManager();
        MakeItFitDate           makeItFitDate0           = new MakeItFitDate();
        Gender                  gender0                  = Gender.Other;
        Amateur                 amateur0 = new Amateur("", 5, gender0, 5, 5, 5, 5, "", "", "");
        amateur0.setLevel(0);
        userManager0.insertUser(amateur0);
        UUID    uUID0    = MockUUID.randomUUID();
        Running running0 = new Running(uUID0, makeItFitDate0, (-798), "", "", 5, 5);
        amateur0.addActivity(running0);
        User user0 = whoDidTheMostActivities0.executeQuery(userManager0);
        assertEquals(0, user0.getLevel());
    }

    @Test(timeout = 4000)
    public void test05() throws Throwable {
        WhoDidTheMostActivities whoDidTheMostActivities0 = new WhoDidTheMostActivities();
        UserManager             userManager0             = new UserManager();
        Gender                  gender0                  = Gender.Female;
        Occasional              occasional0 =
            new Occasional("", 350, gender0, 350, 0, 0, 350, "", (String) null, "", 350);
        UUID   uUID0   = MockUUID.randomUUID();
        PushUp pushUp0 = new PushUp(uUID0, (MakeItFitDate) null, 0, "(s:sU", "", 0, 0);
        occasional0.addActivity(pushUp0);
        userManager0.insertUser(occasional0);
        User user0 = whoDidTheMostActivities0.executeQuery(userManager0);
        assertEquals("", user0.getAddress());
    }

    @Test(timeout = 4000)
    public void test06() throws Throwable {
        WhoDidTheMostActivities whoDidTheMostActivities0 = new WhoDidTheMostActivities();
        UserManager             userManager0             = new UserManager();
        MakeItFitDate           makeItFitDate0           = new MakeItFitDate();
        Gender                  gender0                  = Gender.Male;
        Amateur                 amateur0 = new Amateur("MakeItFit.queries.WhoDidTheMostActivities",
                                       5,
                                       gender0,
                                       5,
                                       5,
                                       5,
                                       5,
                                       "MakeItFit.queries.WhoDidTheMostActivities",
                                       "MakeItFit.queries.WhoDidTheMostActivities",
                                       "MakeItFit.queries.WhoDidTheMostActivities");
        userManager0.insertUser(amateur0);
        amateur0.setAge(0);
        UUID    uUID0    = MockUUID.randomUUID();
        Running running0 = new Running(uUID0,
                                       makeItFitDate0,
                                       (-798),
                                       "MakeItFit.queries.WhoDidTheMostActivities",
                                       "MakeItFit.queries.WhoDidTheMostActivities",
                                       5,
                                       5);
        amateur0.addActivity(running0);
        User user0 = whoDidTheMostActivities0.executeQuery(userManager0);
        assertEquals(5, user0.getLevel());
    }

    @Test(timeout = 4000)
    public void test07() throws Throwable {
        WhoDidTheMostActivities whoDidTheMostActivities0 = new WhoDidTheMostActivities();
        MakeItFitDate           makeItFitDate0           = new MakeItFitDate();
        MakeItFitDate           makeItFitDate1           = makeItFitDate0.plusDays(1);
        // Undeclared exception!
        try {
            whoDidTheMostActivities0.executeQuery((UserManager) null,
                                                  makeItFitDate0,
                                                  makeItFitDate1);
            fail("Expecting exception: NullPointerException");

        } catch (NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //
            verifyException("MakeItFit.queries.WhoDidTheMostActivities", e);
        }
    }

    @Test(timeout = 4000)
    public void test08() throws Throwable {
        WhoDidTheMostActivities whoDidTheMostActivities0 = new WhoDidTheMostActivities();
        // Undeclared exception!
        try {
            whoDidTheMostActivities0.executeQuery((UserManager) null);
            fail("Expecting exception: NullPointerException");

        } catch (NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //
            verifyException("MakeItFit.queries.WhoDidTheMostActivities", e);
        }
    }

    @Test(timeout = 4000)
    public void test09() throws Throwable {
        WhoDidTheMostActivities whoDidTheMostActivities0 = new WhoDidTheMostActivities();
        UserManager             userManager0             = new UserManager();
        Gender                  gender0                  = Gender.Male;
        Amateur                 amateur0 = new Amateur("MakeItFit.queries.WhoDidTheMostActivi>ies",
                                       5,
                                       gender0,
                                       5,
                                       5,
                                       5,
                                       5,
                                       "MakeItFit.queries.WhoDidTheMostActivi>ies",
                                       "MakeItFit.queries.WhoDidTheMostActivi>ies",
                                       "MakeItFit.queries.WhoDidTheMostActivi>ies");
        userManager0.insertUser(amateur0);
        User user0 = whoDidTheMostActivities0.executeQuery(userManager0);
        assertNull(user0);
    }

    @Test(timeout = 4000)
    public void test10() throws Throwable {
        WhoDidTheMostActivities whoDidTheMostActivities0 = new WhoDidTheMostActivities();
        UserManager             userManager0             = new UserManager();
        MakeItFitDate           makeItFitDate0           = new MakeItFitDate();
        Gender                  gender0                  = Gender.Other;
        Amateur                 amateur0                 = new Amateur("",
                                       5,
                                       gender0,
                                       5,
                                       5,
                                       5,
                                       5,
                                       "MakeItFit.queries.WhoDidTheMostActivities",
                                       "MakeItFit.queries.WhoDidTheMostActivities",
                                       "");
        userManager0.insertUser(amateur0);
        UUID    uUID0 = MockUUID.randomUUID();
        Running running0 =
            new Running(uUID0, makeItFitDate0, (-798), " minutes, ", "", 1685.538371719, 5);
        amateur0.addActivity(running0);
        MakeItFitDate makeItFitDate1 = makeItFitDate0.plusDays((-3586));
        User          user0 =
            whoDidTheMostActivities0.executeQuery(userManager0, makeItFitDate1, makeItFitDate0);
        assertNull(user0);
    }

    @Test(timeout = 4000)
    public void test11() throws Throwable {
        WhoDidTheMostActivities whoDidTheMostActivities0 = new WhoDidTheMostActivities();
        UserManager             userManager0             = new UserManager();
        MakeItFitDate           makeItFitDate0           = new MakeItFitDate();
        MakeItFitDate           makeItFitDate1           = makeItFitDate0.plusDays((-798));
        Gender                  gender0                  = Gender.Other;
        Amateur                 amateur0                 = new Amateur("",
                                       5,
                                       gender0,
                                       5,
                                       5,
                                       5,
                                       5,
                                       "MakeItFit.queries.WhoDidTheMostActivities",
                                       "MakeItFit.queries.WhoDidTheMostActivities",
                                       "");
        userManager0.insertUser(amateur0);
        UUID    uUID0 = MockUUID.randomUUID();
        Running running0 =
            new Running(uUID0, makeItFitDate1, (-798), " minutes, ", "", 1685.538371719, 5);
        amateur0.addActivity(running0);
        User user0 =
            whoDidTheMostActivities0.executeQuery(userManager0, makeItFitDate1, makeItFitDate0);
        assertNull(user0);
    }

    @Test(timeout = 4000)
    public void test12() throws Throwable {
        WhoDidTheMostActivities whoDidTheMostActivities0 = new WhoDidTheMostActivities();
        UserManager             userManager0             = new UserManager();
        MakeItFitDate           makeItFitDate0           = new MakeItFitDate();
        // Undeclared exception!
        try {
            whoDidTheMostActivities0.executeQuery(userManager0,
                                                  makeItFitDate0,
                                                  (MakeItFitDate) null);
            fail("Expecting exception: IllegalArgumentException");

        } catch (IllegalArgumentException e) {
            //
            // Invalid dates.
            //
            verifyException("MakeItFit.queries.WhoDidTheMostActivities", e);
        }
    }

    @Test(timeout = 4000)
    public void test13() throws Throwable {
        WhoDidTheMostActivities whoDidTheMostActivities0 = new WhoDidTheMostActivities();
        UserManager             userManager0             = new UserManager();
        MakeItFitDate           makeItFitDate0           = new MakeItFitDate();
        // Undeclared exception!
        try {
            whoDidTheMostActivities0.executeQuery(userManager0, makeItFitDate0, makeItFitDate0);
            fail("Expecting exception: IllegalArgumentException");

        } catch (IllegalArgumentException e) {
            //
            // Invalid dates.
            //
            verifyException("MakeItFit.queries.WhoDidTheMostActivities", e);
        }
    }

    @Test(timeout = 4000)
    public void test14() throws Throwable {
        WhoDidTheMostActivities whoDidTheMostActivities0 = new WhoDidTheMostActivities();
        UserManager             userManager0             = new UserManager();
        // Undeclared exception!
        try {
            whoDidTheMostActivities0.executeQuery(userManager0,
                                                  (MakeItFitDate) null,
                                                  (MakeItFitDate) null);
            fail("Expecting exception: IllegalArgumentException");

        } catch (IllegalArgumentException e) {
            //
            // Invalid dates.
            //
            verifyException("MakeItFit.queries.WhoDidTheMostActivities", e);
        }
    }
}
