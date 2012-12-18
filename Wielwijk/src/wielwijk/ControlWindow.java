package wielwijk;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import javax.swing.event.*;
import java.text.*;

/**
 *
 * @author jeroen
 */
public class ControlWindow {
    
    private JPanel overviewpanel, userpanel, activitypanel, financepanel;
    private JTabbedPane jTabbedPane1;

    public ControlWindow() {
        // GUI opzetten
        JPanel window = new JPanel();
        int window_id = Wielwijk.gui.addWindow(window);

        JPanel container = new JPanel();
        
        // Tabs aanmaken
        jTabbedPane1 = new JTabbedPane();
        overviewpanel = new JPanel();
        userpanel = new JPanel();
        activitypanel = new JPanel();
        financepanel = new JPanel();

        // 1 Overzicht
        JPanel overviewpanel = new OverviewPanel();
        jTabbedPane1.addTab("Overzicht", overviewpanel);
        
        // 2 Leden
        JPanel userpanel = new UserPanel();
        jTabbedPane1.addTab("Leden", userpanel);

        // 3 Activiteiten
        JPanel activitypanel = new ActivityPanel();
        jTabbedPane1.addTab("Activiteiten", activitypanel);

        // 4 Financien
        JPanel financepanel = new FinancePanel();
        jTabbedPane1.addTab("Financiën", financepanel);
        
        jTabbedPane1.setSelectedIndex(1);

        // Toevoegen aan GUI
        container.add(jTabbedPane1);
        
        Wielwijk.gui.addElement(window_id, container);    
    }
}