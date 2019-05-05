package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPets;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.UserPetItem;

public class AdministratorUsersPetsListModel implements AdministratorUsersPetsListContract.Model {

    public static String TAG = AdministratorUsersPetsListModel.class.getSimpleName();
    private final List<UserPetItem> itemList = new ArrayList<>();
    private final int COUNT = 20;
    public AdministratorUsersPetsListModel() {
        for (int index = 1; index <= COUNT; index++) {
            addPet(createPet(index));
        }
    }
    @Override
    public List<UserPetItem> fetchPetsData() {
        // Log.e(TAG, "fetchDateListData()");
        return itemList;
    }

    private void addPet(UserPetItem userPetItem) {
        itemList.add(userPetItem);
    }

    private UserPetItem createPet(int posicion) {
        String content = "Mascota " + posicion;
        return new UserPetItem(posicion, content, fetchSpecies(posicion), fetchBreed(posicion), fetchChipNumber(posicion), fetchAnimalNac(posicion));
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
