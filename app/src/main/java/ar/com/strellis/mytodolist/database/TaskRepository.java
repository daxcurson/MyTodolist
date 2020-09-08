package ar.com.strellis.mytodolist.database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import ar.com.strellis.mytodolist.dao.TaskDAO;
import ar.com.strellis.mytodolist.model.Task;

public class TaskRepository {
    private TaskDAO taskDao;
    private LiveData<List<Task>> tasks;

    public TaskRepository(Application app)
    {
        TaskDatabase db=TaskDatabase.getDatabase(app);
        taskDao=db.taskDao();
        tasks=taskDao.getAllTasksByDateAdded();
    }
    public LiveData<List<Task>> getAllTasksByDateAdded()
    {
        return tasks;
    }
    public void insert(Task task)
    {
        TaskDatabase.databaseWriterExecutor.execute(()->{
            taskDao.insert(task);
        });
    }
}
