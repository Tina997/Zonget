package es.ulpgc.montesdeoca110.cristina.zonget.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import es.ulpgc.montesdeoca110.cristina.zonget.app.PetForAdoptionItem;
import java.util.List;

@Dao
public interface PetsForAdoptionDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insertPetForAdoption(PetForAdoptionItem item);

  @Update
  void updatePetForAdoption(PetForAdoptionItem item);

  @Delete
  void deletePetForAdoption(PetForAdoptionItem item);

  @Query("SELECT * FROM petsForAdoption")
  List<PetForAdoptionItem> loadPetsForAdoption();

  @Query("SELECT * FROM petsForAdoption WHERE id =:id LIMIT 1")
  PetForAdoptionItem loadPetForAdoption(int id);
}
