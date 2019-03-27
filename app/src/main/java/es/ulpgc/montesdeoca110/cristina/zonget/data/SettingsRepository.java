package es.ulpgc.montesdeoca110.cristina.zonget.data;

import android.content.Context;

import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AdministratorButtonMenuItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserButtonMenuItem;

public class SettingsRepository implements RepositoryContract.Settings {

    private static SettingsRepository INSTANCE;

    private Context context;

    public static SettingsRepository getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new SettingsRepository(context);
        }
        return INSTANCE;
    }

    private SettingsRepository(Context context) {
        this.context = context;
    }

    @Override
    public List<AdministratorButtonMenuItem> getAdministratorMenuButtons() {
        return null;
    }

    @Override
    public List<UserButtonMenuItem> getUserAdministratorMenuButtons() {
        return null;
    }
}
