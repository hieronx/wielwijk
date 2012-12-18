/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wielwijk;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Bart
 */
public class Payment {
    private Date datetime;
    private long id;
    private long userid;
    private double amount;
    
    public Payment (String dt, long idd, long u_id, double am){
        try {
            SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            isoFormat.setTimeZone(TimeZone.getTimeZone("CET"));
            datetime = isoFormat.parse(dt);
        } catch(ParseException e) {
            System.out.println(e.getMessage());
        }
        id=idd;
        userid= u_id;
        amount=am;
    }
    
    public Payment (String dt, long u_id, double am){
        try {
            SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            isoFormat.setTimeZone(TimeZone.getTimeZone("CET"));
            datetime = isoFormat.parse(dt);
        } catch(ParseException e) {
            System.out.println(e.getMessage());
        }
        userid= u_id;
        amount=am;
    }
    
    public String toString(){
        return (datetime + "," + id + "," + amount);
    }
    
    public Date getDate(){
        return datetime;
    }
    
    public long getUserid(){
        return userid;
    }
    
    public double getAmount(){
        return amount;
    }
    
}
