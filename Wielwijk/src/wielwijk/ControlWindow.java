package wielwijk;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;

/**
 *
 * @author jeroen
 */
public class ControlWindow {
    
    JPanel left, right;
    
    private JPanel jPanel1, jPanel2, jPanel3, jPanel4;
    private JTabbedPane jTabbedPane1;
    
    public ControlWindow() {
        // GUI opzetten
        JPanel window = new JPanel();
        int window_id = Wielwijk.gui.addWindow(window);

        JPanel container = new JPanel();
        container.setLayout(new GridLayout(1, 2));
        
        // Tabs aanmaken
        jTabbedPane1 = new JTabbedPane();
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jPanel4 = new JPanel();

        // 1 Overzicht
        GridLayout jPanel1Layout = new GridLayout();
        jPanel1.setLayout(jPanel1Layout);
        
        jPanel1.add(Box.createRigidArea(new Dimension(480, 50)));
        
        JLabel label1 = new JLabel("Aankomende activiteiten");
        jPanel1.add(label1);
        
        jTabbedPane1.addTab("Overzicht", jPanel1);

        // 2 Leden
        GridLayout jPanel2Layout = new GridLayout(1, 2);
        jPanel2.setLayout(jPanel2Layout);
        
        //jPanel2.add(Box.createRigidArea(new Dimension(0, 50)));
        
        String[] data = {"Jeroen Offerijns", "Bart Slangewal", "Yannick Verhoog", "Sytze Zeijlmaker"};
        JList myList = new JList(data);
        myList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        myList.setFixedCellWidth(10);
        myList.setSize(100, 100);
        
        JScrollPane pane = new JScrollPane(myList);
        pane.setSize(new Dimension(10, 10));

        jPanel2.add(pane);
        
        JLabel label2 = new JLabel("Bart Slangewal");
        jPanel2.add(label2);

        jTabbedPane1.addTab("Leden", jPanel2);

        // 3 Activiteiten
        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);

        jTabbedPane1.addTab("Activiteiten", jPanel3);

        // 4 Financien
        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);

        jTabbedPane1.addTab("Financiën", jPanel4);

        // Toevoegen aan GUI
        container.add(jTabbedPane1);
        
        Wielwijk.gui.addElement(window_id, container);
        Wielwijk.gui.showWindow(window_id);
     }
    
}
