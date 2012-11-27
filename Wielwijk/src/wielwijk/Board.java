package wielwijk;


/**
 *
 * @author jeroen
 */
public class Board extends User {
    private boolean Board = true;
    
    /**
     *
     * @param nm
     * @param pw
     * @param bd
     * @param act
     * @param pic
     */
    public Board(String nm, String pw, String bd, boolean act, int pic) {
        super(nm, pw, bd, act, pic, true);
    }
}
