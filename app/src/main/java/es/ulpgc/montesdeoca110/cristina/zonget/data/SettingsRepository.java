package es.ulpgc.montesdeoca110.cristina.zonget.data;

import android.content.Context;
import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AdministratorButtonMenuItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.ChangeThemeItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserButtonMenuItem;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SettingsRepository implements RepositoryContract.Settings {

  private static SettingsRepository INSTANCE;
  private Context context;

  public static final String JSON_FILE = "zonget.json";
  public static final String JSON_THEME = "theme";
  public static final String JSON_ADMINISTRATOR = "administratorButtonsMenu";
  public static final String JSON_USER = "userButtonsMenu";

  private String actualThemeName;
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
    }

    return json;
  }

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
        final List<ChangeThemeItem> themeList = Arrays.asList(
                gson.fromJson(jsonArrayTheme.toString(), ChangeThemeItem[].class));

        for (ChangeThemeItem theme : themeList) {
          insertTheme(theme);
        }

        // ---------- Administrator -------------
        final List<AdministratorButtonMenuItem> administratorButtonMenuList =
                Arrays.asList(gson.fromJson(jsonArrayAdministrator.toString(),
                        AdministratorButtonMenuItem[].class));

        for (AdministratorButtonMenuItem button : administratorButtonMenuList) {
          insertAdministratorButton(button);
        }

        // -------------- User ------------------
        final List<UserButtonMenuItem> userButtonMenuList =
                Arrays.asList(gson.fromJson(jsonArrayUser.toString(), UserButtonMenuItem[].class));

        for (UserButtonMenuItem button : userButtonMenuList) {
          insertUserButton(button);
        }

        return true;
      }

    } catch (JSONException error) {
    }

    return false;
  }

  private void insertTheme(ChangeThemeItem theme) {
    themeList.add(theme);
  }

  private void insertAdministratorButton(AdministratorButtonMenuItem button) {
    administratorButtonsMenuList.add(button);
  }

  private void insertUserButton(UserButtonMenuItem button) {
    userButtonsMenuList.add(button);
  }

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

  // ------------------------- Administrator ---------------------------

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

  // ------------------------------ User --------------------------------

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

}
