package ar.com.strellis.mytodolist;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import ar.com.strellis.mytodolist.model.Task;

public class AddTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        Button button_save=(Button)findViewById(R.id.button_task_save);
        TextView task_title=(TextView) findViewById(R.id.task_title);
        TextView task_description=(TextView) findViewById(R.id.task_description);
        EditText task_due_date=(EditText) findViewById(R.id.task_date_due);
        button_save.setOnClickListener(v -> {
            String title=task_title.getText().toString();
            String description=task_description.getText().toString();
            String due_date=task_due_date.getText().toString();
            Task task=new Task();
            task.setTitle(title);
            task.setDescription(description);
            @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf=new SimpleDateFormat("d/m/Y");
            try {
                task.setDateDue(sdf.parse(due_date));
                MainActivity.database.taskDao().insert(task);
                Snackbar.make(v, getString(R.string.task_saved), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            finish();
        }
        );
    }
}