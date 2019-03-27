package es.ulpgc.montesdeoca110.cristina.zonget.userButtonsMenuList;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;


import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserButtonMenuItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class UserButtonsMenuListModel implements UserButtonsMenuListContract.Model {

    public static String TAG = UserButtonsMenuListModel.class.getSimpleName();

    public RepositoryContract.Settings repository;

    private final List<UserButtonMenuItem> user_buttons = new ArrayList<>();
    private final int COUNT = 6;

    public UserButtonsMenuListModel(RepositoryContract.Settings repository) {
        this.repository = repository;

        //Añadir ejemplos
        for (int index = 1; index <= COUNT; index++) {
            addUserButtonMenuItem(createUserButtonMenuItem(index));
        }
    }

    @Override
    public List<UserButtonMenuItem> fetchUserButtonsMenuListData() {
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
