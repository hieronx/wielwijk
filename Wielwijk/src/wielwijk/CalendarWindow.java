package wielwijk;


import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
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

            calendar.add(new CalendarDay(y, m, d, m==thismonth, d==thisday));

            cal.add(Calendar.DATE, +1);
        }
        container.add(calendar, BorderLayout.CENTER);
        
        Wielwijk.gui.addElement(window_id, container);
    }
    
    private class CalendarDay extends JPanel implements MouseListener {
        Activity act;
        boolean white;
        boolean orange;
        JPanel layout2;
        JPanel item;
        
        public CalendarDay(int yr, int m, int d, boolean current, boolean today) {
            orange = today;
            white = current;
            item = new JPanel(new BorderLayout());

            layout2 = new JPanel();
            JLabel index = new JLabel(Integer.toString(d));
            layout2.add(index);
            item.add(layout2, BorderLayout.WEST);
            
            JLabel l = new JLabel("<html><body style='width: 65px; height: 40px'></body></html>");
            l.setBackground(calendar.getBackground());
            item.add(l, BorderLayout.CENTER);

            this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            this.add(item);

            if (current) {
                Paint(Color.WHITE);
            }
            if (today) {
                Paint(Color.ORANGE);
            }
            act = ActivityContainer.getActivityByDay(yr, m, d);

            if (act!=null) {
                l.setText("<html><body style='width: 65px'><b>"+act.getName()+"</b><br />"+act.getDescription()+"</body></html>");
                this.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            this.addMouseListener(this);
        }
        
        private void Paint(Color c) {
            this.setBackground(c);
            layout2.setBackground(c);
            item.setBackground(c);
        }
        
        @Override
        public void mouseEntered(MouseEvent e) {
            if (act!=null) {
                Paint(Color.cyan);
            }
        }

        @Override
        public void mouseExited(MouseEvent me) {
            if (white && !orange) {
                Paint(Color.WHITE);
            } else if (orange) {
                Paint(Color.ORANGE);
            } else {
                Paint(calendar.getBackground());
            }
            
        }
        
        @Override
        public void mouseClicked(MouseEvent me) {
            if (act!=null) {
                ActivityWindow ac = new ActivityWindow(act);
                Wielwijk.gui.showWindow(1);
            }
        }

        @Override
        public void mousePressed(MouseEvent me) {
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }

    }
    
    public static void main(String[] args) {
        Wielwijk.gui = new GUI();
        Wielwijk.getDBConnection();
        
        CalendarWindow cw = new CalendarWindow();
        Wielwijk.gui.showWindow(0);
    }
    
}
