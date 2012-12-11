package wielwijk;

import java.util.*;
import java.sql.Date;


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
    public static void addBoard(String name, String password, int picture, String address, String birthdate) {
        Date bday=Date.valueOf(birthdate);
        System.out.println(bday);
     
        Wielwijk.db.exec("INSERT INTO users (name, password, active, board, picture, address, birthdate) VALUES ('" + name + "', '" + password + "', 1, 1," + picture + ", '" + address + "', '" + bday +"')");
        
        
    
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
    public static void addMember(String name, String password, int picture, String address, String birthdate) {
        Date bday=Date.valueOf(birthdate);
        Member newMember = new Member(name, password, picture, address, birthdate);//nodig??
        
        Wielwijk.db.exec("INSERT INTO users (name, password, active, board, picture, address, birthdate) VALUES ('" + name + "', '" + password + "', 1, 1," + picture + ", '" + address + "', '" + bday +"')");
       
    }
    
    /**
     *
     * @param user
     */
    public static void removeUser(int id) {
        Wielwijk.db.exec("DELETE FROM users WHERE id = " + id);
        //deletes user by id
        //not by name, names are not unique in database
    }

    /**
     *
     * @param user
     */
    public static List findUser(String name) {
      List results = Wielwijk.db.query("SELECT * FROM users WHERE name LIKE '%" + name + "%'");
      return results;
    }
    
    /**
     * 
     * @param id
     */
    public static User getUserById(int id) {
        List res = Wielwijk.db.query("SELECT * FROM users WHERE id = "+id);
        if (res.size()==0) return null;
        
        java.util.Map<String, Object> map = (HashMap<String, Object>) res.get(0);
        
        return new User((String)map.get("name"),(String)map.get("password"),(Integer)map.get("picture"),
                (String)map.get("address"),map.get("birthdate").toString(),(Boolean)map.get("board"),(Long)map.get("id"));
        
    }
    public static void main(String[] args) {
        Wielwijk.getDBConnection();
        addBoard("a","a",1,"a","1122-11-01");
    }
}
