package wielwijk;
import java.util.*;

/**
 *
 * @author jeroen
 */
public class Hike extends Activity {
    private int sort = 0;
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
        
        Wielwijk.db.exec("UPDATE activities SET distance = "+dis+", height_difference = "+ht+", type = 0 WHERE id = "+super.getId());
        
    }
}