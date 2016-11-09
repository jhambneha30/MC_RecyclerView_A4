package neha_android.iiitd.com.mc_assignment4;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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

        //To make the keyboard disappear
//        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//        mgr.hideSoftInputFromWindow(mDetailsEditText.getWindowToken(), 0);

        mTitleEditText = (EditText)findViewById(R.id.editTextTitle);
        mDetailsEditText = (EditText)findViewById(R.id.editTextDetails);

        mSubmitButton = (Button)findViewById(R.id.buttonSubmit);
        final DBHelper dbh  = new DBHelper(this);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title_text = mTitleEditText.getText().toString();
                String details_text = mDetailsEditText.getText().toString();

                if(title_text.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Title cannot be left empty!!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    ThingsToDo todo_obj = new ThingsToDo(title_text,details_text);
                    dbh.addNewTask(todo_obj);

                    Toast.makeText(getApplicationContext(),"Task added to the list!",Toast.LENGTH_SHORT).show();

                    Intent gotoMainActivityIntent = new Intent(view.getContext(), MainActivity.class);
                    startActivity(gotoMainActivityIntent);
                }

            }
        });
    }
}
