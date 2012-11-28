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
 
  /**
   * The top level panel which holds all.
   */
  JPanel holdAll = new JPanel();
  
  public UserListWindow()
  { 
    holdAll.setLayout(new BorderLayout());
    holdAll.add(myText, BorderLayout.CENTER);
    
    Database db = new Database();
    db.connect();

    java.util.List res = db.query("SELECT * FROM users");

    String usernames = "USERS\n";
    for (int i = 0; i < res.size(); i++) {
        Map<String, Object> map = (HashMap<String, Object>) res.get(i);
        usernames = usernames + "\n" + map.get("name");
    }
    
    myText.setText(usernames);
    
    getContentPane().add(holdAll, BorderLayout.CENTER);
  
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
  }
 
  /**
   * The program    * @param args the program start up parameters, not used.
   */
  public static void main(String[] args)
  {
    UserListWindow myApplication = new UserListWindow();
 
    // Specify where will it appear on the screen:
    myApplication.setLocation(10, 10);
    myApplication.setSize(300, 300);
 
    // Show it!
    myApplication.setVisible(true);
  }
    
}
