package wielwijk;

import java.util.*;

public class Wielwijk {

    public static void main(String[] args) {
        // Test de database
        Database db = new Database();
        db.connect("sql.ewi.tudelft.nl", "ti1210b12", "ti1210b12", "informaticus");
        
        List res = db.query("SELECT * FROM users");
        
        for (int i = 0; i < res.size(); i++) {
            Map<String, Object> map = (HashMap<String, Object>) res.get(i);

            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pairs = (Map.Entry)it.next();
                System.out.println(pairs.getKey() + " = " + pairs.getValue());
                it.remove(); // avoids a ConcurrentModificationException
            }
            
            System.out.println("----------");
        }
    }
}
