package es.ulpgc.montesdeoca110.cristina.zonget.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.PetForAdoptionItem;

public class PetsForAdoptionRepository implements RepositoryContract.PetsForAdoption {

    public static String TAG = PetsForAdoptionRepository.class.getSimpleName();

    // ============================= Variables globales ===========================================

    @SuppressLint("StaticFieldLeak")
    private static PetsForAdoptionRepository INSTANCE;
    private Context context;

    private static final String JSON_FILE = "petsForAdoption.json";
    private static final String JSON_ROOT = "petsForAdoption";

    // --- Lista
    private List<PetForAdoptionItem> petsForAdoption;

    public static RepositoryContract.PetsForAdoption getInstance(Context context) {
        if(INSTANCE == null){
            INSTANCE = new PetsForAdoptionRepository(context);
        }

        return INSTANCE;
    }
    private PetsForAdoptionRepository(Context context){
        this.context = context;
    }

    // ==================================== Métodos ===============================================

    @Override
    public void loadCatalog(final FetchPetsForAdoptionDataCallBack callback) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                boolean error = !loadPetForAdoptionFromJSON(loadJSONFromAsset());

                if(callback != null){
                    callback.onPetsForAdoptionDataFetched(error);
                }
            }
        });
    }

    @Override
    public void getPetsForAdoptionList(final GetPetsForAdoptionListCallback callback) {
        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    callback.setPetsForAdoptionList(loadPetsForAdoptionList());
                }
            }
        });
    }

    @Override
    public void getPetForAdoption(final int id, final GetPetForAdoptionCallback callback) {
        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    callback.setPetsForAdoption(loadPetForAdoption(id));
                }
            }
        });
    }

    // ================================= Métodos privados =========================================

    /** Este método divide la información que contiene el json y pasa la que indicamos a la
     * variable del repositorio.
     *
     * @param json Archivo JSON que contiene la información de la aplicación.
     * @return boolean que nos indica si se ha cargado la información correctamente o no.
     */
    private boolean loadPetForAdoptionFromJSON(String json) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray(JSON_ROOT);

            petsForAdoption = new ArrayList<>();

            if (jsonArray.length() > 0) {

                final PetForAdoptionItem[] petsForAdoption = gson.fromJson(jsonArray.toString(), PetForAdoptionItem[].class);


                for (PetForAdoptionItem item : petsForAdoption) {
                    insertPetForAdoption(item);
                }

                return true;
            }
        } catch (JSONException error) {
            Log.e(TAG, "error: " + error);
        }
        return false;
    }

    /** Este método carga desde la carpeta Assets del proyecto el json con la información de la
     * aplicación.
     *
     * @return La información que contiene el json.
     */
    private String loadJSONFromAsset() {
        String json = null;

        try {
            InputStream is = context.getAssets().open(JSON_FILE);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);

        } catch (IOException error) {
            Log.e(TAG, "error: " + error);
        }
        return json;
    }

    /** Este método obtiene la lista de mascotas para adoptar.
     *
     * @return Lista de mascotas para adoptar.
     */
    private List<PetForAdoptionItem> loadPetsForAdoptionList() {
        return petsForAdoption;
    }

    /** Este método inserta una mascota para adoptar.
     *
     * @param petForAdoption Animal para adoptar.
     */
    private void insertPetForAdoption(PetForAdoptionItem petForAdoption) {
        petsForAdoption.add(petForAdoption);
    }

    /** Este método obtiene una mascota para adoptar a partir de su identificador.
     *
     * @param id Identificador de la mascota para adoptar.
     * @return Mascota para adoptar.
     */
    private PetForAdoptionItem loadPetForAdoption(int id) {
        for (PetForAdoptionItem petForAdoptionItem: petsForAdoption){
            if(petForAdoptionItem.id == id){
                return petForAdoptionItem;
            }
        }
        return null;
    }

}
