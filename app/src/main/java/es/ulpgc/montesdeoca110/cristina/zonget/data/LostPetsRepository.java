package es.ulpgc.montesdeoca110.cristina.zonget.data;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import es.ulpgc.montesdeoca110.cristina.zonget.app.LostPetItem;
import es.ulpgc.montesdeoca110.cristina.zonget.database.LostPetsDao;
import es.ulpgc.montesdeoca110.cristina.zonget.database.ZongetDatabase;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LostPetsRepository implements RepositoryContract.LostPets {

  public static String TAG = LostPetsRepository.class.getSimpleName();

  public static final String DB_FILE = "lostPets.db";
  public static final String JSON_FILE = "lostPets.json";
  public static final String JSON_ROOT = "lostPets";

  private static LostPetsRepository INSTANCE;

  private ZongetDatabase database;
  private Context context;
  //private List<LostPetItem> lostPets;

  public static RepositoryContract.LostPets getInstance(Context context) {
    if (INSTANCE == null) {
      INSTANCE = new LostPetsRepository(context);
    }

    return INSTANCE;
  }

  private LostPetsRepository(Context context) {
    this.context = context;
    database = Room.databaseBuilder(context, ZongetDatabase.class, DB_FILE).build();
  }


  @Override
  public void loadLostPets(final boolean clearFirst, final FetchLostPetsDataCallBack callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (clearFirst) {
          database.clearAllTables();
        }
        boolean error = false;
        if (getLostPetsDao().loadLostPets().size() == 0) {
          error = !loadLostPetFromJSON(loadJSONFromAsset());
        }
        if (callback != null) {
          callback.onLostPetsDataFetched(error);
        }
      }


    });
  }


  @Override
  public void getLostPetsList(final GetLostPetsListCallback callback) {
    AsyncTask.execute(new Runnable() {

      @Override
      public void run() {
        if (callback != null) {
          callback.setLostPetsList(getLostPetsDao().loadLostPets());
        }
      }
    });
  }


  @Override
  public void getLostPets(final int id, final GetLostPetsCallback callback) {
    AsyncTask.execute(new Runnable() {

      @Override
      public void run() {
        if (callback != null) {
          callback.setLostPets(getLostPetsDao().loadLostPet(id));
        }
      }
    });
  }


  public boolean loadLostPetFromJSON(String json) {
    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();

    try {

      JSONObject jsonObject = new JSONObject(json);
      JSONArray jsonArray = jsonObject.getJSONArray(JSON_ROOT);


      if (jsonArray.length() > 0) {

        final List<LostPetItem> lostPets = Arrays.asList(
                gson.fromJson(jsonArray.toString(), LostPetItem[].class)
        );


        for (LostPetItem lostPetItem : lostPets) {
          getLostPetsDao().insertLostPet(lostPetItem);
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

  /* private List<LostPetItem> loadLostPets() {
       return lostPets;
   }
   private void insertLostPet(LostPetItem lostPetItem) {
       lostPets.add(lostPetItem);
   }
   private LostPetItem loadLostPet(int id) {
       for (LostPetItem lostPet: lostPets){
           if(lostPet.id == id){
               return lostPet;
           }
       }
       return null;
   }*/
  private LostPetsDao getLostPetsDao() {
    return database.lostPetsDao();
  }
}
