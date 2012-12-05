package wielwijk;

import java.awt.*;
import javax.swing.*;
import java.util.*;

/**
 *
 * @author jeroen
 */
public class GUI extends JFrame {
    
    ArrayList<JPanel> windows = new ArrayList<JPanel>();
    
    private int window_count = 0;
    
    private int active_window_id;
    
    GUI() {
        setTitle("Wandelvereniging Wielwijk");
        setSize(1000, 600);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
  
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    public int addWindow(JPanel window) {
        int window_id = window_count;
        window_count = window_count + 1;
        System.out.println("Window ID: " + window_id);
        
        windows.add(window_id, window);
        getContentPane().add(windows.get(window_id));
        
        return window_id;
    }
    
    public void addElement(int window_id, Component element) {
        JPanel window = windows.get(window_id);
        window.add(element);
    }
    
    public void removeWindow(int window_id) {
        
    }
    
    public void showWindow(int window_id) {
        getContentPane().remove(active_window_id);
                
        active_window_id = window_id;
        
        getContentPane().add(windows.get(window_id));
        
        setVisible(true);
    }
    
}
