package neha_android.iiitd.com.mc_assignment4;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class ExtendToDoViewPagerActivity extends AppCompatActivity {
    private int pos=0;
    private CustomPagerAdapter cpAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extend_to_do);

//        Toolbar toolbar_todo_extended = (Toolbar) findViewById(R.id.toolbar_extendedToDo);
//        setSupportActionBar(toolbar_todo_extended);
//        ActionBar acBar = getSupportActionBar();
//        acBar.setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                pos = 0;
            } else {
                pos = extras.getInt("position");

            }
        } else {
            pos =  Integer.parseInt((String)savedInstanceState.getSerializable("position"));

        }

        //cpAdapter = new CustomPagerAdapter(this);
        ViewPager viewPager = (ViewPager) findViewById(R.id.todo_viewpager);
        viewPager.setAdapter(new CustomPagerAdapter(this));
        viewPager.setCurrentItem(pos);

        //cpAdapter.notifyDataSetChanged();
    }
}
