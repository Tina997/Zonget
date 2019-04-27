package es.ulpgc.montesdeoca110.cristina.zonget.app;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "users")
public class UserItem {

    @PrimaryKey
    public final int id;

    public final String name, DNI;

    public UserItem(int id, String name, String dni) {

        this.id = id;
        this.name = name;
        DNI = dni;
    }
}
