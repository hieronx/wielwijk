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

    public ActivityWindow(Activity activity) {
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
        rightlayout.setLayout(new FlowLayout());

            JPanel wrapper = new JPanel();
            name = new JLabel();                        //naam wandeling boven beschrijving   
            name.setFont(name.getFont().deriveFont(26.0f));
            name.setText(act.getName());
            wrapper.add(Box.createRigidArea(new Dimension(0, 60)));
            wrapper.add(name);
            leftlayout.add(wrapper, BorderLayout.NORTH);
            
        
            JPanel textpanel = new JPanel();
        
            Border empty = BorderFactory.createMatteBorder(20, 20, 20, 20, Wielwijk.gui.getBackground());
            leftlayout.setBorder(empty);
            textpanel.setLayout(new GridLayout(5, 2));
            
            //textpanel.add(Box.createRigidArea(new Dimension(400, 0)));
            
            Component margin = Box.createRigidArea(new Dimension(0, 20));
            
            // Locatie
            JLabel location = new JLabel();
            location.setText("Locatie: ");
            location.setFont(location.getFont().deriveFont(16.0f));
            textpanel.add(location);
            
            JLabel loc = new JLabel();
            loc.setText(act.getLocation());
            textpanel.add(loc);
            
            textpanel.add(margin);
            textpanel.add(margin);
            

            // Begintijd
            JLabel time_begin = new JLabel();
            time_begin.setText("Begintijd: ");
            textpanel.add(time_begin);
            
            JLabel tb = new JLabel();
            tb.setText(printFormat.format((java.util.Date) act.getDatetimeBegin()));
            textpanel.add(tb);
            
            textpanel.add(margin);
            textpanel.add(margin);

            // Eindtijd
            JLabel time_end = new JLabel();
            time_end.setText("Eindtijd: ");
            textpanel.add(time_end);
            
            JLabel te = new JLabel();
            te.setText(printFormat.format((java.util.Date) act.getDatetimeEnd()));
            textpanel.add(te);

            leftlayout.add(textpanel, BorderLayout.CENTER);


        //overige parameters activiteit in tekstvak
        //wandeling/borrel/vergadering

        container.add(leftlayout);                  //voegt linkerhelft toe aan container



        slaapplaatsen = new JLabel();
        slaapplaatsen.setBorder(blackline);
        slaapplaatsen.setText("Slaapplaatsen:");
        rightlayout.add(slaapplaatsen);

        //slaapplaatsen ophalen uit db, lijst maken
        //lijst weergeven in bovengenoemd tekstvak (selecteerbaar, scrollable?, welke parameters?)

        //aanmeldknop buiten tekstvak, meld aan voor activiteit en evt. geselecteerde slaapplaats

        container.add(rightlayout);                 //voegt rechterhelft toe aan container

        Wielwijk.gui.addElement(window_id, container);
    }

    public static void main(String[] args) {
        Wielwijk.gui = new GUI();
        Wielwijk.getDBConnection();
        
        Date datetime = null;
        try {
            SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            isoFormat.setTimeZone(TimeZone.getTimeZone("CET"));
            datetime = isoFormat.parse("2010-05-23T09:01:02");
        } catch(ParseException e) {
            System.out.println(e.getMessage());
        }
        
        Hike temp = new Hike("Rondje om Delft", "Delft", "een klein rondje", datetime, datetime, 10, 5, 50, "1012-12-11", false, 10000, 500);

        ActivityWindow aw = new ActivityWindow(temp);
        Wielwijk.gui.showWindow(0);
    }
}