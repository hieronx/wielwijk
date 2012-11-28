package wielwijk;

import java.util.*;

/**
 *
 * @author jeroen
 */
public class UserContainer {

    /**
     *
     * @param name
     * @param password
     * @param birthdate
     * @param active
     * @param picture
     * @param board
     */
    public void addBoard(String name, String password, int picture, String address, String birthdate) {
        Board newBoard = new Board(name, password, picture, address, birthdate);

        Wielwijk.db.exec("INSERT INTO users (name, password, active, board, picture, address) VALUES ('" + name + "', '" + password + "', 1, 1, 0, '" + address + "')");
        //picture nog niet toegevoegd
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
    public void addMember(String name, String password, int picture, String address, String birthdate) {
        Member newMember = new Member(name, password, picture, address, birthdate);
        
        Wielwijk.db.exec("INSERT INTO users (name, password, active, board, picture, address) VALUES ('" + name + "', '" + password + "', 1, 0, 0, '" + address + "')");
        //database create verhaaltje komt hier
    }
    
    /**
     *
     * @param user
     */
    public void removeUser(int id) {
        Wielwijk.db.exec("DELETE FROM users WHERE id = " + id);
        //deletes user by id
        //not by name, names are not unique in database
    }

    /**
     *
     * @param user
     */
    public List findUser(String name) {
      List results = Wielwijk.db.query("SELECT * FROM users WHERE name LIKE '%" + name + "%'");
      return results;
    }
    
}
