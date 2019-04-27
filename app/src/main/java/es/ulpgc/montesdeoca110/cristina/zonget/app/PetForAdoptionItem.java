package es.ulpgc.montesdeoca110.cristina.zonget.app;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "petsForAdoption")
public class PetForAdoptionItem {

    @PrimaryKey
    public int id;

    public String picture;
    public String date;
    public String breed;

    public String details;
    public String phoneNum;

}
