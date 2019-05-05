package es.ulpgc.montesdeoca110.cristina.zonget.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.UserItem;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(UserItem item);

    @Update
    void updateUser(UserItem item);

    @Delete
    void deleteUser(UserItem item);

    @Query("SELECT * FROM users")
    List<UserItem> loadUsers();

    @Query("SELECT * FROM users WHERE account_id =:accountId LIMIT 1")
    UserItem loadUser(int accountId);
}
