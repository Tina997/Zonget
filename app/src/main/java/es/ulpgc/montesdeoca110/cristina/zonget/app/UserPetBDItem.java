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
public class UserPetBDItem {

    @PrimaryKey
    private int id;

    private final String name, species, chipNum, birthday;

    @ColumnInfo(name = "pet_id")
    private int petId;

    public UserPetBDItem(int id, String name, String species, String chipNum, String birthday, int petId) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.chipNum = chipNum;
        this.birthday = birthday;
        this.petId = petId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public String getChipNum() {
        return chipNum;
    }

    public String getBirthday() {
        return birthday;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }
}
