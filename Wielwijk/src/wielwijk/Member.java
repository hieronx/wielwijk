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
    public Member(String nm, String pw, int pic, String ad, String bd) {
        super(nm, pw, pic, ad, bd, false);
    }
}
