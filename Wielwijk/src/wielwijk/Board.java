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
    public Board(String nm, String pw, int pic, String ad, String bd) {
        super(nm, pw, pic, ad, bd, true);
    }
}
