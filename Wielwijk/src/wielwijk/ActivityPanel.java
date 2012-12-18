package wielwijk;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author jeroen
 */
public class ActivityPanel extends JPanel {
    
    public ActivityPanel() {
        GridLayout layout = new GridLayout();
        setLayout(layout);
        
        add(Box.createRigidArea(new Dimension(480, 50)));
        
        JLabel label1 = new JLabel("Activiteitenoverzicht");
        add(label1);
    }
    
}