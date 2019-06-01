package es.ulpgc.montesdeoca110.cristina.zonget.app;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "queryStatus",
        foreignKeys = @ForeignKey(
                entity = QueryItem.class,
                parentColumns = "id",
                childColumns = "query_id"
        ))
public class QueryStatusItem {

  @PrimaryKey
  public int id;

  @ColumnInfo(name = "query_id")
  public int queryId;

  public boolean finished;

  public QueryStatusItem(int id, int queryId, boolean finished) {
    this.id = id;
    this.queryId = queryId;
    this.finished = finished;
  }
}
