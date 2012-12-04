
package wielwijk;
import java.util.*;

/**
 *
 * @author jeroen
 */
public class ActivityContainer {

    /**
     *
     * @param name
     * @param location
     * @param description
     * @param datetime_begin
     * @param datetime_end
     * @param fee
     * @param lower_user_limit
     * @param upper_user_limit
     * @param lower_limit_date
     * @param cancelled
     */
    public Activity addActivity(String name, String location, String description, String datetime_begin, String datetime_end, int fee, int lower_user_limit, int upper_user_limit, String lower_limit_date, boolean cancelled) {
        Activity newActivity = new Activity(name, location, description, datetime_begin, datetime_end, fee, lower_user_limit, upper_user_limit, lower_limit_date, cancelled);

        
        return newActivity;
    }


    /**
     *
     * @param activity
     */
    public void removeActivity(Activity activity) {
        Wielwijk.db.exec ("REMOVE FROM activities WHERE id = " + activity.getId());
    }


    /**
     *
     * @param activity
     */
    public List findActivity(Activity activity) {
        List l = Wielwijk.db.query("SELECT * FROM activities WHERE id = " + activity.getId());
        
        return l;
    }
    
    /**
     * 
     * @param id
     */
    public Activity getActivityById(int id) {
        List res = Wielwijk.db.query("SELECT * FROM activities WHERE id = "+id);
        if (res.size()==0) return null;
        
        java.util.Map<String, Object> map = (HashMap<String, Object>) res.get(0);
        
        return new User((String)map.get("name"),(String)map.get("password"),Integer.parseInt((String)map.get("picture")),
                (String)map.get("ad"),(String)map.get("bd"),(Integer.parseInt((String)map.get("board"))==1));
    }

}
