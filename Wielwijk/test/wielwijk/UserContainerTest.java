/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package wielwijk;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author ylverhoog
 */
public class UserContainerTest {

    public UserContainerTest() {
    }

   
    @Before
    public void setUp() {
        Wielwijk.getDBConnection();
    }
    

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of addBoard method, of class UserContainer.
     */
    @Test
    public void testAddBoard() {
       
        System.out.println("addBoard");
        String name = "test";
        String password = "test";
        int picture = 12;
        String address = "test";
        String birthdate = "0000-00-00";
        UserContainer.addBoard("test", password, picture, address, birthdate);
        // TODO review the generated test code and remove the default call to fail.
        
        java.util.List results = Wielwijk.db.query("SELECT * FROM users WHERE name LIKE '%test%'");
        System.out.println(results.get(0));
        assertTrue(results.get(3).toString() == name);
        assertTrue(results.get(7).toString() == password);
        assertTrue(results.get(0).toString() == Integer.toString(picture));
        assertTrue(results.get(3).toString() == address);
        assertTrue(results.get(4).toString() == birthdate);
        
        
    }

    /**
     * Test of addMember method, of class UserContainer.
     */
    @Test
    public void testAddMember() {
        System.out.println("addMember");
        String name = "";
        String password = "";
        int picture = 0;
        String address = "";
        String birthdate = "";
        UserContainer.addMember(name, password, picture, address, birthdate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeUser method, of class UserContainer.
     */
    @Test
    public void testRemoveUser() {
        System.out.println("removeUser");
        int id = 0;
        UserContainer.removeUser(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findUser method, of class UserContainer.
     */
    @Test
    public void testFindUser() {
        System.out.println("findUser");
        String name = "";
        List expResult = null;
        List result = UserContainer.findUser("henk");
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserById method, of class UserContainer.
     */
    @Test
    public void testGetUserById() {
        System.out.println("getUserById");
        int id = 0;
        User expResult = null;
        User result = UserContainer.getUserById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}