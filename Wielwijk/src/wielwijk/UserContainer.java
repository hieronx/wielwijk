
package wielwijk;

public class UserContainer {
    
    public void AddUser(String name, String password,String birthdate, boolean active, int picture, boolean board){
        User newuser = new User(name, password, birthdate, active, picture, board);
    }
    
}
