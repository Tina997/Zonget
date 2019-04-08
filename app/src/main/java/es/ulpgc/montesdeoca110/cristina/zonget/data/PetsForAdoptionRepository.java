package es.ulpgc.montesdeoca110.cristina.zonget.data;

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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.PetForAdoptionItem;

public class PetsForAdoptionRepository implements RepositoryContract.PetsForAdoption {

    public static String TAG = PetsForAdoptionRepository.class.getSimpleName();

   public static final String JSON_FILE = "petsForAdoption.json";
   public static final String JSON_ROOT = "petsForAdoption";

    private static PetsForAdoptionRepository INSTANCE;

    private Context context;
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
    public void getPetsForAdoption(final int id, final GetPetsForAdoptionCallback callback) {
        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if(callback != null) {
                    callback.setPetsForAdoption(loadPetForAdoption(id));
                }
            }
        });
    }



    public boolean loadPetForAdoptionFromJSON(String json) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        try {

            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray(JSON_ROOT);

            petsForAdoption = new ArrayList();

            if (jsonArray.length() > 0) {

                final List<PetForAdoptionItem> petsForAdoption = Arrays.asList(
                        gson.fromJson(jsonArray.toString(), PetForAdoptionItem[].class)
                );


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



   private String loadJSONFromAsset() {
        String json = null;

        try {

            InputStream is = context.getAssets().open(JSON_FILE);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException error) {
            Log.e(TAG, "error: " + error);
        }

        return json;
    }


    private List<PetForAdoptionItem> loadPetsForAdoptionList() {
        return petsForAdoption;
    }
    private void insertPetForAdoption(PetForAdoptionItem petForAdoption) {
        petsForAdoption.add(petForAdoption);
    }
    private PetForAdoptionItem loadPetForAdoption(int id) {
        for (PetForAdoptionItem petForAdoptionItem: petsForAdoption){
            if(petForAdoptionItem.id == id){
                return petForAdoptionItem;
            }
        }
        return null;
    }

}
