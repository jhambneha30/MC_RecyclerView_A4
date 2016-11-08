package neha_android.iiitd.com.mc_assignment4;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNewToDoActivity extends AppCompatActivity {
    private EditText mTitleEditText;
    private EditText mDetailsEditText;
    private Button mSubmitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_to_do);


//        Toolbar toolbar_todo_add = (Toolbar) findViewById(R.id.toolbar_addToDo);
//        setSupportActionBar(toolbar_todo_add);

//        ActionBar acBar = getSupportActionBar();
//        acBar.setDisplayHomeAsUpEnabled(true);

        mTitleEditText = (EditText)findViewById(R.id.editTextTitle);
        mDetailsEditText = (EditText)findViewById(R.id.editTextDetails);

        mSubmitButton = (Button)findViewById(R.id.buttonSubmit);
        final DBHelper dbh  = new DBHelper(this);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title_text = mTitleEditText.getText().toString();
                String details_text = mDetailsEditText.getText().toString();

                ThingsToDo todo_obj = new ThingsToDo(title_text,details_text);
                dbh.addNewTask(todo_obj);

                Toast.makeText(getApplicationContext(),"Task added to the list!",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
