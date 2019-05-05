package es.ulpgc.montesdeoca110.cristina.zonget.app;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "users",
        foreignKeys = @ForeignKey(
                entity = AccountBDItem.class,
                parentColumns = "id",
                childColumns = "account_id",
                onDelete = CASCADE
        ))
public class UserItem {

    @PrimaryKey
    private final int id;

    private final String rol;

    @ColumnInfo (name = "account_id")
    private int accountId;

    public UserItem(int id, String rol, int accountId) {

        this.id = id;
        this.rol = rol;
        this.accountId =  accountId;
    }

    public int getId() {
        return id;
    }

    public String getRol() {
        return rol;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
