package es.ulpgc.montesdeoca110.cristina.zonget.app;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "petsForAdoption",
        foreignKeys = @ForeignKey(
                entity = PetsItem.class,
                parentColumns = "id",
                childColumns = "pet_id"
        ))
public class PetForAdoptionItem {

  @PrimaryKey
  public int id;

  public String picture;
  public String date;
  public String breed;

  public String details;
  public String phoneNum;

  @ColumnInfo(name = "pet_id")
  public int petId;

}
