
package wielwijk;

public class UserContainer {
    
    public void AddBoard(String name, String password,String birthdate, boolean active, int picture, boolean board){
        Board newBoard = new Board(name, password, birthdate, active, picture);
        
        
        //database create verhaaltje komt hier
    }
    
    public void AddMember(String name, String password,String birthdate, boolean active, int picture, boolean board){
        Member newMember = new Member(name, password, birthdate, active, picture);
        
        
        //database create verhaaltje komt hier
    }
    
    
    public void RemoveUser(User user){
        //datebase remove user verhaalte
    }
    
    public void SuspendUser(User user){
        //datebase user.active verhaaltje
    }
    
    public void UnSuspenduser(User user){
        //datebase user.activer verhaaltje
    }
    
    public void FindUser(User user){
        //database zoek user verhaaltje
    }
    
    
    
}
