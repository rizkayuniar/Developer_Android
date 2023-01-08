package id.ac.poliban.mi.vb.e020320055.notekeep;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NoteDao {

    // insert note
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Note note);

    // get all notes
    @Query("SELECT * FROM note_table ORDER BY id ASC")
    LiveData<List<Note>> getAllNotes();
}
