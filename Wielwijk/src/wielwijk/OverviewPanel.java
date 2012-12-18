package wielwijk;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author jeroen
 */
public class OverviewPanel extends JPanel {
    
    public OverviewPanel() {
        GridLayout layout = new GridLayout();
        setLayout(layout);
        
        add(Box.createRigidArea(new Dimension(480, 50)));
        
        JLabel label1 = new JLabel("Aankomende activiteiten");
        add(label1);
    }
    
}
