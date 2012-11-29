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
        
        UserContainer uc = new UserContainer();
        uc.removeUser(2);
    }
}
