package es.ulpgc.motesdeoca110.cristina.zonget.data;

import android.content.Context;
import android.os.AsyncTask;

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

import es.ulpgc.montesdeoca110.cristina.zonget.app.AdministratorButtonMenuItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserButtonMenuItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class SettingsRepository implements RepositoryContract.Settings {

    private static SettingsRepository INSTANCE;
    private Context context;

    public static final String JSON_FILE = "zonget.json";
    public static final String JSON_ADMINISTRATOR = "administratorButtonsMenu";
    public static final String JSON_USER = "userButtonsMenu";

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

    private String loadJSONFromAsset(){
        String json = null;

        try {

            InputStream is = context.getAssets().open(JSON_FILE);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        }catch (IOException error){}

        return json;
    }

    private boolean loadZongetFromJSON(String json) {

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        try {

            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArrayAdministrator = jsonObject.getJSONArray(JSON_ADMINISTRATOR);
            JSONArray jsonArrayUser = jsonObject.getJSONArray(JSON_USER);

            administratorButtonsMenuList = new ArrayList<>();
            userButtonsMenuList = new ArrayList<>();

            if (jsonArrayAdministrator.length() > 0  && jsonArrayUser.length() > 0) {

                // ---------- Administrator -------------
                final List<AdministratorButtonMenuItem> administratorButtonMenuList = Arrays.asList(gson.fromJson(jsonArrayAdministrator.toString(), AdministratorButtonMenuItem[].class));

                for (AdministratorButtonMenuItem button: administratorButtonMenuList) {
                    insertAdministratorButton(button);
                }

                // -------------- User ------------------
                final List<UserButtonMenuItem> userButtonMenuList = Arrays.asList(gson.fromJson(jsonArrayUser.toString(), UserButtonMenuItem[].class));

                for (UserButtonMenuItem button: userButtonMenuList) {
                    insertUserButton(button);
                }

                return true;
            }

        } catch (JSONException error) { }

        return false;
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

                if(callback != null) {
                    callback.onZongetDataFetched(error);
                }
            }
        });
    }

    // ------------------------- Administrator ---------------------------

    @Override
    public void getAdministratorMenuButtonsList(final GetAdministratorMenuButtonsListCallback callback) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                if (callback != null){
                    callback.setAdministratorMenuButtonsList(administratorButtonsMenuList);
                }
            }
        });
    }

    // ------------------------------ User --------------------------------


}
