package es.ulpgc.montesdeoca110.cristina.zonget.app;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "pets",
    foreignKeys = @ForeignKey(
            entity = UserItem.class,
            parentColumns = "id",
            childColumns = "user_id"
    ))

public class PetsItem {

    @PrimaryKey
    private final int id;

    private final String breed;

    @ColumnInfo(name = "user_id")
    private int userId;

    public PetsItem(int id, String breed, int userId) {
        this.id = id;
        this.breed = breed;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public String getBreed() {
        return breed;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
