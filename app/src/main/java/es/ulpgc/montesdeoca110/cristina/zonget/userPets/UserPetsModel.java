package es.ulpgc.montesdeoca110.cristina.zonget.userPets;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class UserPetsModel implements UserPetsContract.Model {

    public static String TAG = UserPetsModel.class.getSimpleName();
    private RepositoryContract.Accounts repository;
    //private final List<PetsItem> itemList = new ArrayList<>();
    //private final int COUNT = 20;

    public UserPetsModel(RepositoryContract.Accounts repository) {
        /*for (int index = 1; index <= COUNT; index++) {
            addPet(createPet(index));
        }*/
        this.repository = repository;
    }

   /* @Override
    public List<PetsItem> fetchPetsData() {
        // Log.e(TAG, "fetchDateListData()");
        return itemList;
    }*/


    @Override
    public void fetchPetsData(final AccountItem item, final RepositoryContract.Accounts.GetUserPetsListCallback callback){
        repository.getUserPetsList(item,callback);
    }
/*
    private void addPet(PetsItem userPetItem) {
        itemList.add(userPetItem);
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
    }*/
}