/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wielwijk;

import java.awt.Component;
import javax.swing.JPanel;
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
public class GUITest {
    
    public GUITest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addWindow method, of class GUI.
     */
    @Test
    public void testAddWindow() {
        System.out.println("addWindow");
        JPanel window = null;
        GUI instance = new GUI();
        int expResult = 0;
        int result = instance.addWindow(window);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addElement method, of class GUI.
     */
    @Test
    public void testAddElement() {
        System.out.println("addElement");
        int window_id = 0;
        Component element = null;
        GUI instance = new GUI();
        instance.addElement(window_id, element);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeWindow method, of class GUI.
     */
    @Test
    public void testRemoveWindow() {
        System.out.println("removeWindow");
        int window_id = 0;
        GUI instance = new GUI();
        instance.removeWindow(window_id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showWindow method, of class GUI.
     */
    @Test
    public void testShowWindow() {
        System.out.println("showWindow");
        int window_id = 0;
        GUI instance = new GUI();
        instance.showWindow(window_id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
