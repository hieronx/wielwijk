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
import java.text.SimpleDateFormat;

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
        String name = "asdsadffd";
        String password = "test";
        int picture = 12;
        String address = "test";
        String birthdate = "2011-11-11";
        
        UserContainer.addBoard(name, password, picture, address, birthdate);
        // TODO review the generated test code and remove the default call to fail.
        
        boolean result=false;
        java.util.List results = Wielwijk.db.query("SELECT password, address, birthdate, picture FROM users WHERE name LIKE '%"+ name+ "%'");
        if (results.get(0).toString().equals("{picture=" + picture +", address=" + address + ", birthdate=" + birthdate + ", password=" + password + "}")){
            result=true;
        } else{
            System.out.println(results.get(0));
            System.out.println("{picture=" + picture +", address=" + address + ", birthdate=" + birthdate + ", password=" + password + "}");
        }
        assertEquals(result,true);
        
        
        
    }

    /**
     * Test of addMember method, of class UserContainer.
     */
    @Test
    public void testAddMember() {
        System.out.println("addMember");
        String name = "Piet Test";
        String password = "test";
        int picture = 12;
        String address = "test";
        String birthdate = "2011-11-11";
        
        UserContainer.addMember(name, password, picture, address, birthdate);
        // TODO review the generated test code and remove the default call to fail.
        
        boolean result=false;
        java.util.List results = Wielwijk.db.query("SELECT password, address, birthdate, picture FROM users WHERE name LIKE '%"+ name+ "%'");
        if (results.get(0).toString().equals("{picture=" + picture +", address=" + address + ", birthdate=" + birthdate + ", password=" + password + "}")){
            result=true;
        } else{
            System.out.println(results.get(0));
            System.out.println("{picture=" + picture +", address=" + address + ", birthdate=" + birthdate + ", password=" + password + "}");
        }
        assertEquals(result,true);
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
        
        //De test user
        String name = "Piet Test";
        String password = "test";
        int picture = 12;
        String address = "test";
        String birthdate = "2011-11-11";
        
       
        //expected resulte
        String expResult = name + password + String.valueOf(picture) + address + birthdate;
        //functie
        List result = UserContainer.findUser(name);
        //haalt de vergelijkbare gegevens uit de functie
        if (result.isEmpty()) {fail("geen user gevonden");}
 
        java.util.Map<String, Object> map = (HashMap<String, Object>) result.get(0);
        
        String formatted = (String)map.get("name") + (String)map.get("password") + (Integer)map.get("picture")+
                (String)map.get("address")+ map.get("birthdate").toString();
          //vergelijkt de name, password, picture , adress en birthdate van expected met die van de functie
        assertEquals(expResult, formatted);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getUserById method, of class UserContainer.
     */
    @Test
    public void testGetUserById() {
        System.out.println("getUserById");
        int id = 1;
        User expResult = new User("Jeroen Offerijns", "informaticus", 35, "Haarlem", "1993-11-25",false,1);
        User result = UserContainer.getUserById(1);
        System.out.println(result.getName());
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}