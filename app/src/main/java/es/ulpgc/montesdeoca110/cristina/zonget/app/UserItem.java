package es.ulpgc.montesdeoca110.cristina.zonget.app;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "users",
        foreignKeys = @ForeignKey(
                entity = AccountItem.class,
                parentColumns = "id",
                childColumns = "account_id",
                onDelete = CASCADE
        ))
public class UserItem {

    @PrimaryKey
    public final int id;

    public final String name, dni;

    @ColumnInfo (name = "account_id")
    public int accountId;

    public UserItem(int id, String name, String dni) {

        this.id = id;
        this.name = name;
        this.dni = dni;
    }
}
