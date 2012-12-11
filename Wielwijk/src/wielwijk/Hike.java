package wielwijk;
import java.util.*;

/**
 *
 * @author jeroen
 */
public class Hike extends Activity {
    private int distance;
    private int d_height;
    private ArrayList<Checkpoint> checkpoints = new ArrayList<Checkpoint>();
    
    //in de database een kolom waarin staat aangegeven wat voor soort activity
    //het is. 0 = hike, 1 = meeting, 2 = drink
    
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
     * @param dis
     * @param ht
     */
    public Hike(String nm, String lc, String des, String dtb, String dte, int fe, int lul, int uul, String lld, boolean cl, int dis, int ht) {
        super(nm, lc, des, dtb, dte, fe, lul, uul, lld, cl);
        distance = dis;
        d_height = ht;
        checkpoints = new ArrayList<Checkpoint>();

        Wielwijk.db.exec /*System.out.println*/("INSERT INTO activities (name, location, description,"
                + " datetime_begin, datetime_end, fee, lower_user_limit, upper_user_limit,"
                + " lower_limit_date, cancelled, distance, height_difference, type) "
                + "VALUES ( '" + nm + "', '" + lc + "', '" + des + "', '" + dtb + "', '"
                + dte + "', '" + fe + "', '" + lul + "', '" + uul + "', '" + lld + "', '" + cl
                + "', '" + distance + "', '" + d_height + "', 0)");
    }
}