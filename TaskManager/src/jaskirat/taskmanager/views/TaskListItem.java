package jaskirat.taskmanager.views;

import jaskirat.taskmanager.Task;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;

public class TaskListItem extends LinearLayout {
	private Task task;

	private CheckedTextView checkedView;
	
	public TaskListItem(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	@Override
	public void onFinishInflate(){
		super.onFinishInflate();
		checkedView= (CheckedTextView)findViewById(android.R.id.text1);
	}
	public Task getTask() {

		return task;
	}

	public void setTask(Task task) {
		this.task = task;
		checkedView.setText(task.getName());
		checkedView.setChecked(task.isComplete());
	}

}
