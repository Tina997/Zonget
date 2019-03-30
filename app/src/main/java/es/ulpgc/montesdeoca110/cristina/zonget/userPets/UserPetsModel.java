package es.ulpgc.montesdeoca110.cristina.zonget.userPets;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;

public class UserPetsModel implements UserPetsContract.Model {

    public static String TAG = UserPetsModel.class.getSimpleName();

    private final List<PetsItem> itemList = new ArrayList<>();
    private final int COUNT = 20;

    public UserPetsModel() {
        for (int index = 1; index <= COUNT; index++) {
            addPet(createPet(index));
        }

    }

    @Override
    public List<PetsItem> fetchPetsData() {
        // Log.e(TAG, "fetchDateListData()");
        return itemList;
    }

    private void addPet(PetsItem userPetItem) {
        itemList.add(userPetItem);
    }

    private PetsItem createPet(int posicion) {
        String content = "Mascota " + posicion;
        return new PetsItem(posicion, accountId, content, fetchSpecies(posicion), fetchBreed(posicion), fetchChipNumber(posicion), fetchAnimalNac(posicion));
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