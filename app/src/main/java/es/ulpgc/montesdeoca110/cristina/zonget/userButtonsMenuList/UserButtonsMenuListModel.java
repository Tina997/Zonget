package es.ulpgc.montesdeoca110.cristina.zonget.userButtonsMenuList;

import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.UserButtonMenuItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class UserButtonsMenuListModel implements UserButtonsMenuListContract.Model {

    public static String TAG = UserButtonsMenuListModel.class.getSimpleName();

    public RepositoryContract.Settings repository;

    public UserButtonsMenuListModel(RepositoryContract.Settings repository) {
        this.repository = repository;

    }

    @Override
    public List<UserButtonMenuItem> fetchUserButtonsMenuListData() {
        return repository.getUserAdministratorMenuButtons();
    }

}
