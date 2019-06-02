package es.ulpgc.montesdeoca110.cristina.zonget.app;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "accounts")
public class AccountBDItem {

  @PrimaryKey
  private final int id;

  private String name;
  private String dni;
  private String email;
  private String password;

  public AccountBDItem(int id, String name, String dni, String email, String password) {
    this.id = id;
    this.name = name;
    this.dni = dni;
    this.email = email;
    this.password = password;
  }

  public int getId() {
    return id;
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

}
