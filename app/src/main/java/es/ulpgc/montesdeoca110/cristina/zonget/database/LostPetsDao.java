package es.ulpgc.montesdeoca110.cristina.zonget.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.LostPetItem;

@Dao
public interface LostPetsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertLostPet(LostPetItem item);

    @Update
    void updateLostPet(LostPetItem item);

    @Delete
    void deleteLostPet(LostPetItem item);

    @Query("SELECT * FROM lostPets")
    List<LostPetItem> loadLostPets();

    @Query("SELECT * FROM lostPets WHERE id =:id LIMIT 1")
    LostPetItem loadLostPet(int id);
}
