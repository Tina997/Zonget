package es.ulpgc.montesdeoca110.cristina.zonget.app;

import java.util.ArrayList;
import java.util.List;

public class AccountItem {

    private String type;
    private String name;
    private String email;
    private String password;

    private List<PetsItem> pets;

    public AccountItem(String type, String name, String email, String password) {
        this.type = type;
        this.name = name;
        this.email = email;
        this.password = password;
        this.pets = new ArrayList<PetsItem>();
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<PetsItem> getPets() {
        return pets;
    }
}
