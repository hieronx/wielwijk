package wielwijk;

import java.sql.*;
import java.util.*;

/**
 *
 * @author jeroen
 */
public class Database {
    
    private Connection connection;
    
    public Database() {
        
    }
    
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot find the driver in the classpath!", e);
        }
        String username = "ti1210b12";
        String password = "informaticus";
        
        Database db = new Database();
        db.connect("sql.ewi.tudelft.nl", "ti1210b12", "ti1210b12", "informaticus");
        
//        List res = db.query("SELECT * FROM users");
//        
//        for (int i = 0; i < res.size(); i++) {
//            Map<String, Object> map = (HashMap<String, Object>) res.get(i);
//
//            Iterator it = map.entrySet().iterator();
//            while (it.hasNext()) {
//                Map.Entry pairs = (Map.Entry)it.next();
//                System.out.println(pairs.getKey() + " = " + pairs.getValue());
//                it.remove(); // avoids a ConcurrentModificationException
//            }
//            
//            System.out.println("----------");
//        }
    }
    
    /**
     * Connectie maken met de remote database
     * 
     * @param host
     * @param database
     * @param username
     * @param password 
     */
    public void connect(String host, String database, String username, String password) {
        String url = "jdbc:mysql://" + host + ":3306/" + database;
        
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect the database!", e);
        }
    }
    
    /**
     * Een query uitvoeren op de database
     * 
     * @param query
     * @return Een ArrayList van HashMaps(key, value)
     */
    public List query(String query) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery(query);
                        
            List data_list = new ArrayList<HashMap<String, Object>>();
            
            ResultSetMetaData rsmd = res.getMetaData();
            int count = rsmd.getColumnCount();
            
            while (res.next()) {
                Map<String, Object> data = new HashMap<String, Object>();
                for (int i = 1; i <= count; i++) {
                    String name = rsmd.getColumnName(i);
                    data.put(name, res.getObject(i));
                }
                data_list.add(data);
            }

            return data_list;
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect the database!", e);
        }
    }
    
}
