/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wielwijk;

import java.util.HashMap;

/**
 *
 * @author Bart
 */
public class PaymentContainer {
    
    public static int addPayment(Payment payment){
        Wielwijk.getDBConnection();
        Wielwijk.db.exec("INSERT INTO payments(user_id, datetime, amount) VALUES (" + payment.getUserid() + ",'" 
                            + (payment.getDate().getTime())/1000 + "'," + payment.getAmount() + ")" );
        java.util.List results = Wielwijk.db.query("SELECT id FROM payments ORDER BY id DESC LIMIT 1");
        java.util.Map<String, Object> map = (HashMap<String, Object>) results.get(0);
        int id = Integer.parseInt(String.valueOf((Long)map.get("id")));
        return id;
    }
    
    public static void removePayment(long id){
        Wielwijk.getDBConnection();
        Wielwijk.db.exec("DELETE * FROM payments WHERE id=" + String.valueOf(id));
    }
    
    public static double getBalance(long userid){
        if (Wielwijk.db.query("SELECT * FROM balances WHERE user_id="+ userid).isEmpty()){
            System.out.println("zero");
            Wielwijk.db.exec("INSERT INTO balances(user_id, balance) VALUES (" + userid + ",(SELECT SUM(amount) FROM payments WHERE user_id=" + String.valueOf(userid));
        }
        else {
            
            Wielwijk.db.exec("UPDATE balances SET balance=(SELECT SUM(amount) FROM payments WHERE user_id=" + String.valueOf(userid) + ") WHERE user_id="+String.valueOf(userid));
            System.out.println("not zero");
        }
        
        java.util.List results = Wielwijk.db.query("SELECT balance FROM balances WHERE user_id=" + String.valueOf(userid));
        java.util.Map<String, Object> map = (HashMap<String, Object>) results.get(0);
        double balance = (Double)map.get("balance");
        
        return balance;
    }
    
    
    
}
