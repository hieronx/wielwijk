package wielwijk;

public class User {

    private String name;
    private String password;
    private String birthdate;
    private boolean active;
    private int picture;
    private boolean board;
    
    public User(String nm, String pw, String bd, boolean act, int pic, boolean brd) {
        name = nm;
        password = pw;
        birthdate = bd;
        active = act;
        picture = pic;
        board = brd;
    }
}
//user class, spreek voor zich