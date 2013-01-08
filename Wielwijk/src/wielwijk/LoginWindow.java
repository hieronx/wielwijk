package wielwijk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
 
class LoginWindow {
    
    JButton submit, userlist;
    JPanel container, panel, layout, layout2;
    JLabel label, label2,label3;
    BoxLayout window;
    final JTextField text, text2;
    
    static User CurrentUser;
    
    LoginWindow() {
        JPanel window = new JPanel();
        int window_id = Wielwijk.gui.addWindow(window);
        
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        
        // Onzichtbaar blok van 200px hoog
        container.add(Box.createRigidArea(new Dimension(0, 260)));
        
        // Koptekst
        layout = new JPanel();
        layout.setMaximumSize(new Dimension(400, 20));
        label = new JLabel();
        label.setText("Welkom");
        label.setFont(label.getFont().deriveFont(30.0f));
        layout.add(label);
        container.add(layout);
        
        container.add(Box.createRigidArea(new Dimension(0, 20)));
        
        // GridLayout van 3x1 voor formulier
        panel = new JPanel(new GridLayout(3,1));
        panel.setMaximumSize(new Dimension(250, 80));
        
        label2 = new JLabel();
        label2.setText("Gebruikersnaam:");
        label2.setFont(label2.getFont().deriveFont(14.0f));
        text = new JTextField(15);
        panel.add(label2);
        panel.add(text);

        label3 = new JLabel();
        label3.setText("Wachtwoord:");
        label3.setFont(label3.getFont().deriveFont(14.0f));
        text2 = new JPasswordField(15);
        panel.add(label3);
        panel.add(text2);

        container.add(panel);
        
        // Inloggen knop
        layout2 = new JPanel();
        submit = new JButton("Inloggen");
        userlist = new JButton("Gebruikerslijst");
        layout2.add(submit);
        layout2.add(userlist);
        container.add(layout2);
        
        JRootPane rootPane = Wielwijk.gui.getRootPane();
        rootPane.setDefaultButton(submit);
        
        Wielwijk.gui.addElement(window_id, container);
        
        Wielwijk.gui.showWindow();
        
        submit.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                String name = text.getText();
                String password = text2.getText();
                java.util.List res = Wielwijk.db.query("SELECT COUNT(*) AS c, board, active, id FROM users WHERE name = '" + name + "' AND password = '" + password + "'");
                Map<String, Object> map = (HashMap<String, Object>) res.get(0);
                if ((Long) map.get("c") == 1) {
                    if ((Boolean) map.get("active") == true) {
                        CurrentUser = UserContainer.getUserById(((Long)map.get("id")).intValue());
                        if ((Boolean) map.get("board") == true) {
                            ControlWindow control = new ControlWindow();
                            Wielwijk.gui.showWindow();
                        } else {
                            CalendarWindow calendar = new CalendarWindow();
                            Wielwijk.gui.showWindow();
                        }
                    } else {
                    JOptionPane.showMessageDialog(null, "Uw account is gedeactiveerd door een beheerder");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Gebruikersnaam en/of wachtwoord zijn niet correct ingevuld");
                }
            }
        });
        
        userlist.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                UserListWindow userlist = new UserListWindow();
                Wielwijk.gui.showWindow();
            }
        });
    }
}