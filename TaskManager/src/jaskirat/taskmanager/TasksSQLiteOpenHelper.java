package jaskirat.taskmanager;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
 
public class TasksSQLiteOpenHelper extends SQLiteOpenHelper {
 
	public static final String DB_NAME = "tasks_db.sqllite";
	public static final int VERSION = 1;
 
	public static final String TASKS_TABLE = "tasks";
	public static final String TASK_ID = "id";
	public static final String TASK_NAME = "name";
	public static final String TASK_COMPLETE = "complete";
 
	public TasksSQLiteOpenHelper(Context context) {
		super(context, DB_NAME, null, VERSION);
	}
 
	@Override
	public void onCreate(SQLiteDatabase db) {
		createTable(db);
	}
 
	private void createTable(SQLiteDatabase db) {
		db.execSQL("create table " + TASKS_TABLE + " ( " + 
		TASK_ID + " integer primary key autoincrement not null, " +
		TASK_NAME + " text, " + 
		TASK_COMPLETE + " text " +
		");"
		);
	}
 
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
 
	}
}
