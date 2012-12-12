/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wielwijk;

import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bart
 */
public class UserTest {
    
    public UserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Wielwijk.getDBConnection();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of suspend method, of class User.
     */
    @Test
    public void testSuspend() {
        System.out.println("suspend");
        //Maakt een nieuwe user
        UserContainer.addMember("bla", "bla", 1, "bla", "2012-12-12");
        //Haalt hoogste id op, oftewel de zojuist gemaakte usSELECT * FROM users WHERE id IN SELECT MAX ID FROM userser
        java.util.List results = Wielwijk.db.query("SELECT * FROM users WHERE id IN (SELECT MAX( id )FROM users)");
        java.util.Map<String, Object> map = (HashMap<String, Object>) results.get(0);
        int id = Integer.parseInt(String.valueOf((Long)map.get("id")));
        //suspend de user
        UserContainer.getUserById(id).suspend();
        //kijk of de user inderdaad niet actief is
        java.util.List results2 = Wielwijk.db.query("SELECT * FROM users WHERE id="+ id);
        java.util.Map<String, Object> map2 = (HashMap<String, Object>) results2.get(0);
        Boolean active = (Boolean)map2.get("active");
        System.out.println("active " + active);
        System.out.println("id " + id);
        assertEquals(active,false);
        
        //verwijder de user weer
        UserContainer.removeUser(id);
        
    }

    /**
     * Test of unsuspend method, of class User.
     */
    @Test
    public void testUnsuspend() {
        //Maakt een nieuwe user
        UserContainer.addMember("bla", "bla", 1, "bla", "2012-12-12");
        //Haalt hoogste id op, oftewel de zojuist gemaakte usSELECT * FROM users WHERE id IN SELECT MAX ID FROM userser
        java.util.List results = Wielwijk.db.query("SELECT * FROM users WHERE id IN (SELECT MAX( id )FROM users)");
        java.util.Map<String, Object> map = (HashMap<String, Object>) results.get(0);
        int id = Integer.parseInt(String.valueOf((Long)map.get("id")));
        //unsuspend de user
        UserContainer.getUserById(id).unsuspend();
        //kijk of de user inderdaad niet actief is
        java.util.List results2 = Wielwijk.db.query("SELECT * FROM users WHERE id="+ id);
        java.util.Map<String, Object> map2 = (HashMap<String, Object>) results2.get(0);
        Boolean active = (Boolean)map2.get("active");
        System.out.println("active " + active);
        System.out.println("id " + id);
        assertEquals(active,true);
        
        //verwijder de user weer
        UserContainer.removeUser(id);
    }

    /**
     * Test of getId method, of class User.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        //Maakt een nieuwe user
        UserContainer.addMember("bla", "bla", 1, "bla", "2012-12-12");
        //Haalt hoogste id op, oftewel de zojuist gemaakte usSELECT * FROM users WHERE id IN SELECT MAX ID FROM userser
        java.util.List results = Wielwijk.db.query("SELECT * FROM users WHERE id IN (SELECT MAX( id )FROM users)");
        java.util.Map<String, Object> map = (HashMap<String, Object>) results.get(0);
        int id = Integer.parseInt(String.valueOf((Long)map.get("id")));
        //De test van de getId functie
        User test=UserContainer.getUserById(id);
        long result = test.getId();
        //verwacht resultaat uit de database
        java.util.List results2 = Wielwijk.db.query("SELECT * FROM users WHERE id="+ id);
        java.util.Map<String, Object> map2 = (HashMap<String, Object>) results2.get(0);
        long expResult = (Long)map2.get("id");
        //vergelijking
        assertEquals(expResult, result);
        // wis de user weer
        UserContainer.removeUser(id);
    }

    /**
     * Test of getName method, of class User.
     */
    @Test
    public void testGetName() {
        //Maakt een nieuwe user
        UserContainer.addMember("bla", "bla", 1, "bla", "2012-12-12");
        //Haalt hoogste id op, oftewel de zojuist gemaakte user
        java.util.List results = Wielwijk.db.query("SELECT * FROM users WHERE id IN (SELECT MAX( id )FROM users)");
        java.util.Map<String, Object> map = (HashMap<String, Object>) results.get(0);
        int id = Integer.parseInt(String.valueOf((Long)map.get("id")));
        //De test van de getName functie
        User test=UserContainer.getUserById(id);
        String result = test.getName();
        //verwacht resultaat uit de database
        java.util.List results2 = Wielwijk.db.query("SELECT * FROM users WHERE id="+ id);
        java.util.Map<String, Object> map2 = (HashMap<String, Object>) results2.get(0);
        String expResult = (String)map2.get("name");
        //vergelijking
        assertEquals(expResult, result);
        //wis de user weer
        UserContainer.removeUser(id);
    }

    /**
     * Test of getPassword method, of class User.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        //maakt test user
        UserContainer.addMember("bla", "bla", 1, "bla", "2012-12-12");
        //Haalt hoogste id op, oftewel de zojuist gemaakte user 
        java.util.List results = Wielwijk.db.query("SELECT * FROM users WHERE id IN (SELECT MAX( id )FROM users)");
        java.util.Map<String, Object> map = (HashMap<String, Object>) results.get(0);
        int id = Integer.parseInt(String.valueOf((Long)map.get("id")));
        //De test van de getPassword functie
        User test=UserContainer.getUserById(id);
        String result = test.getPassword();
        //verwacht resultaat uit de database
        java.util.List results2 = Wielwijk.db.query("SELECT * FROM users WHERE id="+ id);
        java.util.Map<String, Object> map2 = (HashMap<String, Object>) results2.get(0);
        String expResult = (String)map2.get("password");
        //vergelijking
        assertEquals(expResult, result);
        UserContainer.removeUser(id);
    }

    /**
     * Test of getAddress method, of class User.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        //maakt test user
        UserContainer.addMember("bla", "bla", 1, "bla", "2012-12-12");
        //Haalt hoogste id op, oftewel de zojuist gemaakte user 
        java.util.List results = Wielwijk.db.query("SELECT * FROM users WHERE id IN (SELECT MAX( id )FROM users)");
        java.util.Map<String, Object> map = (HashMap<String, Object>) results.get(0);
        int id = Integer.parseInt(String.valueOf((Long)map.get("id")));
        //De test van de getAdress functie
        User test=UserContainer.getUserById(id);
        String result = test.getAddress();
        //verwacht resultaat uit de database
        java.util.List results2 = Wielwijk.db.query("SELECT * FROM users WHERE id="+ id);
        java.util.Map<String, Object> map2 = (HashMap<String, Object>) results2.get(0);
        String expResult = (String)map2.get("address");
        //vergelijking
        assertEquals(expResult, result);
        UserContainer.removeUser(id);
    }

    /**
     * Test of getPicture method, of class User.
     */
    @Test
    public void testGetPicture() {
        System.out.println("getPicture");
        //maakt test user
        UserContainer.addMember("bla", "bla", 1, "bla", "2012-12-12");
        //Haalt hoogste id op, oftewel de zojuist gemaakte user 
        java.util.List results = Wielwijk.db.query("SELECT * FROM users WHERE id IN (SELECT MAX( id )FROM users)");
        java.util.Map<String, Object> map = (HashMap<String, Object>) results.get(0);
        int id = Integer.parseInt(String.valueOf((Long)map.get("id")));
        //De test van de getPicture functie
        User test=UserContainer.getUserById(id);
        int result = test.getPicture();
        //verwacht resultaat uit de database
        java.util.List results2 = Wielwijk.db.query("SELECT * FROM users WHERE id="+ id);
        java.util.Map<String, Object> map2 = (HashMap<String, Object>) results2.get(0);
        int expResult = (Integer)map2.get("picture");
        //vergelijking
        assertEquals(expResult, result);
        UserContainer.removeUser(id);
    }

    /**
     * Test of isActive method, of class User.
     */
    @Test
    public void testIsActive() {
        System.out.println("isActive");
        //maakt test user
        UserContainer.addMember("bla", "bla", 1, "bla", "2012-12-12");
        //Haalt hoogste id op, oftewel de zojuist gemaakte user 
        java.util.List results = Wielwijk.db.query("SELECT * FROM users WHERE id IN (SELECT MAX( id )FROM users)");
        java.util.Map<String, Object> map = (HashMap<String, Object>) results.get(0);
        int id = Integer.parseInt(String.valueOf((Long)map.get("id")));
        //De test van de isActive functie
        User test=UserContainer.getUserById(id);
        boolean result = test.isActive();
        //verwacht resultaat uit de database
        java.util.List results2 = Wielwijk.db.query("SELECT * FROM users WHERE id="+ id);
        java.util.Map<String, Object> map2 = (HashMap<String, Object>) results2.get(0);
        boolean expResult = (Boolean)map2.get("active");
        //vergelijking
        assertEquals(expResult, result);
        UserContainer.removeUser(id);
    }

    /**
     * Test of isBoard method, of class User.
     */
    @Test
    public void testIsBoard() {
        System.out.println("isBoard");
        //maakt test user
        UserContainer.addMember("bla", "bla", 1, "bla", "2012-12-12");
        //Haalt hoogste id op, oftewel de zojuist gemaakte user 
        java.util.List results = Wielwijk.db.query("SELECT * FROM users WHERE id IN (SELECT MAX( id )FROM users)");
        java.util.Map<String, Object> map = (HashMap<String, Object>) results.get(0);
        int id = Integer.parseInt(String.valueOf((Long)map.get("id")));
        //De test van de isBoard functie
        User test=UserContainer.getUserById(id);
        boolean result = test.isBoard();
        //verwacht resultaat uit de database
        java.util.List results2 = Wielwijk.db.query("SELECT * FROM users WHERE id="+ id);
        java.util.Map<String, Object> map2 = (HashMap<String, Object>) results2.get(0);
        boolean expResult = (Boolean)map2.get("board");
        //vergelijking
        assertEquals(expResult, result);
        UserContainer.removeUser(id);
    }

    /**
     * Test of toString method, of class User.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        //maakt test user
        UserContainer.addMember("bla", "bla", 1, "bla", "2012-12-12");
        //Haalt hoogste id op, oftewel de zojuist gemaakte user 
        java.util.List results = Wielwijk.db.query("SELECT * FROM users WHERE id IN (SELECT MAX( id )FROM users)");
        java.util.Map<String, Object> map = (HashMap<String, Object>) results.get(0);
        int id = Integer.parseInt(String.valueOf((Long)map.get("id")));
        //De test van de isBoard functie
        User test=UserContainer.getUserById(id);
        String result = test.toString();
        //verwacht resultaat uit de database
        java.util.List results2 = Wielwijk.db.query("SELECT * FROM users WHERE id="+ id);
        java.util.Map<String, Object> map2 = (HashMap<String, Object>) results2.get(0);
        String expResult = (String)map2.get("name");
        //vergelijking
        assertEquals(expResult, result);
        UserContainer.removeUser(id);
    }
}
