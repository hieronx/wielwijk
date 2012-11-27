package wielwijk;


public class Member extends User {
    private boolean board=false;
    
    public Member(String nm, String pw, String bd, boolean act, int pic) {
        super(nm, pw, bd, act, pic);
    }
}
