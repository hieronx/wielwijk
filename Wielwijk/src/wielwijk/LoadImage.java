package wielwijk;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

/**
 * This class demonstrates how to load an Image from an external file
 */
public class LoadImage extends Component {
          
    BufferedImage img;

    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

    public LoadImage(String path) {
       try {
           img = ImageIO.read(new File(path));
       } catch (IOException e) {
       }

    }

    public Dimension getPreferredSize() {
             return new Dimension(100,100);
        
    }
    
}
