package es.ulpgc.montesdeoca110.cristina.zonget.app;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "lostPets")
public class LostPetItem {

    @PrimaryKey
    public int id;

    public String name;
    public String picture;
    public String date;
    public String breed;

    public String chipNum;
    public String details;
    public String phoneNum;

}
