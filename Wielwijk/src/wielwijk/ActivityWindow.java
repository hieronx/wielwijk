package wielwijk;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.*;

/**
 *
 * @author ylverhoog
 */
public class ActivityWindow {

    private JLabel label;
    JPanel panel, container, leftlayout, rightlayout;

    public ActivityWindow() {
        JPanel window = new JPanel();
        int window_id = Wielwijk.gui.addWindow(window);

        JPanel container = new JPanel();
        container.setLayout(new GridLayout(2, 2));

        JPanel leftlayout = new JPanel();
        leftlayout.setLayout(new FlowLayout());

        JPanel rightlayout = new JPanel();
        rightlayout.setLayout(new FlowLayout());

        
    }
}
