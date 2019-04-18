package es.ulpgc.montesdeoca110.cristina.zonget.administratorButtonsMenuList;

import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class AdministratorButtonsMenuListModel implements AdministratorButtonsMenuListContract.Model {

    private RepositoryContract.Settings repository;

    public AdministratorButtonsMenuListModel(RepositoryContract.Settings repository) {
        this.repository = repository;
    }

    @Override
    public void fetchAdministratorButtonsMenuListData(final RepositoryContract.Settings.GetAdministratorMenuButtonsListCallback callback) {
        repository.loadZonget(new RepositoryContract.Settings.FecthZongetDataCallback() {
            @Override
            public void onZongetDataFetched(boolean error) {
                if (!error){
                    repository.getAdministratorMenuButtonsList(callback);
                }
            }
        });
    }
}
