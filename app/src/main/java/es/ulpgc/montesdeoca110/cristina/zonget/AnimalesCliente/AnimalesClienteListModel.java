package es.ulpgc.montesdeoca110.cristina.zonget.AnimalesCliente;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.App.AnimalClientesItem;

public class AnimalesClienteListModel implements AnimalesClienteListContract.Model {

    public static String TAG = AnimalesClienteListModel.class.getSimpleName();

    private final List<AnimalClientesItem> itemList = new ArrayList<>();
    private final int COUNT = 20;
    public AnimalesClienteListModel() {
        for(int index = 1; index<=COUNT; index++){
            addPet(createPet(index));
        }

    }

    @Override
    public List<AnimalClientesItem> fetchAnimalesListData() {
        // Log.e(TAG, "fetchDateListData()");
        return itemList;
    }
    private void addPet(AnimalClientesItem animalClientesItem){
        itemList.add(animalClientesItem);
    }
    private AnimalClientesItem createPet(int posicion){
        String content = "Mascota "+ posicion;
        return new AnimalClientesItem(posicion,content,fetchAnimalEspecie(posicion),fetchAnimalRaza(posicion),fetchAnimalNumChip(posicion), fetchAnimalNac(posicion));
    }

    private String fetchAnimalNac(int posicion) {
        String fecha = posicion+"/mm/aaaa";
        return fecha;
    }

    private String fetchAnimalNumChip(int posicion) {
        String numero = ""+posicion;
        return numero;
    }

    private String fetchAnimalRaza(int posicion) {
        if(posicion%2 == 0){
            return "Caniche";
        }else{
            return "Europeo";
        }
    }

    private String fetchAnimalEspecie(int posicion) {
        if(posicion%2==0){
            return "perro";
        }else{
            return "gato";
        }
    }
}
