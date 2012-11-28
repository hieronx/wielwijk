package wielwijk;

/**
 *
 * @author jeroen
 */
public class User {

    private String name;
    private String password;
    private String birthdate;
    private boolean active;
    private int picture;
    private boolean board;
    private String address;
    
    /**
     *
     * @param nm
     * @param pw
     * @param bd
     * @param act
     * @param pic
     * @param brd
     */
    public User(String nm, String pw, int pic, String ad, String bd, boolean brd) {
        name = nm;
        password = pw;
        birthdate = bd;
        active = true;
        address = ad;
        picture = pic;
        board = brd;
    }
    
    /**
     * 
     */
    public void suspend() {
        // suspend meuk, werk database bij
    }
    
    /**
     * 
     */
    public void unsuspend() {
        // unsuspend meuk, werk database bij
    }
}
//user class, spreek voor zich