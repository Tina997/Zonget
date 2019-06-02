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

import es.ulpgc.montesdeoca110.cristina.zonget.app.LostPetItem;

public class LostPetsRepository implements RepositoryContract.LostPets {

  public static String TAG = LostPetsRepository.class.getSimpleName();

  // ============================= Variables globales ===========================================

  @SuppressLint("StaticFieldLeak")
  private static LostPetsRepository INSTANCE;
  private Context context;

  private static final String JSON_FILE = "lostPets.json";
  private static final String JSON_ROOT = "lostPets";

  // --- Lista
  private List<LostPetItem> lostPets;

  public static RepositoryContract.LostPets getInstance(Context context) {
    if (INSTANCE == null) {
      INSTANCE = new LostPetsRepository(context);
    }

    return INSTANCE;
  }

  private LostPetsRepository(Context context) {
    this.context = context;
  }

  // ==================================== Métodos ===============================================

  @Override
  public void loadLostPets(final FetchLostPetsDataCallBack callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        boolean error = !loadLostPetFromJSON(loadJSONFromAsset());

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
          callback.setLostPetsList(loadLostPets());
        }
      }
    });
  }

  @Override
  public void getLostPet(final int id, final GetLostPetCallback callback) {
    AsyncTask.execute(new Runnable() {

      @Override
      public void run() {
        if (callback != null) {
          callback.setLostPets(loadLostPet(id));
        }
      }
    });
  }

  // ================================= Métodos privados =========================================

  /**
   * Este método divide la información que contiene el json y pasa la que indicamos a la
   * variable del repositorio.
   *
   * @param json Archivo JSON que contiene la información de la aplicación.
   * @return boolean que nos indica si se ha cargado la información correctamente o no.
   */
  private boolean loadLostPetFromJSON(String json) {
    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();

    try {

      JSONObject jsonObject = new JSONObject(json);
      JSONArray jsonArray = jsonObject.getJSONArray(JSON_ROOT);

      lostPets = new ArrayList<>();

      if (jsonArray.length() > 0) {

        final LostPetItem[] lostPets = gson.fromJson(jsonArray.toString(), LostPetItem[].class);

        for (LostPetItem lostPetItem : lostPets) {
          insertLostPet(lostPetItem);
        }
        return true;
      }
    } catch (JSONException error) {
      Log.e(TAG, "error: " + error);
    }
    return false;
  }

  /**
   * Este método carga desde la carpeta Assets del proyecto el json con la información de la
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

  /**
   * Este método obtiene la lista de mascotas perdidas.
   *
   * @return Lista de mascotas perdidas.
   */
  private List<LostPetItem> loadLostPets() {
    return lostPets;
  }

  /**
   * Este método inserta una mascota perdida.
   *
   * @param lostPetItem Mascota perdida.
   */
  private void insertLostPet(LostPetItem lostPetItem) {
    lostPets.add(lostPetItem);
  }

  /**
   * Este método obtiene una mascota perdida a partir de su identificador.
   *
   * @param id Identificador de la mascota perdida.
   * @return Mascota perdida.
   */
  private LostPetItem loadLostPet(int id) {
    for (LostPetItem lostPet : lostPets) {
      if (lostPet.id == id) {
        return lostPet;
      }
    }
    return null;
  }

}

