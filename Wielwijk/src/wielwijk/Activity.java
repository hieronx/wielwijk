package wielwijk;

/**
 *
 * @author jeroen
 */
public abstract class Activity {

    private long id;
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
        
        
    }
    
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
     * @param id 
     */
    public Activity(String nm, String lc, String des, String dtb, String dte, int fe, int lul, int uul, String lld, boolean cl, long idd) {
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
        id = idd;
        
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
        
        Wielwijk.db.exec("INSERT INTO activity_registrations (user_id, activity_id, organiser) "+
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
    public String getName() {
        return name;
    }
    
    /**
     * 
     */
    public long getId() {
        return id;
    }
    
    public static void main(String args[]) {
        Wielwijk.getDBConnection();
        
        User u = UserContainer.getUserById(1);
        Activity a = ActivityContainer.getActivityById(1);
        
        a.addUserAct(u, false);
    }
}
