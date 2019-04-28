package es.ulpgc.montesdeoca110.cristina.zonget.database;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;

@Dao
public interface PetsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPet(PetsItem item);

    @Update
    void updatePet(PetsItem item);

    @Delete
    void deletePet(PetsItem item);

    @Query("SELECT * FROM pets")
    List<PetsItem> loadPets();

    @Query("SELECT * FROM pets WHERE id =:id LIMIT 1")
    PetsItem loadPet(int id);
}
