package neha_android.iiitd.com.mc_assignment4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nehaj on 8/11/16.
 */
public class DBHelper extends SQLiteOpenHelper {

    //Database version
    private static final int DATABASE_VERSION = 1;
    //Database name
    public static final String DATABASE_NAME = "ToDoListDatabase";
    //Table name
    public static final String TODO_TABLE_NAME = "todo_table";
    public static final String TODO_COLUMN_ID = "todo_id";
    public static final String TODO_COLUMN_TITLE = "todo_title";
    public static final String TODO_COLUMN_DETAILS = "todo_details";

    //DBHelper constructor
    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }

    //Creating tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_TODO=
                "create table " + TODO_TABLE_NAME +
                        "(" + TODO_COLUMN_TITLE + " TEXT PRIMARY KEY," + TODO_COLUMN_DETAILS + " TEXT, "+ TODO_COLUMN_ID + " INTEGER)";
        db.execSQL(CREATE_TABLE_TODO);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TODO_TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    // Resetting database
    public void onReset(SQLiteDatabase db) {
        // Drop older table if existed
        db.execSQL("DELETE FROM " + TODO_TABLE_NAME);

        // Create tables again
        //onCreate(db);
    }

    // Adding new todo task
    public void addNewTask(ThingsToDo todo) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        System.out.println("Todo inside database :"+todo.getTitle());
        values.put(TODO_COLUMN_TITLE, todo.getTitle());
        values.put(TODO_COLUMN_DETAILS, todo.getDetails());
        values.put(TODO_COLUMN_ID, todo.getId());

        // Inserting new record
        db.insert(TODO_TABLE_NAME, null, values);
        // Closing database connection
        db.close();

    }

    public ThingsToDo getRecord(String title) {
        SQLiteDatabase db = this.getReadableDatabase();

        String getquotequery = "SELECT * FROM " + TODO_TABLE_NAME + " WHERE "+TODO_COLUMN_TITLE+" = "+title;
        Cursor cursor = db.rawQuery(getquotequery,null);

        if (cursor != null)
            cursor.moveToFirst();

        ThingsToDo todo = new ThingsToDo(cursor.getString(0),cursor.getString(1));
        // return todo
        return todo;
    }

    // Getting All Todos
    public List<ThingsToDo> getCompleteToDoList() {
        List<ThingsToDo> todo_list = new ArrayList<ThingsToDo>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TODO_TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ThingsToDo todo = new ThingsToDo();
                todo.setTitle(cursor.getString(0));
                todo.setDetails(cursor.getString(1));
                // Adding task
                todo_list.add(todo);
            } while (cursor.moveToNext());
        }

        // return todo list
        return todo_list;
    }
}
