package wielwijk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
class LoginWindow extends JFrame {
    
    JButton submit;
    JPanel panel;
    JLabel label1,label2, label3;
    final JTextField  text1,text2;
    
    LoginWindow() {
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        label1 = new JLabel();
        label1.setText("Gebruikersnaam:");
        text1 = new JTextField(15);

        label2 = new JLabel();
        label2.setText("Wachtwoord:");
        text2 = new JPasswordField(15);
        
        label3 = new JLabel();
        label3.setText("Wielwijk wandelvereniging");

        submit = new JButton("Inloggen");

        panel = new JPanel(new GridLayout(3,1));
        panel.setMaximumSize(new Dimension(250, 80));
        panel.add(label1);
        panel.add(text1);
        panel.add(label2);
        panel.add(text2);
        add(Box.createRigidArea(new Dimension(0, 200)));
        add(panel);
        add(submit);
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