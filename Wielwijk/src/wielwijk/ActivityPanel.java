package wielwijk;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.*;

/**
 *
 * @author jeroen
 */
public class ActivityPanel extends JPanel {
    
    JPanel left, right;
    private JLabel selected_act;
    private long active_act;
    private JList myList;
    SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    SimpleDateFormat onlyDate = new SimpleDateFormat("yyyy-MM-dd");
    
    public ActivityPanel() {
        isoFormat.setTimeZone(TimeZone.getTimeZone("CET"));
        
        BorderLayout jPanel2Layout = new BorderLayout();
        setLayout(jPanel2Layout);
        
        Border empty = BorderFactory.createMatteBorder(20, 20, 20, 20, Wielwijk.gui.getBackground());
        setBorder(empty);
        
        JPanel content = new JPanel(new GridLayout(1, 2));
        
        // Links
        JPanel panel = new JPanel(new BorderLayout());
        JPanel layout = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Activiteiten");
        title.setFont(title.getFont().deriveFont(20.0f));
        layout.add(title, BorderLayout.NORTH);
        layout.add(Box.createRigidArea(new Dimension(0, 20)), BorderLayout.CENTER);
        
        panel.add(layout, BorderLayout.NORTH);
        
        java.util.List res = Wielwijk.db.query("SELECT *, DATE_FORMAT(lower_limit_date, '%Y-%m-%d') as lld FROM activities");
        ArrayList<Activity> data = new ArrayList<Activity>();
        for (int i = 0; i < res.size(); i++) {
            Map<String, Object> map = (HashMap<String, Object>) res.get(i);
            Activity act;
            act = new Activity(
                (String) map.get("name"),
                (String) map.get("location"),
                (String) map.get("description"),
                new Date((Long) map.get("datetime_begin")*1000),
                new Date((Long) map.get("datetime_end")*1000),
                (Integer) map.get("fee"),
                (Integer) map.get("lower_user_limit"),
                (Integer) map.get("upper_user_limit"),
                (String) map.get("lld"),
                (Boolean) map.get("cancelled"),
                (Long) map.get("id")
            );
            
            data.add(act);
        }
        myList = new JList(data.toArray());
        myList.setFont(myList.getFont().deriveFont(16.0f));
        myList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JScrollPane pane = new JScrollPane(myList);
        Border invis = BorderFactory.createMatteBorder(0, 0, 0, 160, Wielwijk.gui.getBackground());
        pane.setBorder(invis);
        
        panel.add(pane, BorderLayout.CENTER);
        
        content.add(panel);
        
        // Rechts
        JPanel panel2 = new JPanel(new BorderLayout());
        Border empty2 = BorderFactory.createMatteBorder(0, 20, 0, 0, Wielwijk.gui.getBackground());
        panel2.setBorder(empty2);
        
        final JLabel selected_act = new JLabel();
        selected_act.setFont(selected_act.getFont().deriveFont(20.0f));
        panel2.add(selected_act, BorderLayout.NORTH);
        
        JPanel form = new JPanel(new GridLayout(4,1));
        
        // Naam
        JLabel label4 = new JLabel();
        label4.setText("Naam:");
        label4.setFont(label4.getFont().deriveFont(14.0f));
        JPanel wrapper = new JPanel(new BorderLayout());
        final JTextField name = new JTextField(15);
        wrapper.add(Box.createRigidArea(new Dimension(0, 20)), BorderLayout.NORTH);
        wrapper.add(name, BorderLayout.CENTER);
        form.add(label4);
        form.add(wrapper);

        // Locatie
        JLabel label5 = new JLabel();
        label5.setText("Locatie:");
        label5.setFont(label5.getFont().deriveFont(14.0f));
        JPanel wrapper6 = new JPanel(new BorderLayout());
        final JTextField location = new JTextField(15);
        wrapper6.add(Box.createRigidArea(new Dimension(0, 20)), BorderLayout.NORTH);
        wrapper6.add(location, BorderLayout.CENTER);
        form.add(label5);
        form.add(wrapper6);

        // Beschrijving
        JLabel label3 = new JLabel();
        label3.setText("Beschrijvijng:");
        label3.setFont(label3.getFont().deriveFont(14.0f));
        JPanel wrapper2 = new JPanel(new BorderLayout());
        final JTextField description = new JTextField(15);
        wrapper2.add(Box.createRigidArea(new Dimension(0, 20)), BorderLayout.NORTH);
        wrapper2.add(description, BorderLayout.CENTER);
        form.add(label3);
        form.add(wrapper2);

        // Datetime begin
        JLabel label2 = new JLabel();
        label2.setText("Begindatum:");
        label2.setFont(label2.getFont().deriveFont(14.0f));
        JPanel wrapper5 = new JPanel(new BorderLayout());
        
        final JTextField datetime_begin = new JTextField(15);
        JLabel label_dateformat = new JLabel("YYYY-MM-DD");
        label_dateformat.setForeground(new Color(100, 100, 100));
        
        wrapper5.add(Box.createRigidArea(new Dimension(0, 20)), BorderLayout.NORTH);
        wrapper5.add(datetime_begin, BorderLayout.CENTER);
        wrapper5.add(label_dateformat, BorderLayout.SOUTH); 
       
        form.add(label2);
        form.add(wrapper5);
        
        // Panels enzo
        panel2.add(form, BorderLayout.CENTER);
        
        content.add(panel2);
        
        add(content, BorderLayout.NORTH);
        
        add(Box.createRigidArea(new Dimension(0, 20)), BorderLayout.CENTER);
        
        JPanel footer = new JPanel(new GridLayout(1, 2));
        
        JPanel wrapper3 = new JPanel(new BorderLayout());
        JButton add = new JButton("Toevoegen");
        wrapper3.add(add, BorderLayout.WEST);
        footer.add(wrapper3);
        
        JPanel wrapper4 = new JPanel(new BorderLayout());
        Border empty3 = BorderFactory.createMatteBorder(0, 20, 0, 0, Wielwijk.gui.getBackground());
        wrapper4.setBorder(empty3);
        
        JButton save = new JButton("Opslaan");
        wrapper4.add(save, BorderLayout.WEST);
        
        JButton delete = new JButton("Verwijderen");
        wrapper4.add(delete, BorderLayout.EAST);
        footer.add(wrapper4);
        
        add(footer, BorderLayout.SOUTH);

        ListSelectionListener listSelectionListener = new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                JList list = (JList) listSelectionEvent.getSource();
                Activity act = (Activity) list.getSelectedValue();
                
                if (act != null) {
                    selected_act.setText(act.getName());
                    name.setText(act.getName());
                    location.setText(act.getLocation());
                    description.setText(act.getDescription());
                    datetime_begin.setText(onlyDate.format(act.getDatetimeBegin()));
                    active_act = act.getId();
                }
            }
        };
        myList.addListSelectionListener(listSelectionListener);
        
        add.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                Date datetime = null;
                try {
                    datetime = isoFormat.parse("2012-12-31T18:00:00");
                } catch(ParseException ex) {
                    System.out.println(ex.getMessage());
                }

                //(String nm, String lc, String des, java.util.Date dtb, java.util.Date dte, int fe, int lul, int uul, String lld, boolean cl, int dis, int ht) {
                Activity act = (Activity) new Hike("-Nieuwe Wandeling", "", "", datetime, datetime, 10, 10, 9000, "2012-12-20", false, 42, 8500);
                repaintList();
                selected_act.setText(act.getName());
                name.setText(act.getName());
                location.setText(act.getLocation());
                description.setText(act.getDescription());
                datetime_begin.setText(act.getDatetimeBegin().toString());
                active_act = act.getId();
            }
        });
        
        save.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                selected_act.setText(name.getText());
                String dname = name.getText();
                String dlocation = location.getText();
                String ddescription = description.getText();
                String ddatetime_begin = datetime_begin.getText();

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date d = null;
                try {
                    d = sdf.parse(ddatetime_begin);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Datum is invalide");
                    return;
                }

                Wielwijk.db.exec("UPDATE activities SET name = '" + dname + "', location = '" + dlocation + "', description = '" + ddescription +
                        "', datetime_begin = '" + d.getTime()/1000 + "' WHERE id = " + active_act);

                repaintList();
                JOptionPane.showMessageDialog(null, "Activiteit is succesvol aangepast");
            }
        });
        
        delete.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                selected_act.setText("");
                name.setText("");
                location.setText("");
                description.setText("");
                datetime_begin.setText("");
                Wielwijk.db.exec("DELETE FROM activities WHERE id = " + active_act);
                repaintList();
                JOptionPane.showMessageDialog(null, "Activiteit is succesvol verwijderd");
            }
        });
    }
    
    public void repaintList() {
        java.util.List res = Wielwijk.db.query("SELECT *, DATE_FORMAT(lower_limit_date, '%Y-%m-%d') as lld FROM activities");
        ArrayList<Activity> data = new ArrayList<Activity>();
        for (int i = 0; i < res.size(); i++) {
            Map<String, Object> map = (HashMap<String, Object>) res.get(i);
            Activity act;
            act = new Activity(
                (String) map.get("name"),
                (String) map.get("location"),
                (String) map.get("description"),
                new Date((Long) map.get("datetime_begin")*1000),
                new Date((Long) map.get("datetime_end")*1000),
                (Integer) map.get("fee"),
                (Integer) map.get("lower_user_limit"),
                (Integer) map.get("upper_user_limit"),
                (String) map.get("lld"),
                (Boolean) map.get("cancelled")
            );
            
            data.add(act);
        }
        myList.setListData(data.toArray());
        
    }
    
}