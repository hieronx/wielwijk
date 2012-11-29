package wielwijk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
class LoginWindow extends JFrame {
    
    JButton submit, userlist;
    JPanel panel, layout, layout2;
    JLabel label, label2,label3;
    final JTextField text, text2;
    
    LoginWindow() {
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        // Onzichtbaar blok van 200px hoog
        add(Box.createRigidArea(new Dimension(0, 200)));
        
        // Koptekst
        layout = new JPanel();
        layout.setMaximumSize(new Dimension(400, 20));
        label = new JLabel();
        label.setText("Wielwijk wandelvereniging");
        label.setFont(label.getFont().deriveFont(26.0f));
        layout.add(label);
        add(layout);
        
        add(Box.createRigidArea(new Dimension(0, 20)));
        
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

        add(panel);
        
        // Inloggen knop
        layout2 = new JPanel();
        submit = new JButton("Inloggen");
        userlist = new JButton("Gebruikerslijst");
        layout2.add(submit);
        layout2.add(userlist);
        add(layout2);
        
        submit.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                setVisible(false);
                CalendarWindow.main(null);
            } 
        });
        
        userlist.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                setVisible(false);
                UserListWindow.main(null);
            } 
        });
        
        setTitle("Inloggen Wielwijk controlepaneel");
    }
    
    public static void main(String arg[]) {
        try {
            LoginWindow frame = new LoginWindow();
            frame.setSize(800, 600);
            frame.setVisible(true);
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}