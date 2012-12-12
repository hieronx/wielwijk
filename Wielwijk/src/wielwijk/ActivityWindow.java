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

        JPanel window = new JPanel();
        int window_id = Wielwijk.gui.addWindow(window);

        JPanel container = new JPanel();            //deelt window in tweeen
        container.setLayout(new GridLayout(1, 1));

        JPanel leftlayout = new JPanel();           //layout voor linkerhelft
        leftlayout.setLayout(new FlowLayout());

        JPanel rightlayout = new JPanel();          //layout voor rechterhelft
        rightlayout.setLayout(new FlowLayout());

             name = new JLabel();                        //naam wandeling boven beschrijving
             name.setText(act.getName());
             leftlayout.add(name);
        
//             JPanel textpanel = new JPanel();
//             textpanel.setBorder(blackline);
//             textpanel.setLayout(new GridLayout(10, 2));
//                  Label location = new JLabel();
//                  location.setText("Locatie: ")
//                  Label loc = new JLabel();
//                  loc.setText(act.getName);
//                  Label


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
        
        Hike temp = new Hike("Rondje", "Delft", "een klein rondje", datetime, datetime, 10, 5, 50, "1012-12-11", false, 10000, 500);

        ActivityWindow aw = new ActivityWindow(temp);
        Wielwijk.gui.showWindow(0);
    }
}