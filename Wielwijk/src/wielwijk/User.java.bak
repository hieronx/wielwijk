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
        if (active == true) {
            // werk database bij
            active = false;
        }
    }
    
    /**
     * 
     */
    public void unsuspend() {
        if (active == false) {
            // werk database bij
            active = true;
        }
    }
    
     
    /**
     * 
     */
    public String getName() {
        return name;
    }
    
    /**
     * 
     */
    public String getBirthdate() {
        return birthdate;
    }
    
    /**
     * 
     */
    public int getPicture() {
        return picture;
    }
    
    /**
     * 
     */
    public boolean isActive() {
        return active;
    }
    
    /**
     * 
     */
    public boolean isBoard() {
        return board;
    }
}
//user class, spreek voor zich