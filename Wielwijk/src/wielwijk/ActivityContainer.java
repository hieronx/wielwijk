
package wielwijk;

public class ActivityContainer {

    public void addActivity(String name, String location, String description, String datetime_begin, String datetime_end, int fee, int lower_user_limit, int upper_user_limit, String lower_limit_date, boolean cancelled) {
        Activity newActivity = new Activity(name, location, description, datetime_begin, datetime_end, fee, lower_user_limit, upper_user_limit, lower_limit_date, cancelled);

        //database create verhaaltje komt hier
    }


    public void removeActivity(Activity activity) {
        //database remove  verhaalte
    }

    public void cancelActivity(Activity activity) {
        //database cancel verhaaltje
    }


    public void findActivity(Activity activity) {
        //database zoek verhaaltje
    }
    

}
