/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package wielwijk;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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

}