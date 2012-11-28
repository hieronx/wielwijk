package wielwijk;

/**
 *
 * @author jeroen
 */
public class UserContainer {

    private Database db;
    
    UserContainer() {
        db = new Database();
        db.connect();
    }

    /**
     *
     * @param name
     * @param password
     * @param birthdate
     * @param active
     * @param picture
     * @param board
     */
    public void addBoard(String name, String password,String birthdate, boolean active, int picture, boolean board) {
        Board newBoard = new Board(name, password, birthdate, active, picture);
        

        //database create verhaaltje komt hier
    }

    /**
     *
     * @param name
     * @param password
     * @param birthdate
     * @param active
     * @param picture
     * @param board
     */
    public void addMember(String name, String password,String birthdate, boolean active, int picture, boolean board) {
        Member newMember = new Member(name, password, birthdate, active, picture);
        
        //database create verhaaltje komt hier
    }
    
    /**
     *
     * @param user
     */
    public void removeUser(User user) {
        //datebase remove user verhaalte
    }
    
    /**
     *
     * @param user
     */
    public List findUser(User user) {
      List results = db.query("SELECT * FROM users WHERE name LIKE '%" + name + "%'");
      return results;
        //database zoek user verhaaltje
    }
    
}
