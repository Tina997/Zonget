package es.ulpgc.montesdeoca110.cristina.zonget.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AdministratorButtonMenuItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.ChangeThemeItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserButtonMenuItem;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SettingsRepository implements RepositoryContract.Settings {

  // ============================= Variables globales =============================================

  @SuppressLint("StaticFieldLeak")
  private static SettingsRepository INSTANCE;
  private Context context;

  private static final String JSON_FILE = "zonget.json";
  private static final String JSON_THEME = "theme";
  private static final String JSON_ADMINISTRATOR = "administratorButtonsMenu";
  private static final String JSON_USER = "userButtonsMenu";

  // --- Listas
  private List<ChangeThemeItem> themeList;
  private List<AdministratorButtonMenuItem> administratorButtonsMenuList;
  private List<UserButtonMenuItem> userButtonsMenuList;

  public static SettingsRepository getInstance(Context context) {
    if (INSTANCE == null) {
      INSTANCE = new SettingsRepository(context);
    }
    return INSTANCE;
  }

  private SettingsRepository(Context context) {
    this.context = context;
  }

  // ==================================== Métodos =================================================

  @Override
  public void loadZonget(final FecthZongetDataCallback callback) {
    AsyncTask.execute(new Runnable() {

      @Override
      public void run() {

        boolean error = !loadZongetFromJSON(loadJSONFromAsset());

        if (callback != null) {
          callback.onZongetDataFetched(error);
        }
      }
    });
  }

  @Override
  public void getChangeThemeList(final GetChangeThemeListCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (callback != null) {
          callback.setChangeThemeList(themeList);
        }
      }
    });
  }

  // ---------------------------------- Administrator ---------------------------------------------

  @Override
  public void getAdministratorMenuButtonsList(
          final GetAdministratorMenuButtonsListCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (callback != null) {
          callback.setAdministratorMenuButtonsList(administratorButtonsMenuList);
        }
      }
    });
  }

  // -------------------------------------- User --------------------------------------------------

  @Override
  public void getUserMenuButtonsList(final GetUserMenuButtonsListCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (callback != null) {
          callback.setUserMenuButtonsList(userButtonsMenuList);
        }
      }
    });
  }

  // ================================= Métodos privados ===========================================

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

    } catch (IOException ignored) {
    }
    return json;
  }

  /**
   * Este método divide la información que contiene el json y pasa la que indicamos a las
   * variables del repositorio.
   *
   * @param json Archivo JSON que contiene la información de la aplicación.
   * @return boolean que nos indica si se ha cargado la información correctamente o no.
   */
  private boolean loadZongetFromJSON(String json) {

    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();

    try {

      JSONObject jsonObjectTheme = new JSONObject(json);
      JSONArray jsonArrayTheme = jsonObjectTheme.getJSONArray(JSON_THEME);

      themeList = new ArrayList<>();

      JSONObject jsonObjectAdministrator = new JSONObject(json);
      JSONArray jsonArrayAdministrator = jsonObjectAdministrator.getJSONArray(JSON_ADMINISTRATOR);

      administratorButtonsMenuList = new ArrayList<>();

      JSONObject jsonObjectUser = new JSONObject(json);
      JSONArray jsonArrayUser = jsonObjectUser.getJSONArray(JSON_USER);

      userButtonsMenuList = new ArrayList<>();

      if (jsonArrayAdministrator.length() > 0 && jsonArrayUser.length() > 0
              && jsonArrayTheme.length() > 0) {
        final ChangeThemeItem[] themeList = gson.fromJson(jsonArrayTheme.toString(), ChangeThemeItem[].class);

        for (ChangeThemeItem theme : themeList) {
          insertTheme(theme);
        }

        // ---------- Administrator -------------
        final AdministratorButtonMenuItem[] administratorButtonMenuList =
                gson.fromJson(jsonArrayAdministrator.toString(),
                        AdministratorButtonMenuItem[].class);

        for (AdministratorButtonMenuItem button : administratorButtonMenuList) {
          insertAdministratorButton(button);
        }

        // -------------- User ------------------
        final UserButtonMenuItem[] userButtonMenuList =
                gson.fromJson(jsonArrayUser.toString(), UserButtonMenuItem[].class);

        for (UserButtonMenuItem button : userButtonMenuList) {
          insertUserButton(button);
        }

        return true;
      }

    } catch (JSONException ignored) {
    }

    return false;
  }

  /**
   * Este método inserta en la lista de temas un nuevo tema.
   *
   * @param theme Tema.
   */
  private void insertTheme(ChangeThemeItem theme) {
    themeList.add(theme);
  }

  /**
   * Este método inserta en la lista de los botones del menú del administrador un nuevo botón.
   *
   * @param button Botón de administrador.
   */
  private void insertAdministratorButton(AdministratorButtonMenuItem button) {
    administratorButtonsMenuList.add(button);
  }

  /**
   * Este método inserta en la lista de los botones del menú del usuario un nuevo botón.
   *
   * @param button Botón de usuario.
   */
  private void insertUserButton(UserButtonMenuItem button) {
    userButtonsMenuList.add(button);
  }

}
