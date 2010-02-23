package jaskirat.taskmanager;

public class Task {
 public String name;
 private boolean complete;
 
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Task(String name) {
	super();
	this.name = name;
}

public boolean isComplete() {
	return complete;
}

public void setComplete(boolean complete) {
	this.complete=complete;
}

public void toggleComplete() {
	complete=!complete;
}
}
