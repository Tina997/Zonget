package es.ulpgc.montesdeoca110.cristina.zonget.app;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "pets")
public class PetsItem {

    @PrimaryKey
    public final int id;

    public final String name, species, breed, chipNum, birthday;

    public int accountId;

    public PetsItem(int id, String name, String species, String breed, String chipNum, String birthday) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.chipNum = chipNum;
        this.birthday = birthday;
    }


}
