package wielwijk;

import java.awt.*;
import javax.swing.*;
import java.util.*;

import java.awt.event.*;
import javax.swing.border.Border;

/**
 *
 * @author jeroen
 */
public class GUI extends JFrame {
    
    ArrayList<JPanel> windows = new ArrayList<JPanel>();
    
    ArrayList<Integer> history = new ArrayList<Integer>();
    private int history_count = 0;
    
    private JPanel cards;
    private JPanel terugPanel;
    
    private int window_count = 0;
    private int last_id;
    
    GUI() {
        // Basis instellingen
        setTitle("Wandelvereniging Wielwijk");
        setSize(1024, 768);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setResizable(false);
        
        // Theme a la OS
        try{UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
        catch(Exception e){}
        
        //JPanel maken
        JPanel panel = new JPanel(new BorderLayout());
        getContentPane().add(panel);
        
        //CardLayout Panel maken
        cards = new JPanel(new CardLayout());
        panel.add(cards, BorderLayout.CENTER);
        
        // Terugknop maken
        terugPanel = new JPanel(new BorderLayout());
        Border empty = BorderFactory.createMatteBorder(0, 0, 20, 20, this.getBackground());
        terugPanel.setBorder(empty);
        JButton terug = new JButton("Ga terug");
        terugPanel.add(terug, BorderLayout.EAST);
        panel.add(terugPanel, BorderLayout.SOUTH);
        
        terugPanel.setVisible(false);
        
        terug.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                
                history.remove(history_count-1);
                history_count--;
                
                cl.show(cards, Integer.toString(history.get(history_count-1)));
                
                terugPanel.setVisible(history_count > 1);
            }
        });
        
        // Correct afsluiten
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    public int addWindow(JPanel window) {
        int window_id = window_count;
        window_count = window_count + 1;
        
        windows.add(window_id, window);
        
        last_id = window_id;
        
        cards.add(window, Integer.toString(window_id));
        
        System.out.println("Added window #" + window_id);
        
        return window_id;
    }
    
    public void addElement(int window_id, Component element) {
        JPanel window = windows.get(window_id);
        System.out.println("Added element to window #" + window_id);
        window.add(element);
    }
    
    public void removeWindow(int window_id) {
        
    }
    
    public void showWindow() {
        showWindow(getLastId());
    }
    
    public void showWindow(int window_id) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        
        cl.show(cards, Integer.toString(window_id));
        
        history.add(history_count, window_id);
        history_count++;
        
        terugPanel.setVisible(history_count > 1);
        
        setVisible(true);
    }
    
    public int getLastId() {
        return last_id;
    }
    
}
