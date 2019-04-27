package es.ulpgc.montesdeoca110.cristina.zonget.app;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "userPets")
public class UserPetItem {

    @PrimaryKey
    private int id;
}
