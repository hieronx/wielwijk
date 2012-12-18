/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package wielwijk;

import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ylverhoog
 */
public class ActivityContainerTest {

    public ActivityContainerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        Wielwijk.getDBConnection();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of addActivity method, of class ActivityContainer.
     */
    @Test
    public void testAddActivity() {
        
        System.out.println("addActivity");
        String name = "";
        String location = "";
        String description = "";
        String datetime_begin = "";
        String datetime_end = "";
        int fee = 0;
        int lower_user_limit = 0;
        int upper_user_limit = 0;
        String lower_limit_date = "";
        boolean cancelled = false;
        ActivityContainer instance = new ActivityContainer();
        Activity expResult = null;
        Activity result = instance.addActivity(name, location, description, datetime_begin, datetime_end, fee, lower_user_limit, upper_user_limit, lower_limit_date, cancelled);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeActivity method, of class ActivityContainer.
     */
    @Test
    public void testRemoveActivity() {
        System.out.println("removeActivity");
        Activity activity = null;
        ActivityContainer instance = new ActivityContainer();
        instance.removeActivity(activity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findActivity method, of class ActivityContainer.
     */
    @Test
    public void testFindActivity() {
        System.out.println("findActivity");
        Activity activity = null;
        ActivityContainer instance = new ActivityContainer();
        List expResult = null;
        List result = instance.findActivity(activity);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}