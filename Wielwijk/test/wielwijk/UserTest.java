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
public class UserTest {

    public UserTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of suspend method, of class User.
     */
    @Test
    public void testSuspend() {
        System.out.println("suspend");
        User instance = null;
        instance.suspend();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of unsuspend method, of class User.
     */
    @Test
    public void testUnsuspend() {
        System.out.println("unsuspend");
        User instance = null;
        instance.unsuspend();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class User.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        User instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBirthdate method, of class User.
     */
    @Test
    public void testGetBirthdate() {
        System.out.println("getBirthdate");
        User instance = null;
        String expResult = "";
        String result = instance.getBirthdate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPicture method, of class User.
     */
    @Test
    public void testGetPicture() {
        System.out.println("getPicture");
        User instance = null;
        int expResult = 0;
        int result = instance.getPicture();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isActive method, of class User.
     */
    @Test
    public void testIsActive() {
        System.out.println("isActive");
        User instance = null;
        boolean expResult = false;
        boolean result = instance.isActive();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isBoard method, of class User.
     */
    @Test
    public void testIsBoard() {
        System.out.println("isBoard");
        User instance = null;
        boolean expResult = false;
        boolean result = instance.isBoard();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}