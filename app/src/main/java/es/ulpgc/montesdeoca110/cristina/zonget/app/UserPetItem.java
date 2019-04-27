package es.ulpgc.montesdeoca110.cristina.zonget.app;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "userPets",
        foreignKeys = @ForeignKey(
                entity = PetsItem.class,
                parentColumns = "id",
                childColumns = "pet_id"
        ))
public class UserPetItem {

    @PrimaryKey
    public int id;

    @ColumnInfo(name = "pet_id")
    public int petId;
}
