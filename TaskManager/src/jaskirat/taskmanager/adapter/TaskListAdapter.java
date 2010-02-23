package jaskirat.taskmanager.adapter;

import jaskirat.taskmanager.Task;
import jaskirat.taskmanager.views.TaskListItem;
import jaskirat.taskmanager.R;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class TaskListAdapter extends BaseAdapter {
	private ArrayList<Task> tasks;
	private Context context;

	public TaskListAdapter(ArrayList<Task> listOfItems, Context context) {
		super();
		this.tasks = listOfItems;
		this.context = context;
	}

	@Override
	public int getCount() {
		return tasks.size();
	}

	@Override
	public Task getItem(int position) {
		return tasks!=null? tasks.get(position): null;
	}

	@Override
	public long getItemId(int pos) {
		return pos;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TaskListItem tli;
		if(convertView==null){
			tli=(TaskListItem)View.inflate(context, R.layout.task_list_item, null);
		} else{
			tli=(TaskListItem) convertView;
		}
		tli.setTask(tasks.get(position));
		return tli;
	}

	public void forceReload() {
		notifyDataSetChanged();
	}

	public void toggleTaskAtPosition(int position) {
	tasks.get(position).toggleComplete();	
	notifyDataSetChanged();
	}

	public void removeCompletedTasks() {
		ArrayList<Task> completedTasks = new ArrayList<Task>();
		for (Task task : tasks) {
			if (task.isComplete()) {
				completedTasks.add(task);
			}
		}
		tasks.removeAll(completedTasks);
		notifyDataSetChanged();
	}

}
