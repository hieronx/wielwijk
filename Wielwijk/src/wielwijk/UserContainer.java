package wielwijk;

public class UserContainer {
    
    public void addBoard(String name, String password,String birthdate, boolean active, int picture, boolean board) {
        Board newBoard = new Board(name, password, birthdate, active, picture);
        
        //database create verhaaltje komt hier
    }
    
    public void addMember(String name, String password,String birthdate, boolean active, int picture, boolean board) {
        Member newMember = new Member(name, password, birthdate, active, picture);
        
        //database create verhaaltje komt hier
    }
    
    
    public void removeUser(User user) {
        //datebase remove user verhaalte
    }
    
    public void suspendUser(User user) {
        //datebase user.active verhaaltje
    }
    
    public void unsuspenduser(User user) {
        //datebase user.activer verhaaltje
    }
    
    public void findUser(User user) {
        //database zoek user verhaaltje
    }
    
}
