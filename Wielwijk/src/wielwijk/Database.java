package wielwijk;

import java.sql.*;
import java.util.*;

/**
 *
 * @author jeroen
 */
public class Database {
    
    private Connection connection;
    
    /**
     *
     */
    public Database() {
        
    }
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot find the driver in the classpath!", e);
        }
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
            throw new RuntimeException("Cannot connect to the database: " + e.getMessage() + " (State: " + e.getSQLState() + "; Code: " + e.getErrorCode() + ")", e);
        }
    }
    
    public void connect() {
        this.connect("sql.ewi.tudelft.nl", "ti1210b12", "ti1210b12", "informaticus");
    }
    
    /**
     * Een query uitvoeren op de database en de resultaten terug geven
     * 
     * @param query
     * @return Een ArrayList van HashMaps(key, value)
     */
    public List query(String query) {
        try {
            // Voer de query uit
            Statement stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery(query);
            
            // Een ArrayList van HashMaps
            List data_list = new ArrayList<HashMap<String, Object>>();
            
            // Haal aantal kolommen in resultaten op
            ResultSetMetaData rsmd = res.getMetaData();
            int count = rsmd.getColumnCount();
            
            while (res.next()) {
                // Creeer een HashMap van key-value pairs
                Map<String, Object> data = new HashMap<String, Object>();
                for (int i = 1; i <= count; i++) {
                    // Haal de naam van de desbetreffende kolom op en de waarde als Object en voeg toe aan de HashMap
                    String name = rsmd.getColumnName(i);
                    data.put(name, res.getObject(i));
                }
                
                // Voeg de HashMap toe aan de ArrayList
                data_list.add(data);
            }

            return data_list;
        } catch (SQLException e) {
            throw new RuntimeException("SQLException was thrown: " + e.getMessage(), e);
        }
    }
    
    /**
     * Een query uitvoeren op de database
     * 
     * @param query
     * @return Aantal veranderde rijen
     */
    public int exec(String query) {
        try {
            // Voer de query uit
            Statement stmt = connection.createStatement();
            int rows_affected = stmt.executeUpdate(query);
            return rows_affected;
        } catch (SQLException e) {
            throw new RuntimeException("SQLException was thrown: " + e.getMessage() + " (State: " + e.getSQLState() + "; Code: " + e.getErrorCode() + ")", e);
        }
    }
    
}
