package neha_android.iiitd.com.mc_assignment4;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
/**
 * Created by nehaj on 7/11/16.
 */
public class ToDoThingsAdapter extends RecyclerView.Adapter<ToDoThingsAdapter.ToDoViewHolder> {
    private List<ThingsToDo> things_to_do_list;

    public class ToDoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView mTitleTextBox, mDetailsTextBox;

        public ToDoViewHolder(View view) {
            super(view);
            mTitleTextBox = (TextView) view.findViewById(R.id.title);
            mDetailsTextBox = (TextView) view.findViewById(R.id.details);
            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View v)
        {
            Toast.makeText(v.getContext(),
                    mTitleTextBox.getText() + " clicked!", Toast.LENGTH_SHORT).show();
            Intent extendedToDoThing = new Intent(v.getContext(), ExtendToDoViewPagerActivity.class);
            extendedToDoThing.putExtra("position", getAdapterPosition());
            v.getContext().startActivity(extendedToDoThing);

        }
    }

    public ToDoThingsAdapter(List<ThingsToDo> thingsToDoList) {
        this.things_to_do_list = thingsToDoList;
    }

    @Override
    public ToDoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.todo_list_layout, parent, false);

        return new ToDoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ToDoViewHolder todo_holder, int position) {
        ThingsToDo todo_object = things_to_do_list.get(position);
        todo_holder.mTitleTextBox.setText(todo_object.getTitle());
        todo_holder.mDetailsTextBox.setText(todo_object.getDetails());
    }

    @Override
    public int getItemCount() {
        return things_to_do_list.size();
    }
}
