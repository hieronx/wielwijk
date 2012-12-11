package wielwijk;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.*;

/**
 *
 * @author jeroen
 */
public class UserListWindow {

  private JLabel label; 
  
  JPanel panel, layout, container;
  
  public UserListWindow() {
    JPanel window = new JPanel();
    int window_id = Wielwijk.gui.addWindow(window);
         
    JPanel container = new JPanel();
    container.setLayout(new GridLayout(3, 2));

    java.util.List res = Wielwijk.db.query("SELECT * FROM users");
    
    String usernames = "USERS\n";
    for (int i = 0; i < res.size(); i++) {
        Map<String, Object> map = (HashMap<String, Object>) res.get(i);
        
        panel = new JPanel(new BorderLayout());
        
        layout = new JPanel();
        layout.add(Box.createRigidArea(new Dimension(0, 50)));
        label = new JLabel();
        label.setText((String) map.get("name"));
        layout.add(label);
        panel.add(layout, BorderLayout.NORTH);
        
        JLabel iconLabel = new JLabel(new ImageIcon("pic.jpg"));
        panel.add(iconLabel, BorderLayout.CENTER);
        
        container.add(panel);
    }
    
    Wielwijk.gui.addElement(window_id, container);
  }
}