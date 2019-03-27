package es.ulpgc.montesdeoca110.cristina.zonget.administratorButtonsMenuList;

import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AdministratorButtonMenuItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class AdministratorButtonsMenuListModel implements AdministratorButtonsMenuListContract.Model {

    private RepositoryContract.Settings repository;

    public AdministratorButtonsMenuListModel(RepositoryContract.Settings repository) {
        this.repository = repository;
    }

    @Override
    public List<AdministratorButtonMenuItem> fetchAdministratorButtonsMenuListData() {
        return repository.getAdministratorMenuButtons();
    }

}
