package es.ulpgc.montesdeoca110.cristina.zonget.data;

import android.arch.persistence.room.Room;
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
import java.util.Arrays;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserPetItem;
import es.ulpgc.montesdeoca110.cristina.zonget.database.PetsDao;
import es.ulpgc.montesdeoca110.cristina.zonget.database.UsersPetDao;
import es.ulpgc.montesdeoca110.cristina.zonget.database.ZongetDatabase;

public class UserPetsRepository implements RepositoryContract {

    public static String TAG = UserPetsRepository.class.getSimpleName();

    public static final String DB_FILE = "zonget.db";
    public static final String JSON_FILE = "zonget.json";
    public static final String JSON_ROOT = "pets";

    private static UserPetsRepository INSTANCE;

    private ZongetDatabase database;
    private Context context;

    private UserPetsRepository(Context context){
        this.context = context;
        database = Room.databaseBuilder(context, ZongetDatabase.class, DB_FILE).build();
    }
    public static UserPetsRepository getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = new UserPetsRepository(context);
        }
        return INSTANCE;
    }
    //Metodos publicos
  /*  @Override
    public void loadUserPets(final boolean clearFirst, final FetchUserPetsDataCallBack callback) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                if(clearFirst){
                    database.clearAllTables();
                }

                boolean error = false;
                if(getPetsDao().loadPets().size() == 0){
                    error = !loadUserPetsFromFSON(loadJSONFromAsset());
                }
                if(callback != null){
                    callback.onUserPetsDataFetched(error);
                }
            }
        });
    }




    @Override
    public void getUserPetsList(final GetUserPetsListCallback callback) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                if(callback != null){
                    callback.setUserPetsList(getPetsDao().loadPets());
                }
            }
        });
    }
//Metodos privados
    private PetsDao getPetsDao() {
        return database.petsDao();
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
    private boolean loadUserPetsFromFSON(String json) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        try {

            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray(JSON_ROOT);
            if(jsonArray.length() > 0){
                final List<PetsItem> PetsItems = Arrays.asList(
                        gson.fromJson(jsonArray.toString(), PetsItem[].class)
                );
                for (PetsItem PetsItem : PetsItems){
                    getPetsDao().insertPet(PetsItem);
                }
            }
        } catch (JSONException error) {
            Log.e(TAG, "error: " + error);
        }
        return false;
    }*/
}
