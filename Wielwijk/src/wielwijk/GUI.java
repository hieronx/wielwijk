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
    
    
    
    GUI() {
        setTitle("Wandelvereniging Wielwijk");
        setSize(800, 600);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    }
    
    public int addWindow(JPanel window) {
        int window_id = this.windows.size();
        this.windows.add(window_id, window);
        getContentPane().add(this.windows.get(window_id));
        return window_id;
    }
    
    public void addElement(int window_id, Component element) {
        JPanel window = this.windows.get(window_id);
        window.add(element);
    }
    
    public void removeWindow(int window_id) {
        
    }
    
    public void showWindow(int window_id) {
        getContentPane().add(this.windows.get(window_id));
        setVisible(true);
    }
    
}
