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
    
    JPanel left, right;
    
    private JLabel selected_user;
    
    private long active_user;
    
    private JList myList;
    
    private JPanel jPanel1, jPanel2, jPanel3, jPanel4;
    private JTabbedPane jTabbedPane1;
    
    public ControlWindow() {
        // GUI opzetten
        JPanel window = new JPanel();
        int window_id = Wielwijk.gui.addWindow(window);

        JPanel container = new JPanel();
                
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
        BorderLayout jPanel2Layout = new BorderLayout();
        jPanel2.setLayout(jPanel2Layout);
        
        Border empty = BorderFactory.createMatteBorder(20, 20, 20, 20, Wielwijk.gui.getBackground());
        jPanel2.setBorder(empty);
        
        JPanel content = new JPanel(new GridLayout(1, 2));
        
        // Links
        JPanel panel = new JPanel(new BorderLayout());
        JPanel layout = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Leden");
        title.setFont(title.getFont().deriveFont(20.0f));
        layout.add(title, BorderLayout.NORTH);
        layout.add(Box.createRigidArea(new Dimension(0, 20)), BorderLayout.CENTER);
        
        panel.add(layout, BorderLayout.NORTH);
        
        java.util.List res = Wielwijk.db.query("SELECT * FROM users");
        ArrayList<User> data = new ArrayList<User>();
        for (int i = 0; i < res.size(); i++) {
            Map<String, Object> map = (HashMap<String, Object>) res.get(i);
            User user;
            user = new User((String) map.get("name"), (String) map.get("password"), (Integer) map.get("picture"), (String) map.get("address"), (String) map.get("birthdate").toString(), (Boolean) map.get("board"), (Long) map.get("id"));
            
            data.add(user);
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
        
        final JLabel selected_user = new JLabel();
        selected_user.setFont(selected_user.getFont().deriveFont(20.0f));
        panel2.add(selected_user, BorderLayout.NORTH);
        
        JPanel form = new JPanel(new GridLayout(4,1));
        
        JLabel label4 = new JLabel();
        label4.setText("Gebruikersnaam:");
        label4.setFont(label4.getFont().deriveFont(14.0f));
        JPanel wrapper = new JPanel(new BorderLayout());
        final JTextField username = new JTextField(15);
        wrapper.add(Box.createRigidArea(new Dimension(0, 20)), BorderLayout.NORTH);
        wrapper.add(username, BorderLayout.CENTER);
        form.add(label4);
        form.add(wrapper);

        JLabel label3 = new JLabel();
        label3.setText("Wachtwoord:");
        label3.setFont(label3.getFont().deriveFont(14.0f));
        JPanel wrapper2 = new JPanel(new BorderLayout());
        final JTextField password = new JTextField(15);
        wrapper2.add(Box.createRigidArea(new Dimension(0, 20)), BorderLayout.NORTH);
        wrapper2.add(password, BorderLayout.CENTER);
        form.add(label3);
        form.add(wrapper2);

        JLabel label5 = new JLabel();
        label5.setText("Adres:");
        label5.setFont(label5.getFont().deriveFont(14.0f));
        JPanel wrapper6 = new JPanel(new BorderLayout());
        final JTextField address = new JTextField(15);
        wrapper6.add(Box.createRigidArea(new Dimension(0, 20)), BorderLayout.NORTH);
        wrapper6.add(address, BorderLayout.CENTER);
        form.add(label5);
        form.add(wrapper6);

        JLabel label2 = new JLabel();
        label2.setText("Geboortedatum:");
        label2.setFont(label2.getFont().deriveFont(14.0f));
        JPanel wrapper5 = new JPanel(new BorderLayout());
        final JTextField birthdate = new JTextField(15);
        wrapper5.add(Box.createRigidArea(new Dimension(0, 20)), BorderLayout.NORTH);
        wrapper5.add(birthdate, BorderLayout.CENTER);
        form.add(label2);
        form.add(wrapper5);
        
        panel2.add(form, BorderLayout.CENTER);
        
        content.add(panel2);
        
        jPanel2.add(content, BorderLayout.NORTH);
        
        jPanel2.add(Box.createRigidArea(new Dimension(0, 20)), BorderLayout.CENTER);
        
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
        
        jPanel2.add(footer, BorderLayout.SOUTH);

        jTabbedPane1.addTab("Leden", jPanel2);

        // 3 Activiteiten
        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);

        jTabbedPane1.addTab("Activiteiten", jPanel3);

        // 4 Financien
        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);

        jTabbedPane1.addTab("Financiën", jPanel4);
        
        jTabbedPane1.setSelectedIndex(1);

        // Toevoegen aan GUI
        container.add(jTabbedPane1);
        
        Wielwijk.gui.addElement(window_id, container);
        
        ListSelectionListener listSelectionListener = new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                JList list = (JList) listSelectionEvent.getSource();
                User user = (User) list.getSelectedValue();
                System.out.println(user);
                selected_user.setText(user.getName());
                username.setText(user.getName());
                password.setText(user.getPassword());
                address.setText(user.getAddress());
                birthdate.setText(user.getBirthdate());
                active_user = user.getId();
            }
        };
        myList.addListSelectionListener(listSelectionListener);
        
        add.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                //String name, String password, int picture, String address, String birthdate
                User user = (User) UserContainer.addMember("Jan Modaal", "", 0, "", "2012-12-18");
                repaintList();
                selected_user.setText(user.getName());
                username.setText(user.getName());
                password.setText(user.getPassword());
                address.setText(user.getAddress());
                birthdate.setText(user.getBirthdate());
                active_user = user.getId();
            }
        });
        
        save.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                String dusername = username.getText();
                String dpassword = password.getText();
                String daddress = address.getText();
                String dbirthdate = birthdate.getText();
                if (!isValidDate(dbirthdate)) {
                    JOptionPane.showMessageDialog(null, "De datum die u heeft ingevoerd is invalide");
                } else {
                    Wielwijk.db.exec("UPDATE users SET name = '" + dusername + "', password = '" + dpassword + "', address = '" + daddress + "', birthdate = '" + dbirthdate + "' WHERE id = " + active_user);
                    
                    repaintList();
                    JOptionPane.showMessageDialog(null, "Lid is succesvol aangepast");
                }
            }
        });
        
        delete.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                selected_user.setText("");
                username.setText("");
                password.setText("");
                address.setText("");
                birthdate.setText("");
                Wielwijk.db.exec("DELETE FROM users WHERE id = " + active_user);
                repaintList();
                JOptionPane.showMessageDialog(null, "Lid is succesvol verwijderd");
            }
        });
     }
    
    public void repaintList() {
        java.util.List res = Wielwijk.db.query("SELECT * FROM users");
        ArrayList<User> data = new ArrayList<User>();
        for (int i = 0; i < res.size(); i++) {
            Map<String, Object> map = (HashMap<String, Object>) res.get(i);
            User user;
            user = new User((String) map.get("name"), (String) map.get("password"), (Integer) map.get("picture"), (String) map.get("address"), (String) map.get("birthdate").toString(), (Boolean) map.get("board"), (Long) map.get("id"));
            
            data.add(user);
        }
        myList.setListData(data.toArray());
        
    }
    
    // date validation using SimpleDateFormat
    // it will take a string and make sure it's in the proper 
    // format as defined by you, and it will also make sure that
    // it's a legal date

    public boolean isValidDate(String date)
    {
        // set date format, this can be changed to whatever format
        // you want, MM-dd-yyyy, MM.dd.yyyy, dd.MM.yyyy etc.
        // you can read more about it here:
        // http://java.sun.com/j2se/1.4.2/docs/api/index.html

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // declare and initialize testDate variable, this is what will hold
        // our converted string

        Date testDate = null;

        // we will now try to parse the string into date form
        try
        {
          testDate = sdf.parse(date);
        }

        // if the format of the string provided doesn't match the format we 
        // declared in SimpleDateFormat() we will get an exception

        catch (ParseException e)
        {
            String errorMessage;
          errorMessage = "the date you provided is in an invalid date" +
                                  " format.";
          return false;
        }

        // dateformat.parse will accept any date as long as it's in the format
        // you defined, it simply rolls dates over, for example, december 32 
        // becomes jan 1 and december 0 becomes november 30
        // This statement will make sure that once the string 
        // has been checked for proper formatting that the date is still the 
        // date that was entered, if it's not, we assume that the date is invalid

        if (!sdf.format(testDate).equals(date)) 
        {
          String errorMessage = "The date that you provided is invalid.";
          return false;
        }

        // if we make it to here without getting an error it is assumed that
        // the date was a valid one and that it's in the proper format

        return true;

    } // end isValidDate
    
  }

