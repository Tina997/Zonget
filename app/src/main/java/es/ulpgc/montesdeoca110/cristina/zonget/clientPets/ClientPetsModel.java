package es.ulpgc.montesdeoca110.cristina.zonget.clientPets;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;

public class ClientPetsModel implements ClientPetsContract.Model {

    public static String TAG = ClientPetsModel.class.getSimpleName();

    private final List<PetsItem> itemList = new ArrayList<>();
    private final int COUNT = 20;

    public ClientPetsModel() {
        for (int index = 1; index <= COUNT; index++) {
            addPet(createPet(index));
        }

    }

    @Override
    public List<PetsItem> fetchPetsData() {
        // Log.e(TAG, "fetchDateListData()");
        return itemList;
    }

    private void addPet(PetsItem clientPetItem) {
        itemList.add(clientPetItem);
    }

    private PetsItem createPet(int posicion) {
        String content = "Mascota " + posicion;
        return new PetsItem(posicion, content, fetchSpecies(posicion), fetchBreed(posicion), fetchChipNumber(posicion), fetchAnimalNac(posicion));
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