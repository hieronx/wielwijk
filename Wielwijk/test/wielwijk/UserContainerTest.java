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
public class UserContainerTest {

    public UserContainerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
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
        String name = "";
        String password = "";
        int picture = 0;
        String address = "";
        String birthdate = "";
        UserContainer.addBoard(name, password, picture, address, birthdate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        List result = UserContainer.findUser(name);
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