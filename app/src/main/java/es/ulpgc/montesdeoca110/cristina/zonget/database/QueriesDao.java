package es.ulpgc.montesdeoca110.cristina.zonget.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import es.ulpgc.montesdeoca110.cristina.zonget.app.QueryItem;
import java.util.List;

@Dao
public interface QueriesDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insertQuery(QueryItem item);

  @Update
  void updateQuery(QueryItem item);

  @Delete
  void deleteQuery(QueryItem item);

  @Query("SELECT * FROM queries")
  List<QueryItem> loadQueries();

  @Query("SELECT * FROM queries WHERE id =:id LIMIT 1")
  QueryItem loadQuery(int id);

  @Query("SELECT * FROM queries WHERE user_id=:userId")
  List<QueryItem> loadQueries(int userId);
}
