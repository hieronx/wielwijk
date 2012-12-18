package wielwijk;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author jeroen
 */
public class FinancePanel extends JPanel {
    
    public FinancePanel() {
        GridLayout layout = new GridLayout();
        setLayout(layout);
        
        add(Box.createRigidArea(new Dimension(480, 50)));
        
        JLabel label1 = new JLabel("Financienoverzicht");
        add(label1);
    }
    
}