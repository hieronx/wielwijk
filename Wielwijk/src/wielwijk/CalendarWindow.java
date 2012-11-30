package wielwijk;


import java.awt.*;
import javax.swing.*;

/**
 *
 * @author jeroen
 */
public class CalendarWindow extends JFrame {
    
    JPanel calendar = new JPanel();
    JPanel panel, item, layout, layout2;
    JLabel month, label, index;
    
    public CalendarWindow() {
        getContentPane().setLayout(new BorderLayout());
        
        JPanel layout = new JPanel();
        JLabel month = new JLabel();
        month.setText("November");
        month.setFont(month.getFont().deriveFont(26.0f));
        layout.add(month);
        add(layout, BorderLayout.NORTH);
        
        calendar.setLayout(new GridLayout(7, 5));
        calendar.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        
        for (int i = 1; i <= 30; i++) {
            JPanel item = new JPanel(new BorderLayout());
            
            JPanel layout2 = new JPanel();
            JLabel index = new JLabel();
            index.setText(Integer.toString(i));
            layout2.add(index);
            layout2.add(Box.createRigidArea(new Dimension(30, 0)));
            item.add(layout2, BorderLayout.WEST);
            
            JLabel label = new JLabel();
            label.setText("Activiteit");
            item.add(Box.createRigidArea(new Dimension(0, 60)), BorderLayout.CENTER);
            item.add(label, BorderLayout.CENTER);
            
            JPanel panel = new JPanel();
            panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            panel.add(item);
            
            calendar.add(panel);
        }
        add(calendar, BorderLayout.CENTER);
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
