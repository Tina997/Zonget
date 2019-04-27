package es.ulpgc.montesdeoca110.cristina.zonget.database;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.UserPetItem;


public interface UsersPetDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCategory(UserPetItem item);

    @Update
    void updateCategory(UserPetItem item);

    @Delete
    void deleteCategory(UserPetItem item);

    @Query("SELECT * FROM userPets")
    List<UserPetItem> loadUserPets();

    @Query("SELECT * FROM userPets WHERE id =:id LIMIT 1")
    UserPetItem loadUserPet(int id);
}
