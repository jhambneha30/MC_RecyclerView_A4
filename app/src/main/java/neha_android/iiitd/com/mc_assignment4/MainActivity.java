package neha_android.iiitd.com.mc_assignment4;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static List<ThingsToDo> todoList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ToDoThingsAdapter mAdapter;
    private Button mAddNewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DBHelper db_obj = new DBHelper(this);
        todoList = db_obj.getCompleteToDoList();

        recyclerView = (RecyclerView) findViewById(R.id.todo_recycler_view);

        mAddNewButton = (Button) findViewById(R.id.addNewBtn);

        mAddNewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addNewTask = new Intent(view.getContext(), AddNewToDoActivity.class);
                startActivity(addNewTask);
            }
        });

        mAdapter = new ToDoThingsAdapter(todoList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        mAdapter.notifyDataSetChanged();
        //createList();

    }


    private void createList() {
        ThingsToDo thing = new ThingsToDo("Breakfast", "Make breakfast");
        todoList.add(thing);

        thing = new ThingsToDo("Do office work", "office office");
        todoList.add(thing);

        thing = new ThingsToDo("hey", "Make breakfast");
        todoList.add(thing);

        thing = new ThingsToDo("Breakfast", "Make breakfast");
        todoList.add(thing);

        thing = new ThingsToDo("funny", "Make breakfast");
        todoList.add(thing);

        thing = new ThingsToDo("cute", "Make breakfast");
        todoList.add(thing);

        thing = new ThingsToDo("best", "Make breakfast");
        todoList.add(thing);

        thing = new ThingsToDo("todo", "Make breakfast");
        todoList.add(thing);

        thing = new ThingsToDo("pretty", "Make breakfast");
        todoList.add(thing);

        thing = new ThingsToDo("brazil", "Make breakfast");
        todoList.add(thing);

        thing = new ThingsToDo("bazinga!", "Make breakfast");
        todoList.add(thing);


        mAdapter.notifyDataSetChanged();
    }

}
