package jaskirat.taskmanager;

import java.util.ArrayList;

import android.app.Application;

public class TaskManagerApplication extends Application {
	private ArrayList<Task> currentTasks;

	public ArrayList<Task> getCurrentTasks() {
		return currentTasks;
	}

	public void setCurrentTasks(ArrayList<Task> currentTasks) {
		this.currentTasks = currentTasks;
	}

	public void onCreate(){
		super.onCreate();
		if(null == currentTasks){
			currentTasks= new ArrayList<Task>();
		}
	}
	
	public void addTask(Task t){
		assert(t!=null);	
		currentTasks.add(t);
	}
}
