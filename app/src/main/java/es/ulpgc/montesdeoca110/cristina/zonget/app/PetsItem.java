package es.ulpgc.montesdeoca110.cristina.zonget.app;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;
import static android.arch.persistence.room.ForeignKey.NO_ACTION;

@Entity(tableName = "pets",
    foreignKeys = @ForeignKey(
            entity = UserItem.class,
            parentColumns = "id",
            childColumns = "user_id"
    ))

public class PetsItem {

    @PrimaryKey
    public final int id;

    public final String name, species, breed, chipNum, birthday;

    @ColumnInfo(name = "user_id")
    public int userId;

    public PetsItem(int id, String name, String species, String breed, String chipNum, String birthday) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.chipNum = chipNum;
        this.birthday = birthday;
    }


}
