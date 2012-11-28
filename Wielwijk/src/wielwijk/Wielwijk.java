package wielwijk;

import java.util.*;

/**
 *
 * @author jeroen
 */
public class Wielwijk {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        UserContainer uc = new UserContainer();
        List res = uc.findUser("off");
        
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
