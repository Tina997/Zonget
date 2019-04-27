package es.ulpgc.montesdeoca110.cristina.zonget.app;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "queryAnswers")
public class QueryAnswerItem {

    @PrimaryKey
    private int id;
    private String answer;


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
