package wielwijk;


/**
 *
 * @author jeroen
 */
public class Member extends User {
    private boolean board=false;
    
    /**
     *
     * @param nm
     * @param pw
     * @param bd
     * @param act
     * @param pic
     */
    public Member(String nm, String pw, String bd, boolean act, int pic) {
        super(nm, pw, bd, act, pic, false);
    }
}
