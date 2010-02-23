package jaskirat.taskmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddTaskActivity extends Activity {
	private Button addButton;
	private EditText editText;
	private Button cancelButton;
	protected boolean changespending;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_tasks);
		setUpViews();
	}

	private void setUpViews() {
		editText = (EditText) findViewById(R.id.edit);
		addButton = (Button) findViewById(R.id.add_button);
		cancelButton = (Button) findViewById(R.id.cancel);
		addButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				((TaskManagerApplication) getApplication()).addTask(new Task(
						editText.getText().toString()));
				finish();
			}
		});
		cancelButton.setOnClickListener(new View.OnClickListener() {
			private AlertDialog alertDialog;

			public void onClick(View v) {
				final String taskname=editText.getText().toString();
				if(changespending && taskname.trim()!=""){
				  alertDialog = new AlertDialog.Builder(AddTaskActivity.this)
				.setTitle(R.string.unsaved_changes_title)
				.setMessage(R.string.unsaved_changes_msg)
				.setPositiveButton(R.string.add_task, new AlertDialog.OnClickListener(){
					public void onClick(DialogInterface d, int which){
						((TaskManagerApplication) getApplication()).addTask(new Task(
								taskname));					}
				})
				.setNeutralButton(R.string.discard, new AlertDialog.OnClickListener(){
					public void onClick(DialogInterface d, int which){
						finish();
					}
				})
				.setNegativeButton(R.string.cancel, new AlertDialog.OnClickListener(){
					public void onClick(DialogInterface d, int which){
						alertDialog.cancel();	
					}
				}).create();
				alertDialog.show();
				}
				else
				finish();
			}

		});
		editText.addTextChangedListener(new TextWatcher(){

			@Override
			public void afterTextChanged(Editable s) {

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				changespending=true;
			}
		});
	
	}

}
