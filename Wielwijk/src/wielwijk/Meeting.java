package wielwijk;


public class Meeting extends Activity {
    private int sort = 1;
    //in de database een kolom waarin staat aangegeven wat voor soort activity het is.
    //0 = hike, 1 = meeting, 2 = drink

    public Meeting(String nm, String lc, String des, String dtb, String dte, int fe, int lul, int uul, String lld, boolean cl) {
        super(nm, lc, des, dtb, dte, fe, lul, uul, lld, cl);
    }
}
