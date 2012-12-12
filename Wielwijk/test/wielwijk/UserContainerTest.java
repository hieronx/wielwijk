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
    public static void tearDownClass()  {
       
    }

    /**
     * Test of addBoard method, of class UserContainer.
     */
    @Test
    public void testAddBoard() {
       
        System.out.println("addBoard");
        String name = "Klaas Test";
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
        
        //gooit nieuwe boardmember weer weg
        java.util.List results2 = Wielwijk.db.query("SELECT id FROM users WHERE name LIKE '%Klaas Test%'");
        java.util.Map<String, Object> map = (HashMap<String, Object>) results2.get(0);
        int id = Integer.parseInt(String.valueOf((Long)map.get("id")));
        UserContainer.removeUser(id);
        
        
        
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
        
         //gooit nieuwe member weer weg
        java.util.List results2 = Wielwijk.db.query("SELECT id FROM users WHERE name LIKE '%Piet Test%'");
        java.util.Map<String, Object> map = (HashMap<String, Object>) results2.get(0);
        int id = Integer.parseInt(String.valueOf((Long)map.get("id")));
        UserContainer.removeUser(id);
    }

  
    /**
     * Test of findUser method, of class UserContainer.
     */
    @Test
    public void testFindUser() {
        System.out.println("findUser");
        
        //maakt test user
        String name = "Piet Test";
        String password = "test";
        int picture = 12;
        String address = "test";
        String birthdate = "2011-11-11";
        
        UserContainer.addMember(name, password, picture, address, birthdate);
        
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
       
         //gooit nieuwe test user weer weg
        java.util.List results2 = Wielwijk.db.query("SELECT id FROM users WHERE name LIKE '%Piet Test%'");
        java.util.Map<String, Object> map2 = (HashMap<String, Object>) results2.get(0);
        int id = Integer.parseInt(String.valueOf((Long)map2.get("id")));
        UserContainer.removeUser(id);
        
    }

    /**
     * Test of getUserById method, of class UserContainer.
     */
    @Test
    public void testGetUserById() {
       
        System.out.println("getUserById");
        int id = 1;
        String expResult = "Jeroen Offerijns";
        User result = UserContainer.getUserById(1);
        
        assertEquals(expResult, result.getName());
       
    }
      /**
     * Test of removeUser method, of class UserContainer.
     */
    @Test
    public void testRemoveUser() {
        //maakt test user
        String name = "Piet Test";
        String password = "test";
        int picture = 12;
        String address = "test";
        String birthdate = "2011-11-11";
        
        UserContainer.addMember(name, password, picture, address, birthdate);
        
        //test de remove functie
        System.out.println("removeUser");
        java.util.List results = Wielwijk.db.query("SELECT id FROM users WHERE name LIKE '%Piet%'");
        java.util.Map<String, Object> map = (HashMap<String, Object>) results.get(0);
        int id = Integer.parseInt(String.valueOf((Long)map.get("id")));
        System.out.println(id);
        UserContainer.removeUser(id);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(UserContainer.getUserById(id),null);
    }

}