package ar.com.strellis.mytodolist.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

/**
 * A task in the todo-list.
 */
@Entity(tableName = "tasks")
public class Task
{
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    @NonNull
    @ColumnInfo(name="title")
    private String title;
    @ColumnInfo(name="description")
    private String description;
    @ColumnInfo(name="date_added")
    private Date dateAdded;
    @ColumnInfo(name="date_due")
    private Date dateDue;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Date getDateDue() {
        return dateDue;
    }

    public void setDateDue(Date dateDue) {
        this.dateDue = dateDue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
