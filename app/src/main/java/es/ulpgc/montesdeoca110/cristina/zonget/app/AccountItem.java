package es.ulpgc.montesdeoca110.cristina.zonget.app;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class AccountItem {

  private int id;

  private String type;
  private String name;
  private String dni;
  private String email;
  private String password;

  @SerializedName("pets")
  private List<UserPetItem> pets;

  public AccountItem(int id, String type, String name, String dni, String email, String password) {
    this.id = id;
    this.type = type;
    this.name = name;
    this.dni = dni;
    this.email = email;
    this.password = password;
    this.pets = new ArrayList<UserPetItem>();
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

  public List<UserPetItem> getPets() {
    return pets;
  }

  public void setPets(List<UserPetItem> pets) {
    this.pets = pets;
  }
}
