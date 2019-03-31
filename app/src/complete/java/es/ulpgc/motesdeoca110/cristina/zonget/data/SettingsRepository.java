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

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AdministratorButtonMenuItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.SettingsItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserButtonMenuItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class SettingsRepository implements RepositoryContract.Settings {

    private static SettingsRepository INSTANCE;
    private Context context;

    public static final String JSON_FILE = "zonget.json";
    public static final String JSON_ROOT = "settings";

    private List<AdministratorButtonMenuItem> administratorButtonsMenu;
    private List<UserButtonMenuItem> userButtonsMenu;

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
            JSONArray jsonArray = jsonObject.getJSONArray(JSON_ROOT);

            if (jsonArray.length() > 0) {

                final List<SettingsItem> settings = Arrays.asList(gson.fromJson(jsonArray.toString(), SettingsItem[].class));

                for (SettingsItem setting: settings) {
                    insertAdministratorButtons(setting.administratorMenuButtons);
                    insertUserButtons(setting.userrMenuButtons);
                }

                return true;
            }

        } catch (JSONException error) { }

        return false;
    }

    private void insertAdministratorButtons(List<AdministratorButtonMenuItem> buttonsList) {
        this.administratorButtonsMenu = buttonsList;
    }

    private void insertUserButtons(List<UserButtonMenuItem> buttonsList) {
        this.userButtonsMenu = buttonsList;
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
    public void getAdministratorMenuButtonsList(GetAdministratorMenuButtonsListCallback callback) {

    }

    // ------------------------------ User --------------------------------


}
