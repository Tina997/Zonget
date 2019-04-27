package es.ulpgc.montesdeoca110.cristina.zonget.database;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;

public interface AccountDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCategory(AccountItem item);

    @Update
    void updateCategory(AccountItem item);

    @Delete
    void deleteCategory(AccountItem item);

    @Query("SELECT * FROM accounts")
    List<AccountItem> loadAccounts();

    @Query("SELECT * FROM accounts WHERE id =:id LIMIT 1")
    AccountItem loadAccount(int id);


}
