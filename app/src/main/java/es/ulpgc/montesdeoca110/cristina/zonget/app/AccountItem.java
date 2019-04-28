package es.ulpgc.montesdeoca110.cristina.zonget.app;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "accounts")
public class AccountItem {


    @PrimaryKey
    private int id;

    private String type;
    private String name;
    private String dni;
    private String email;
    private String password;

    //REVISAR
    @Ignore
    @SerializedName("pets")
    private List<PetsItem> pets;

    public AccountItem(int id, String type, String name, String dni, String email, String password) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.dni = dni;
        this.email = email;
        this.password = password;
        this.pets = new ArrayList<PetsItem>();
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<PetsItem> getPets() {
        return pets;
    }

    public void setPets(List<PetsItem> pets) {
        this.pets = pets;
    }
}
