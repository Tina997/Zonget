package es.ulpgc.montesdeoca110.cristina.zonget.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import es.ulpgc.montesdeoca110.cristina.zonget.app.QueryStatusItem;
import java.util.List;

@Dao
public interface QueryStatusDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insertQueryStatus(QueryStatusItem item);

  @Update
  void updateQueryStatus(QueryStatusItem item);

  @Delete
  void deleteQueryStatus(QueryStatusItem item);

  @Query("SELECT * FROM queryStatus")
  List<QueryStatusItem> loadQueryStatus();

  @Query("SELECT * FROM queryStatus WHERE id =:id LIMIT 1")
  QueryStatusItem loadQueryStatus(int id);
}
