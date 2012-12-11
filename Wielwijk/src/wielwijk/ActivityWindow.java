package wielwijk;

import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;
import java.util.Map;
import javax.swing.*;

/**
 *
 * @author ylverhoog
 */
public class ActivityWindow {

    private JLabel name, slaapplaatsen;
    JPanel container, panel, leftlayout, rightlayout;
    Activity act;

    public ActivityWindow(Activity activity) {
        act = activity;

        JPanel window = new JPanel();
        int window_id = Wielwijk.gui.addWindow(window);

        JPanel container = new JPanel();            //deelt window in tweeen
        container.setLayout(new GridLayout(1, 1));

        JPanel leftlayout = new JPanel();           //layout voor linkerhelft
        leftlayout.setLayout(new FlowLayout());

        JPanel rightlayout = new JPanel();          //layout voor rechterhelft
        rightlayout.setLayout(new FlowLayout());

        name = new JLabel();
        name.setText(act.getName());
        leftlayout.add(name);

        //overige parameters activiteit in tekstvak
        //wandeling/borrel/vergadering

        container.add(leftlayout);                  //voegt linkerhelft toe aan container

        slaapplaatsen = new JLabel();               //moet nog in tekstvak
        slaapplaatsen.setText("Slaapplaatsen:");
        rightlayout.add(slaapplaatsen);

        //slaapplaatsen ophalen uit db, lijst maken
        //lijst weergeven in bovengenoemd tekstvak (selecteerbaar, scrollable?, welke parameters?)

        //aanmeldknop buiten tekstvak, meld aan voor activiteit en evt. geselecteerde slaapplaats

        container.add(rightlayout);                 //voegt rechterhelft toe aan container

        Wielwijk.gui.addElement(window_id, container);
    }

    public static void main(String[] args) {
        Activity activity = new Activity("Rondje", "Delft", "een klein rondje", "11-12-2012", "12-12-2012", 10, 5, 50, "2012-11-12", false);
        Wielwijk.gui = new GUI();
        Wielwijk.getDBConnection();

        ActivityWindow aw = new ActivityWindow(activity);
        Wielwijk.gui.showWindow(0);
    }
}
