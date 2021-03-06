package ar.com.strellis.mytodolist.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ar.com.strellis.mytodolist.dao.TaskDAO;
import ar.com.strellis.mytodolist.model.Task;

@Database(entities={Task.class},version = 1,exportSchema = false)
@TypeConverters({DateConverter.class})
public abstract class TaskDatabase extends RoomDatabase
{
    public abstract TaskDAO taskDao();
    private static volatile TaskDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS=4;
    static final ExecutorService databaseWriterExecutor= Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static TaskDatabase getDatabase(final Context context)
    {
        if(INSTANCE==null)
        {
            synchronized (TaskDatabase.class) {
                if(INSTANCE==null) {
                    INSTANCE= Room.databaseBuilder(context.getApplicationContext(),
                            TaskDatabase.class,"task_database").build();
                }
            }
        }
        return INSTANCE;
    }
}
