package es.ulpgc.montesdeoca110.cristina.zonget.administratorButtonsMenuList;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AdministratorButtonMenuItem;

public class AdministratorButtonsMenuListModel implements AdministratorButtonsMenuListContract.Model {

    private final List<AdministratorButtonMenuItem> administrator_buttons = new ArrayList<>();
    private final int COUNT = 6;

    public AdministratorButtonsMenuListModel() {
        //Añadir ejemplos
        for (int index = 1; index <= COUNT; index++) {
            addAdministratorButtonMenuItem(createAdministratorButtonMenuItem(index));
        }
    }

    @Override
    public List<AdministratorButtonMenuItem> fetchAdministratorButtonsMenuListData() {
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
}
