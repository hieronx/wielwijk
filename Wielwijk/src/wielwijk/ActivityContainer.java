package wielwijk;
import java.util.*;

/**
 *
 * @author jeroen
 */
public class ActivityContainer {
    private static ArrayList<Activity> activities = new ArrayList<Activity>();
    
    /**
     *
     * @param hike
     */
    public static void addActivity(Hike hike) {
        activities.add(hike);
    }

    /**
     *
     * @param activity
     */
    public static void removeActivity(Activity activity) {
        Wielwijk.db.exec("REMOVE FROM activities WHERE id = " + activity.getId());
    }

    /**
     *
     * @param activity
     */
    public static List findActivity(Activity activity) {
        List l = Wielwijk.db.query("SELECT * FROM activities WHERE id = " + activity.getId());

        return l;
    }

    /**
     * 
     * @param id
     */
    public static Activity getActivityById(int id) {
        List res = Wielwijk.db.query("SELECT * FROM activities WHERE id = " + id);
        if (res.size() == 0) {
            return null;
        }

        java.util.Map<String, Object> map = (HashMap<String, Object>) res.get(0);

        return new Activity((String) map.get("name"), (String) map.get("location"), (String) map.get("destination"), map.get("datetime_begin").toString(), map.get("datetime_end").toString(),
                (Integer) map.get("fee"), (Integer) map.get("lower_user_limit"), (Integer) map.get("upper_user_limit"),
                map.get("lower_limit_date").toString(), (Boolean) map.get("cancelled"), (Long) map.get("id"));
    }

    public static Activity getActivityByDay(int year, int month, int day) {
        List res = Wielwijk.db.query("SELECT * FROM activities WHERE "
                + "YEAR(datetime_begin)=" + year
                + " AND MONTH(datetime_begin)=" + month
                + " AND DAY(datetime_begin)=" + day);
        if (res.size() == 0) {
            return null;
        }

        java.util.Map<String, Object> map = (HashMap<String, Object>) res.get(0);

        return new Activity((String) map.get("name"), (String) map.get("location"), (String) map.get("destination"), map.get("datetime_begin").toString(), map.get("datetime_end").toString(),
                (Integer) map.get("fee"), (Integer) map.get("lower_user_limit"), (Integer) map.get("upper_user_limit"),
                map.get("lower_limit_date").toString(), (Boolean) map.get("cancelled"), (Long) map.get("id"));
    }
}
