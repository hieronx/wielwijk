package wielwijk;

import java.util.*;

/**
 *
 * @author jeroen
 */
public class Wielwijk {

    public static Database db;
    
    public static GUI gui;
    
    private GUI login;
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        db = new Database();
        db.connect();
        
        System.setProperty("apple.laf.useScreenMenuBar", "true");
        System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Wielwijk");
        
        gui = new GUI();
        
        LoginWindow login = new LoginWindow();
    }
    
    public static void getDBConnection() {
        db = new Database();
        db.connect();
    }
}