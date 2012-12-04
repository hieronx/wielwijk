package wielwijk;

/**
 *
 * @author jeroen
 */
public class Activity {

    private int id;
    private String name;
    private String location;
    private String description;
    private String datetime_begin;
    private String datetime_end;
    private int    fee;
    private int    lower_user_limit;
    private int    upper_user_limit;
    private String lower_limit_date;
    private boolean cancelled;

    /**
     *
     * @param nm
     * @param lc
     * @param des
     * @param dtb
     * @param dte
     * @param fe
     * @param lul
     * @param uul
     * @param lld
     * @param cl
     */
    public Activity(String nm, String lc, String des, String dtb, String dte, int fe, int lul, int uul, String lld, boolean cl) {
        name = nm;
        location = lc;
        description = des;
        datetime_begin = dtb;
        datetime_end = dte;
        fee = fe;
        lower_user_limit = lul;
        upper_user_limit = uul;
        lower_limit_date = lld;
        cancelled = cl;
        
        Wielwijk.db.exec ("INSERT INTO activities (name, location, description, datetime_begin, datetime_end, fee, lower_user_limit, upper_user_limit, lower_limit_date, cancelled) " +
                "VALUES ( '" + name + "', '" + location + "', '" + description + "', '" + datetime_begin + "', '" + datetime_end + "', '" + fee + "', '" + lower_user_limit + "', '" + upper_user_limit + "', '" + cancelled + "')");
        
    }

    /**
     *
     * @param user
     * @param organiser
     */
    public void addUserAct(User user, boolean organiser) {
        java.util.List res = Wielwijk.db.query("SELECT * FROM activity_registrations "+
                "WHERE user_id = "+user.getId()+" AND activity_id="+id);
        if (res.size()>0) return;
        
        Wielwijk.db.query("INSERT INTO activity_registrations (user_id, activity_id, organiser) "+
                "VALUES ("+user.getId()+", "+id+", "+(organiser ? "1" : "0")+")");
    }
     /**
     *
     * @param user
     */
    public void removeUserAct(User user) {
        java.util.List res = Wielwijk.db.query("SELECT * FROM activity_registrations "+
                "WHERE user_id = "+user.getId()+" AND activity_id="+id);
        if (res.size()==0) return;
        
        Wielwijk.db.query("REMOVE FROM activity_registrations WHERE user_id = "+user.getId()+" AND activity_id="+id);
    }
    
    /**
     *
     * @param activity
     */
    public void cancel() {
        if (cancelled == false) {
            Wielwijk.db.exec("UPDATE activities SET cancelled = 1 WHERE id="+id);
            cancelled = true;
        }
    }
    
    /**
     * 
     */
    public int getId() {
        return id;
    }
    
    public static void main(String args[]) {
        User u = UserContainer.getUserById(1);
        
    }
}
