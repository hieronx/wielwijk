package wielwijk;


import java.awt.*;
import javax.swing.*;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author jeroen
 */
public class CalendarWindow {
    
    JPanel container;
    JPanel calendar = new JPanel();
    
    Date date;
    
    public CalendarWindow() {
        date = new Date();
        
        Calendar today = Calendar.getInstance();
        today.setTime(date);
        Calendar cal = Calendar.getInstance();
        today.setTime(date);
        cal.set(Calendar.DATE, 1);
        cal.add(Calendar.DATE, -cal.get(Calendar.DAY_OF_WEEK) - 6);
        SimpleDateFormat mnth = new SimpleDateFormat("MM");
        SimpleDateFormat mnthword = new SimpleDateFormat("MMMM");
        SimpleDateFormat year = new SimpleDateFormat("yyyy");
        SimpleDateFormat day = new SimpleDateFormat("d");
        SimpleDateFormat dayword = new SimpleDateFormat("EEEE");
        int thismonth = Integer.parseInt(mnth.format(today.getTime()));
        int thisday = Integer.parseInt(day.format(today.getTime()));
        
        JPanel window = new JPanel();
        int window_id = Wielwijk.gui.addWindow(window);
        
        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());

        JPanel layout = new JPanel();
        JLabel month = new JLabel();
        month.setText(mnthword.format(today.getTime()));
        month.setFont(month.getFont().deriveFont(26.0f));
        layout.add(month);
        container.add(layout, BorderLayout.NORTH);
        
        calendar.setLayout(new GridLayout(7, 7));
        calendar.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        
        
        for (int i=0; i<7; i++) {
            JPanel item = new JPanel(new BorderLayout());
            JLabel daylabel = new JLabel(dayword.format(cal.getTime()));
            item.add(daylabel, BorderLayout.CENTER);
            
            calendar.add(item);
            
            cal.add(Calendar.DATE, +1);
        }
        for (int i=0; i<6*7; i++) {
            int d = Integer.parseInt(day.format(cal.getTime()));
            int m = Integer.parseInt(mnth.format(cal.getTime()));
            int y = Integer.parseInt(year.format(cal.getTime()));

            calendar.add(getActivity(y, m, d, m==thismonth, d==thisday));

            cal.add(Calendar.DATE, +1);
        }
        container.add(calendar, BorderLayout.CENTER);
        
        Wielwijk.gui.addElement(window_id, container);
    }
    
    private JPanel getActivity(int yr, int m, int d, boolean current, boolean today) {
        
        
        JPanel item = new JPanel(new BorderLayout());

        JPanel layout2 = new JPanel();
        JLabel index = new JLabel(Integer.toString(d));
        layout2.add(index);
        item.add(layout2, BorderLayout.WEST);
        
        JTextArea ta = new JTextArea("----------");
        ta.setPreferredSize(new Dimension(100,55));
        ta.setBackground(calendar.getBackground());
        item.add(ta, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.add(item);
        
        if (current) {
            panel.setBackground(Color.WHITE);
            layout2.setBackground(Color.WHITE);
            item.setBackground(Color.WHITE);
            ta.setBackground(Color.WHITE);
        }
        if (today) {
            panel.setBackground(Color.ORANGE);
            layout2.setBackground(Color.ORANGE);
            item.setBackground(Color.ORANGE);
        }
        Activity act = ActivityContainer.getActivityByDay(yr, m, d);
        
        if (act!=null) {
            ta.setText(act.getName());
        }
        
        return panel;
    }
    
    public static void main(String[] args) {
        Wielwijk.gui = new GUI();
        Wielwijk.getDBConnection();
        
        CalendarWindow cw = new CalendarWindow();
        Wielwijk.gui.showWindow(0);
    }
    
}
