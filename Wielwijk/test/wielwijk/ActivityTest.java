/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package wielwijk;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author ylverhoog
 */
public class ActivityTest {

    public ActivityTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        Wielwijk.getDBConnection();
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of addUserAct method, of class Activity.
     */
    @Test
    public void testAddUserAct() {
        System.out.println("addUserAct");
        User user = null;
        Activity instance = null;
        instance.addUserAct(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeUserAct method, of class Activity.
     */
    @Test
    public void testRemoveUserAct() {
        System.out.println("removeUserAct");
        User user = null;
        Activity instance = null;
        instance.removeUserAct(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cancel method, of class Activity.
     */
    @Test
    public void testCancel() {
        System.out.println("cancel");
        Activity instance = null;
        instance.cancel();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Activity.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Activity instance = null;
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Activity.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Activity instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLocation method, of class Activity.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        Activity instance = null;
        String expResult = "";
        String result = instance.getLocation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDatetimeBegin method, of class Activity.
     */
    @Test
    public void testGetDatetimeBegin() {
        System.out.println("getDatetimeBegin");
        Activity instance = null;
        Date expResult = null;
        Date result = instance.getDatetimeBegin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDatetimeEnd method, of class Activity.
     */
    @Test
    public void testGetDatetimeEnd() {
        System.out.println("getDatetimeEnd");
        Activity instance = null;
        Date expResult = null;
        Date result = instance.getDatetimeEnd();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class Activity.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Activity instance = null;
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Activity.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Activity.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}