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
public class CalendarWindow extends JFrame {
    
    JPanel container = new JPanel();
    JPanel panel;
    JLabel label;
    
    public CalendarWindow() {
        container.setLayout(new GridLayout(7, 5));
        container.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        
        for (int i = 0; i < 35; i++) {
            JLabel label = new JLabel();
            label.setText("Activiteit " + (i+1));
            
            JPanel panel = new JPanel();
            panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            panel.add(Box.createRigidArea(new Dimension(0, 60)));
            panel.add(label);
            
            container.add(panel);
        }
        add(container);
    }
    
    /**
     * The program    * @param args the program start up parameters, not used.
     */
    public static void main(String[] args) {
        try {
            CalendarWindow frame = new CalendarWindow();
            frame.setSize(800, 600);
            frame.setVisible(true);
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
}
