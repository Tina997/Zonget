package es.ulpgc.montesdeoca110.cristina.zonget.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import es.ulpgc.montesdeoca110.cristina.zonget.app.QueryAnswerItem;
import java.util.List;

@Dao
public interface QueryAnswersDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insertQueryAnswer(QueryAnswerItem item);

  @Update
  void updateQueryAnswer(QueryAnswerItem item);

  @Delete
  void deleteQueryAnswer(QueryAnswerItem item);

  @Query("SELECT * FROM queryAnswers")
  List<QueryAnswerItem> loadQueryAnswers();

  @Query("SELECT * FROM queryAnswers WHERE query_id =:queryId LIMIT 1")
  QueryAnswerItem loadQueryAnswer(int queryId);
}
