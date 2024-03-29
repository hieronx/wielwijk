package wielwijk;

import java.util.*;

/**
 *
 * @author jeroen
 */
public class Drink extends Activity {
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
     */
    public Drink(String nm, String lc, String des, Date dtb, Date dte, int fe, int lul, int uul, String lld, boolean cl) {
        super(nm, lc, des, dtb, dte, fe, lul, uul, lld, cl);

        Wielwijk.db.exec ("INSERT INTO activities (name, location, description, datetime_begin, datetime_end, fee, lower_user_limit, upper_user_limit, lower_limit_date, cancelled, type) " +
           "VALUES ( '" + nm + "', '" + lc + "', '" + des + "', '" + dtb + "', '" + dte + "', '" + fe + "', '" + lul + "', '" + uul + "', '" + lld + "', '" + cl + "', 2)");
    }
}
