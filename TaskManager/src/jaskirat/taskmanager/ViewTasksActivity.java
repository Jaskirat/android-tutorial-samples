package jaskirat.taskmanager;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewTasksActivity extends Activity {
    private Button addButton;
	private TextView taskText;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setUpViews();
    }

	protected void onResume(){
		super.onResume();
		showTasks();
	}
	private void showTasks(){
		ArrayList<Task> tasks=((TaskManagerApplication)getApplication()).getCurrentTasks();
		StringBuffer sb= new StringBuffer();
		for(Task t:tasks){
			sb.append(String.format("* %s\n",t.getName().toString()));
		}
		taskText.setText(sb.toString());		
	}
	private void setUpViews() {
		addButton=(Button) findViewById(R.id.add_button);
		taskText=(TextView) findViewById(R.id.tasks_list);
		addButton.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
			Intent intent = new Intent(ViewTasksActivity.this,AddTaskActivity.class);
			startActivity(intent);
			}
		});
	}
}