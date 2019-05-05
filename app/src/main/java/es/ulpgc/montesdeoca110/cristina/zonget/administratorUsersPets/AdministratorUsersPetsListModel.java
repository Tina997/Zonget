package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPets;

import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;
import java.util.ArrayList;
import java.util.List;

public class AdministratorUsersPetsListModel implements AdministratorUsersPetsListContract.Model {

  public static String TAG = AdministratorUsersPetsListModel.class.getSimpleName();
  private final List<PetsItem> itemList = new ArrayList<>();
  private final int Count = 20;

  public AdministratorUsersPetsListModel() {
    for (int index = 1; index <= Count; index++) {
      addPet(createPet(index));
    }
  }

  @Override
  public List<PetsItem> fetchPetsData() {
    return itemList;
  }

  private void addPet(PetsItem userPetItem) {
    itemList.add(userPetItem);
  }

  private PetsItem createPet(int posicion) {
    String content = "Mascota " + posicion;
    return new PetsItem(posicion, content, fetchSpecies(posicion), fetchBreed(posicion),
            fetchChipNumber(posicion), fetchAnimalNac(posicion));
  }

  private String fetchAnimalNac(int posicion) {
    String fecha = posicion + "/mm/aaaa";
    return fecha;
  }

  private String fetchChipNumber(int posicion) {
    String numero = "" + posicion;
    return numero;
  }

  private String fetchBreed(int posicion) {
    if (posicion % 2 == 0) {
      return "Caniche";
    } else {
      return "Europeo";
    }
  }

  private String fetchSpecies(int posicion) {
    if (posicion % 2 == 0) {
      return "Perro";
    } else {
      return "Gato";
    }
  }
}
