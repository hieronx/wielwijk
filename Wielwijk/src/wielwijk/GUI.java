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
    
    private int window_count = 0;
    private int active_window_id;
    private int last_id;
    
    GUI() {
        // Basis instellingen
        setTitle("Wandelvereniging Wielwijk");
        setSize(1024, 768);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setResizable(false);
                
        // Menu
        JMenuBar menubar = new JMenuBar();

        JMenu file = new JMenu("Bestand");
        file.setMnemonic(KeyEvent.VK_F);

        JMenuItem eMenuItem = new JMenuItem("Afsluiten");
        eMenuItem.setMnemonic(KeyEvent.VK_C);
        eMenuItem.setToolTipText("Sluit programma af");
        eMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }

        });

        file.add(eMenuItem);

        menubar.add(file);

        setJMenuBar(menubar);

        // Theme a la OS
        try{UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
        catch(Exception e){}
        
        // Correct afsluiten
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    public int addWindow(JPanel window) {
        int window_id = window_count;
        window_count = window_count + 1;
        
        windows.add(window_id, window);
        
        last_id = window_id;
        
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
    
    public void showWindow(int window_id) {
        System.out.println("BELANGRIJK: Replaced window #" + active_window_id + " with window #" + window_id + " (with ID)");
        
        if (window_id > 0) getContentPane().remove(active_window_id);
                
        active_window_id = window_id;
        
        getContentPane().add(windows.get(window_id));
        
        setVisible(true);
    }
    
    public void showWindow() {
        final int window_id = getLastId();
        
        System.out.println("Replaced window #" + active_window_id + " with window #" + window_id + " (without ID)");
                
        if (window_id > 0) getContentPane().remove(0);
                
        active_window_id = window_id;
        
        if (window_id > 0) {
            JPanel wrapper = new JPanel(new BorderLayout());
            JPanel panel = windows.get(window_id);
            JPanel alignment = new JPanel(new BorderLayout());
            Border empty = BorderFactory.createMatteBorder(0, 0, 20, 20, Wielwijk.gui.getBackground());
            alignment.setBorder(empty);
            JButton terug = new JButton("Ga terug");
            alignment.add(terug, BorderLayout.EAST);
            wrapper.add(panel, BorderLayout.NORTH);
            wrapper.add(alignment, BorderLayout.SOUTH);
            getContentPane().add(wrapper);
        
            terug.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent e) {
                    //getContentPane().remove(0);
                    int new_id = window_id - 1;
                    getContentPane().add(windows.get(new_id));
                    active_window_id = new_id;
                    System.out.println("Ga terug naar: " + new_id);
                    System.out.println("COmponent: " + windows.get(new_id).toString());
                }
            });
        } else {
            getContentPane().add(windows.get(window_id));
        }
        
        System.out.println("Aantal components: " + getComponentCount());
        
        setVisible(true);
    }
    
    public int getLastId() {
        return last_id;
    }
    
}
