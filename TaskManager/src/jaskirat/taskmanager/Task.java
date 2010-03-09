package jaskirat.taskmanager;

public class Task {
 public String name;
 private boolean complete;
 private long id;

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
public void setId(long id) {
	this.id = id;
}

public long getId() {
	return id;
}
}
