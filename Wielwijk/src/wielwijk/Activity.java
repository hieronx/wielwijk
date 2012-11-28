package wielwijk;

/**
 *
 * @author jeroen
 */
public class Activity {

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
     * @param user
     */
    public void addUserAct(User user) {
        //database add user verhaaltje
    }
     /**
     *
     * @param user
     */
    public void removeUserAct(User user) {
        //database remove user verhaaltje
    }
    
    /**
     *
     * @param activity
     */
    public void cancel() {
        //database cancel verhaaltje
    }
}
