package ar.com.strellis.mytodolist.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import ar.com.strellis.mytodolist.model.Task;

@Dao
public interface TaskDAO
{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Task task);
    @Query("delete from tasks")
    void deleteAll();
    @Query("select * from tasks order by date_added")
    LiveData<List<Task>> getAllTasksByDateAdded();
}
