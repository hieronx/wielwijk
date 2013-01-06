package wielwijk;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.text.*;

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
        
        JPanel rightlayout = new JPanel();          //layout voor rechterhelft
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

        //slaapplaatsen ophalen uit db, lijst maken
        //lijst weergeven in bovengenoemd tekstvak (selecteerbaar, scrollable?, welke parameters?)

        //aanmeldknop buiten tekstvak, meld aan voor activiteit en evt. geselecteerde slaapplaats

        container.add(rightlayout);                 //voegt rechterhelft toe aan container
        
        final JButton aanmeld = new JButton("Aanmelden voor wandeling");
        if (isAangemeld)
            aanmeld.setText("Afmelden voor wandeling");
        aanmeld.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                aanmeld.setText("...");
                if (isAangemeld) {
                    Wielwijk.db.exec("DELETE FROM activity_registrations WHERE user_id = '" + LoginWindow.CurrentUser.getId() +
                            "' AND activity_id = '" + act.getId() + "'");
                    isAangemeld = false;
                    aanmeld.setText("Aanmelden voor wandeling");
                } else {
                    Wielwijk.db.exec("INSERT INTO activity_registrations (user_id, activity_id, organiser) VALUES ('" + LoginWindow.CurrentUser.getId() +
                            "',  '" + act.getId() + "', '0')");
                    isAangemeld = true;
                    aanmeld.setText("Afmelden voor wandeling");
                }
            }
        });
        
        textpanel.add(aanmeld);

        Wielwijk.gui.addElement(window_id, container);
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