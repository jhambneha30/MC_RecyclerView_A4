package neha_android.iiitd.com.mc_assignment4;

import java.util.UUID;

/**
 * Created by nehaj on 7/11/16.
 */
public class ThingsToDo {
    private String rv_title,rv_details;
    private static int temp = 0;
    private int todo_id;

    //Constructor
    public ThingsToDo() {

    }

    public ThingsToDo(String rv_title, String rv_details) {
        todo_id = ++temp;
        this.rv_title = rv_title;
        this.rv_details = rv_details;
    }

    //Getter and setter methods
    public int getId() {
        return todo_id;
    }


    public String getTitle() {
        return rv_title;
    }

    public void setTitle(String rv_title) {
        this.rv_title = rv_title;
    }

    public String getDetails() {
        return rv_details;
    }

    public void setDetails(String rv_details) {
        this.rv_details = rv_details;
    }



}
