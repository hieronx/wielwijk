package wielwijk;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author jeroen
 */
public class UserListWindow extends JFrame {
  
  /**
   * The text area.
   */
  JTextArea myText = new JTextArea("My text");
 
  private JLabel label; 
  
  JPanel panel, layout;
  
  //BufferedImage myPicture;
  
  /**
   * The top level panel which holds all.
   */
  JPanel container = new JPanel();
  
  public UserListWindow() { 
    container.setLayout(new GridLayout(3, 2));

    java.util.List res = Wielwijk.db.query("SELECT * FROM users");
    
    String usernames = "USERS\n";
    for (int i = 0; i < res.size(); i++) {
        Map<String, Object> map = (HashMap<String, Object>) res.get(i);
        
        panel = new JPanel(new BorderLayout());
        //panel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        
        
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
    
    getContentPane().add(container, BorderLayout.CENTER);
  
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
  }
 
  /**
   * The program    * @param args the program start up parameters, not used.
   */
  public static void main(String[] args) {
    try {
        UserListWindow frame = new UserListWindow();
        frame.setSize(800, 600);
        frame.setVisible(true);
        
    }
    catch(Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
  }
    
}
