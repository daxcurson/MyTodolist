package ar.com.strellis.mytodolist.view;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import ar.com.strellis.mytodolist.database.TaskRepository;
import ar.com.strellis.mytodolist.model.Task;

public class TaskViewModel extends AndroidViewModel
{
    private TaskRepository taskRepository;
    private LiveData<List<Task>> tasks;
    public TaskViewModel(Application app)
    {
        super(app);
        taskRepository=new TaskRepository(app);
        tasks=taskRepository.getAllTasksByDateAdded();
    }
    public LiveData<List<Task>> getAllTasksByDateAdded()
    {
        return tasks;
    }
    public void insert(Task task)
    {
        taskRepository.insert(task);
    }
}
