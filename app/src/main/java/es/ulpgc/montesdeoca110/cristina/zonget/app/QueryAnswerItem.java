package es.ulpgc.montesdeoca110.cristina.zonget.app;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "queryAnswers",
        foreignKeys = @ForeignKey(
                entity = QueryItem.class,
                parentColumns = "id",
                childColumns = "query_id"
        ))
public class QueryAnswerItem {

    @PrimaryKey
    public int id;
    public String answer;

    @ColumnInfo(name = "query_id")
    public int queryId;


    public QueryAnswerItem(int id, String answer) {
        this.id = id;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
