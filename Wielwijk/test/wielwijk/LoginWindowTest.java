/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wielwijk;

import java.util.HashMap;
import java.util.Map;
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
public class LoginWindowTest {
    
    public LoginWindowTest() {
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

    @Test
    public void LoginTest(){
        String testusername = "a";
        String correctpw = "b";
        String wrongpw = "d";
        Boolean passed1 = false;
        Boolean passed2 =false;
        
        java.util.List res = Wielwijk.db.query("SELECT COUNT(*) AS c FROM users WHERE name = '" + testusername + "' AND password = '" + correctpw + "'");
                Map<String, Object> map = (HashMap<String, Object>) res.get(0);
                if ((Long) map.get("c") == 1) {
                    passed1 = true;
                }
                java.util.List res2 = Wielwijk.db.query("SELECT COUNT(*) AS c FROM users WHERE name = '" + testusername + "' AND password = '" + wrongpw + "'");
                Map<String, Object> map2 = (HashMap<String, Object>) res2.get(0);
                if ((Long) map2.get("c") == 0) {
                    passed2 = true;
                }
                
    assertEquals(passed1,true);
    assertEquals(passed2,true);    
    }
}
