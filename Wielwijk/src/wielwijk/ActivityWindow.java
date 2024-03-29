package wielwijk;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.text.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


/**
 *
 * @author ylverhoog
 */
public class ActivityWindow {

    private JLabel name, slaapplaatsen;
    JPanel container, textpanel, leftlayout, rightlayout;
    Activity act;
    Border blackline;
    boolean isAangemeld;
    
    ArrayList<Integer> slaaptIn=new ArrayList<Integer>();
    
    Accommodation eigenAcc;
    Accommodation aangemeldeAcc;
    Accommodation selectAcc;
    
    JPanel slaappanel;
    
    JList myList;

    public ActivityWindow(Activity activity) {
        java.util.List res = Wielwijk.db.query("SELECT * FROM activity_registrations WHERE user_id = '" + LoginWindow.CurrentUser.getId() +
                "' AND activity_id = '" + activity.getId()+"'");
        isAangemeld = !res.isEmpty();
        
        act = activity;
        blackline = BorderFactory.createLineBorder(Color.black);   //tekent zwarte rand om panel
        SimpleDateFormat printFormat = new SimpleDateFormat("HH:mm");

        JPanel window = new JPanel();
        int window_id = Wielwijk.gui.addWindow(window);

        JPanel container = new JPanel();            //deelt window in tweeen
        container.setLayout(new GridLayout(1, 2));

        JPanel leftlayout = new JPanel();           //layout voor linkerhelft
        leftlayout.setLayout(new BorderLayout());
        
        rightlayout = new JPanel();          //layout voor rechterhelft
        rightlayout.setLayout(new BorderLayout());

        JPanel wrapper = new JPanel(new BorderLayout());
        name = new JLabel();                        //naam wandeling boven beschrijving   
        name.setFont(name.getFont().deriveFont(26.0f));
        name.setText(act.getName());
        wrapper.add(name, BorderLayout.NORTH);
        wrapper.add(Box.createRigidArea(new Dimension(460, 20)), BorderLayout.CENTER);
        leftlayout.add(wrapper, BorderLayout.NORTH);

        // Beschrijving
        JPanel desc_wrapper = new JPanel(new BorderLayout());
        
        JLabel description = new JLabel();
        description.setText("<html><body><i>" + act.getDescription() + "</i></body></html>");
        description.setFont(description.getFont().deriveFont(14.0f));
        description.setForeground(new Color(150, 150, 150));
        
        desc_wrapper.add(description, BorderLayout.NORTH);
        desc_wrapper.add(Box.createRigidArea(new Dimension(0, 20)), BorderLayout.CENTER);
        
        leftlayout.add(desc_wrapper, BorderLayout.CENTER);
        
        // Waarden
        JPanel textpanel = new JPanel();

        Border empty = BorderFactory.createMatteBorder(20, 20, 20, 20, Wielwijk.gui.getBackground());
        leftlayout.setBorder(empty);
        textpanel.setLayout(new GridLayout(4, 2, 0, 10));

        // Locatie
        JLabel location = new JLabel();
        location.setText("Locatie");
        location.setFont(location.getFont().deriveFont(16.0f));
        location.setForeground(new Color(100, 100, 100));
        textpanel.add(location);

        JLabel loc = new JLabel();
        loc.setText(act.getLocation());
        loc.setFont(loc.getFont().deriveFont(16.0f));
        textpanel.add(loc);

        // Begintijd
        JLabel time_begin = new JLabel();
        time_begin.setText("Begintijd");
        time_begin.setFont(time_begin.getFont().deriveFont(16.0f));
        time_begin.setForeground(new Color(100, 100, 100));
        textpanel.add(time_begin);

        JLabel tb = new JLabel();
        tb.setText(printFormat.format((java.util.Date) act.getDatetimeBegin()));
        tb.setFont(tb.getFont().deriveFont(16.0f));
        textpanel.add(tb);

        // Eindtijd
        JLabel time_end = new JLabel();
        time_end.setText("Eindtijd");
        time_end.setFont(time_end.getFont().deriveFont(16.0f));
        time_end.setForeground(new Color(100, 100, 100));
        textpanel.add(time_end);

        JLabel te = new JLabel();
        te.setText(printFormat.format((java.util.Date) act.getDatetimeEnd()));
        te.setFont(te.getFont().deriveFont(16.0f));
        textpanel.add(te);

        leftlayout.add(textpanel, BorderLayout.SOUTH);


        //overige parameters activiteit in tekstvak
        //wandeling/borrel/vergadering

        container.add(leftlayout);                  //voegt linkerhelft toe aan container

        JPanel wrapper2 = new JPanel(new BorderLayout());
        slaapplaatsen = new JLabel("Slaapplaatsen");                        //naam wandeling boven beschrijving   
        slaapplaatsen.setFont(slaapplaatsen.getFont().deriveFont(26.0f));
        wrapper2.add(slaapplaatsen, BorderLayout.NORTH);
        
        rightlayout.add(Box.createRigidArea(new Dimension(460, 20)), BorderLayout.NORTH);
        rightlayout.add(wrapper2, BorderLayout.CENTER);

        //Slaapplaatsen lijst
        res = Wielwijk.db.query("SELECT * FROM accommodations WHERE activity_id = '" + act.getId() + "'");
      
      
        
        
        ArrayList<Accommodation> data = new ArrayList<Accommodation>();
        for (int i = 0; i < res.size(); i++) {      //ArrayList met accomodations wordt aangemaakt
            Map<String, Object> map = (HashMap<String, Object>) res.get(i);
            Accommodation acc;
            acc = new Accommodation((Long) map.get("id"), (Integer) map.get("activity_id"), (Integer) map.get("user_id"),
                    (String)map.get("address"), (Integer) map.get("people"), (Integer)map.get("capacity"));     //typecast data uit database
                                                                                                                //naar een Accomodation
//            if (acc.getUserId()==LoginWindow.CurrentUser.getId()) {
//                eigenAcc = acc;         
//            }
//            
//            for (int j = 0; j < res2.size(); j++) {
//                Map<String, Object> map2 = (HashMap<String, Object>) res2.get(j);
//                if ((Integer) map2.get("accommodation_id")== acc.getId()) {
//                    aangemeldeAcc = acc;        //loop 
//                }
//            }
            
            data.add(acc);
        }
        for (Accommodation acc:data){
            java.util.List res2 = Wielwijk.db.query("SELECT accommodation_id FROM accommodation_registrations WHERE user_id = '" + LoginWindow.CurrentUser.getId() + "' AND accommodation_id='" + acc.getId() + "'");
            System.out.println("res2 size" + res2.size());
            for (int i = 0; i < res2.size(); i++) {      
                Map<String, Object> map2 = (HashMap<String, Object>) res2.get(i);
                 int hier=(Integer)map2.get("accommodation_id");
                System.out.println("hier"+String.valueOf(hier));
            
                slaaptIn.add(hier);
                System.out.println("slaaptin:" + slaaptIn.toString());
            }
        }
        myList = new JList(data.toArray());
        myList.setFont(myList.getFont().deriveFont(16.0f));
        myList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JScrollPane pane = new JScrollPane(myList);
        Border invis = BorderFactory.createMatteBorder(0, 0, 0, 5, Wielwijk.gui.getBackground());
        pane.setBorder(invis);
        
        wrapper2.add(pane, BorderLayout.SOUTH);
        
        //Slaapplaats knoppen
        slaappanel = new JPanel(new GridLayout(4,3));
        
        final JButton meldaan = new JButton("Aanmelden voor slaapplaats");
        final JButton meldaf = new JButton("Afmelden voor slaapplaats");
        final JButton nieuwslaap = new JButton("Slaapplaats toevoegen");
        slaappanel.add(meldaan);
        slaappanel.add(meldaf);
        slaappanel.add(new JLabel("Adres: "));
        final JTextField tfAdres = new JTextField();
        slaappanel.add(tfAdres);
        slaappanel.add(new JLabel("Capaciteit: "));
        final JTextField tfCap = new JTextField();
        slaappanel.add(tfCap);
        
        slaappanel.add(nieuwslaap);
        final JButton ok = new JButton("Gegevens opslaan");
        slaappanel.add(ok);
        
       
        
        
        
     
  
        
        meldaan.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                if (selectAcc != null){
                    if (!slaaptIn.contains(selectAcc.getId())){
                
                        Wielwijk.db.exec("INSERT INTO accommodation_registrations (accommodation_id, user_id) VALUES ( '" + selectAcc.getId() + 
                            "', '" + LoginWindow.CurrentUser.getId() + "')");
                        Wielwijk.db.exec("UPDATE accommodations SET people = people + 1 WHERE id = '" + selectAcc.getId() + "'");
                        JOptionPane.showMessageDialog(null, "U heeft zich aangemeld voor de slaapplaats");
                    }
                }
                UpdateAccList();
           }
            
        });
        meldaf.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                if (selectAcc!=null){
                    System.out.println("slaaptIn: " + slaaptIn.toString());
                    System.out.println("selectAcc: " + selectAcc.getId());
                    if (slaaptIn.contains(selectAcc.getId())){

                        Wielwijk.db.exec("DELETE FROM accommodation_registrations WHERE user_id =" + LoginWindow.CurrentUser.getId());
                        Wielwijk.db.exec("UPDATE accommodations SET people = people - 1 WHERE id = '" + selectAcc.getId() + "'");
                        slaaptIn.remove(slaaptIn.indexOf(selectAcc.getId()));
                        JOptionPane.showMessageDialog(null, "U heeft zich afgemeld voor de slaapplaats.");
                    }
                }
                
                UpdateAccList();
                
                }
            
        });
        
        nieuwslaap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                
                Wielwijk.db.exec("INSERT INTO accommodations (user_id, activity_id, capacity, address) VALUES ('" + LoginWindow.CurrentUser.getId() + 
                        "', '" + act.getId() + "', '1', 'Nieuw Adres')");
                
                UpdateAccList();
                JOptionPane.showMessageDialog(null, "Nieuwe slaapplaats aangemaakt.");

            }
        });
        
        ok.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                Wielwijk.db.exec("UPDATE accommodations  SET address = '" + tfAdres.getText() + "', capacity = '" + tfCap.getText() + 
                        "' WHERE id = '" + selectAcc.getId() + "' AND user_id = '" + LoginWindow.CurrentUser.getId() + "'");
                UpdateAccList();
                JOptionPane.showMessageDialog(null, "Gegevens bijgewerkt.");
       
            }
        });
        
        rightlayout.add(slaappanel, BorderLayout.SOUTH);
        
        myList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                JList list = (JList) listSelectionEvent.getSource();
                Accommodation acc = (Accommodation) list.getSelectedValue();
                
                selectAcc = acc;
                tfAdres.setText(acc.getAddress());
                tfCap.setText(String.valueOf(acc.getCap()));
            }
        });
        //

        container.add(rightlayout);                 //voegt rechterhelft toe aan container
        
        // Aanmeldknop voor wandeling
        final JButton aanmeld = new JButton("Aanmelden voor wandeling");

        aanmeld.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                aanmeld.setText("...");
                if (isAangemeld) {
                    Wielwijk.db.exec("DELETE FROM activity_registrations WHERE user_id = '" + LoginWindow.CurrentUser.getId() +
                            "' AND activity_id = '" + act.getId() + "'");
                    isAangemeld = false;
                    aanmeld.setText("Aanmelden voor wandeling");
                    JOptionPane.showMessageDialog(null, "U heeft zich afgemeld voor de wandeling.");
                } else {
                    Wielwijk.db.exec("INSERT INTO activity_registrations (user_id, activity_id, organiser) VALUES ('" + LoginWindow.CurrentUser.getId() +
                            "',  '" + act.getId() + "', '0')");
                    isAangemeld = true;
                    aanmeld.setText("Afmelden voor wandeling");
                    JOptionPane.showMessageDialog(null, "U heeft zich aangemeld voor de wandeling.");
                }
            }
            
        });
        
        textpanel.add(aanmeld);

        Wielwijk.gui.addElement(window_id, container);
    }
    
    private void UpdateAccList() {
        java.util.List res = Wielwijk.db.query("SELECT * FROM accommodations WHERE activity_id = '" + act.getId() + "'");
        ArrayList<Accommodation> data = new ArrayList<Accommodation>();
        for (int i = 0; i < res.size(); i++) {
            Map<String, Object> map = (HashMap<String, Object>) res.get(i);
            Accommodation acc;
            acc = new Accommodation((Long) map.get("id"), (Integer) map.get("activity_id"), (Integer) map.get("user_id"),
                    (String)map.get("address"), (Integer) map.get("people"), (Integer)map.get("capacity"));
           
            data.add(acc);
           
            }
        
       for (Accommodation acc:data){
            java.util.List res2 = Wielwijk.db.query("SELECT accommodation_id FROM accommodation_registrations WHERE user_id = '" + LoginWindow.CurrentUser.getId() + "' AND accommodation_id='" + acc.getId() + "'");
            
           for (int i = 0; i < res2.size(); i++) {
            
            
                Map<String, Object> map2 = (HashMap<String, Object>) res2.get(i);
                int hier=(Integer)map2.get("accommodation_id");
                System.out.println("hier"+String.valueOf(hier));
                slaaptIn.add(hier);
                System.out.println("slaaptin:" + slaaptIn.toString());


                }
            myList.setListData(data.toArray());
            }
        }
//    public static void main(String[] args) {
//        Wielwijk.gui = new GUI();
//        Wielwijk.getDBConnection();
//        
//        Date datetime = null;
//        try {
//            SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//            isoFormat.setTimeZone(TimeZone.getTimeZone("CET"));
//            datetime = isoFormat.parse("2010-05-23T09:01:02");
//        } catch(ParseException e) {
//            System.out.println(e.getMessage());
//        }
//        
//        Hike temp = new Hike("Rondje om Delft", "Delft", "een klein rondje", datetime, datetime, 10, 5, 50, "1012-12-11", false, 10000, 500);
//
//        ActivityWindow aw = new ActivityWindow(temp);
//        Wielwijk.gui.showWindow(0);
//    }
}