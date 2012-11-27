package wielwijk;

import java.sql.*;

/**
 *
 * @author jeroen
 */
public class Database {
    
    
    public Database() {
        
    }
    
    public static void main(String[] args) {
        System.out.println("bla");
        /*try{
            Connection dbConnection=DriverManager.getConnection("jdbc:mysql://sql.ewi.tudelft.nl:3306/ti1210b12","ti1210b12","informaticus");
           }
           catch( SQLException x ){
                   System.out.println( "Couldn’t get connection!" );
           }*/
//        try {
//            System.out.println("Loading driver...");
//            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("Driver loaded!");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException("Cannot find the driver in the classpath!", e);
//        }
//        
//        String url = "jdbc:mysql://sql.ewi.tudelft.nl:3306/ti1210b12";
//        String username = "ti1210b12";
//        String password = "informaticus";
//        
//        Connection connection = null;
//        
//        try {
//            System.out.println("Connecting database...");
//            connection = DriverManager.getConnection(url, username, password);
//            System.out.println("Database connected!");
//        } catch (SQLException e) {
//            throw new RuntimeException("Cannot connect the database!", e);
//        } finally {
//            System.out.println("Closing the connection.");
//            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
//        }
    }
    
}
