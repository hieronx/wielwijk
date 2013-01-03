package wielwijk;

/**
 *
 * @author jeroen
 */
public class User {
    
    public long id;
    public String name;
    public String password;
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
     * @param nm
     * @param pw
     * @param pic
     * @param ad
     * @param bd
     * @param brd
     * @param idd 
     */
    public User(String nm, String pw, int pic, String ad, String bd, boolean brd, long idd) {
        name = nm;
        password = pw;
        birthdate = bd;
        active = true;
        address = ad;
        picture = pic;
        board = brd;
        id = idd;
    }
    
    public User(String nm, String pw, int pic, String ad, String bd, boolean brd, boolean act, long idd){
        name = nm;
        password = pw;
        birthdate = bd;
        board = brd;
        active = act;
        address = ad;
        id = idd;
        picture = pic;
    }
    
    /**
     * 
     */
    public void suspend() {
        if (active == true) {
            Wielwijk.db.exec("UPDATE users SET active = 0 WHERE id = " + id);
            active = false;
        }
    }

    /**
     * 
     */
    public void unsuspend() {
        if (active == false) {
            Wielwijk.db.exec("UPDATE users SET active = 1 WHERE id = " + id);
            active = true;
        }
    }
    
    
    /**
     * 
     */
    public long getId() {
        return id;
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
    public String getPassword() {
        return password;
    }
    
    /**
     * 
     */
    public String getAddress() {
        return address;
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
    
    public String toString() {
        return name;
    }
}
//user class, spreek voor zich