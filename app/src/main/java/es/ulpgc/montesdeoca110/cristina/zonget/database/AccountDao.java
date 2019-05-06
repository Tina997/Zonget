package es.ulpgc.montesdeoca110.cristina.zonget.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountBDItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;

@Dao
public interface AccountDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAccount(AccountBDItem item);

    @Update
    void updateAccount(AccountBDItem item);

    @Delete
    void deleteAccount(AccountBDItem item);

    @Query("SELECT * FROM accounts")
    List<AccountBDItem> loadAccounts();

    @Query("SELECT * FROM accounts WHERE id =:id LIMIT 1")
    AccountBDItem loadAccount(int id);

    @Query("SELECT * FROM accounts WHERE name=:name AND password=:password")
    AccountBDItem findAccount(String name, String password);

    @Query("SELECT * FROM accounts WHERE dni=:dni AND email=:email")
    AccountBDItem checkAccountExist(String dni, String email);
}
