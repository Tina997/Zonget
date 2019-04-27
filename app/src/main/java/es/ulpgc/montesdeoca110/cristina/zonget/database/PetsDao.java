package es.ulpgc.montesdeoca110.cristina.zonget.database;


import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;


public interface PetsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCategory(PetsItem accountItem);

    @Update
    void updateCategory(PetsItem accountItem);

    @Delete
    void deleteCategory(PetsItem accountItem);

    @Query("SELECT * FROM pets")
    List<PetsItem> loadUsers();

    @Query("SELECT * FROM pets WHERE id =:id LIMIT 1")
    PetsItem loadAccount(int id);
}
