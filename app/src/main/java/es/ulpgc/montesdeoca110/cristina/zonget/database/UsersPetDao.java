package es.ulpgc.montesdeoca110.cristina.zonget.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.UserPetBDItem;

@Dao
public interface UsersPetDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insertUserPet(UserPetBDItem item);

  @Update
  void updateCategory(UserPetBDItem item);
  //   @Query("UPDATE userPets SET species = :species WHERE id =: id")
  //  void update(String species, int id);

  @Delete
  void deleteCategory(UserPetBDItem item);

  @Query("SELECT * FROM userPets")
  List<UserPetBDItem> loadUserPets();

  @Query("SELECT * FROM userPets WHERE id =:id LIMIT 1")
  UserPetBDItem loadPet(int id);

  @Query("SELECT * FROM userPets WHERE pet_id =:petId")
  UserPetBDItem loadUserPet(int petId);

}

