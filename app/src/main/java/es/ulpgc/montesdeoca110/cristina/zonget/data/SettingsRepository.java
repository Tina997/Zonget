package es.ulpgc.montesdeoca110.cristina.zonget.data;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AdministratorButtonMenuItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserButtonMenuItem;

public class SettingsRepository implements RepositoryContract.Settings {

    private static SettingsRepository INSTANCE;
    private Context context;

    private final List<AdministratorButtonMenuItem> administrator_buttons = new ArrayList<>();
    private final List<UserButtonMenuItem> user_buttons = new ArrayList<>();

    public static SettingsRepository getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new SettingsRepository(context);
        }
        return INSTANCE;
    }

    private SettingsRepository(Context context) {
        this.context = context;
    }

    // ------------------------- Administrator ---------------------------
    @Override
    public List<AdministratorButtonMenuItem> getAdministratorMenuButtons() {

        //Añadir ejemplos
        for (int index = 1; index <= 4; index++) {
            addAdministratorButtonMenuItem(createAdministratorButtonMenuItem(index));
        }

        return administrator_buttons;
    }

    private void addAdministratorButtonMenuItem(AdministratorButtonMenuItem item){
        administrator_buttons.add(item);
    }

    private AdministratorButtonMenuItem createAdministratorButtonMenuItem(int position){
        String content = "Button" + position;
        int image_id = R.drawable.logo_claro_completo;
        return new AdministratorButtonMenuItem(position,content,image_id);
    }

    // ------------------------------ User --------------------------------
    @Override
    public List<UserButtonMenuItem> getUserAdministratorMenuButtons() {

        //Añadir ejemplos
        for (int index = 1; index <= 6; index++) {
            addUserButtonMenuItem(createUserButtonMenuItem(index));
        }

        return user_buttons;
    }

    private void addUserButtonMenuItem(UserButtonMenuItem item){
        user_buttons.add(item);
    }

    private UserButtonMenuItem createUserButtonMenuItem(int position){
        String content = "Button" + position;
        int image_id = R.drawable.logo_claro_completo;
        return new UserButtonMenuItem(position,content,image_id);
    }

}
