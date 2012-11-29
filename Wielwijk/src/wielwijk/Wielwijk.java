package wielwijk;

import java.util.*;

/**
 *
 * @author jeroen
 */
public class Wielwijk {

    public static Database db;
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        db = new Database();
        db.connect();
        
        String[] tekst = null;
        UserListWindow.main(tekst);
    }
}
