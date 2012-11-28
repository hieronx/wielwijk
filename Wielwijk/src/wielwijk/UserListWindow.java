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
public class UserListWindow extends JFrame {
  
  /**
   * The text area.
   */
  JTextArea myText = new JTextArea("My text");
 
  private JLabel label, label2, label3, label4, label5;  
  
  /**
   * The top level panel which holds all.
   */
  JPanel container = new JPanel();
  
  public UserListWindow() { 
    container.setLayout(new GridLayout(3, 2));
    
    Database db = new Database();
    db.connect();

    java.util.List res = db.query("SELECT * FROM users");

    String usernames = "USERS\n";
    for (int i = 0; i < res.size(); i++) {
        Map<String, Object> map = (HashMap<String, Object>) res.get(i);        
        label = new JLabel();
        label.setText((String) map.get("name") + " uit " + map.get("address"));
        container.add(label);
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
