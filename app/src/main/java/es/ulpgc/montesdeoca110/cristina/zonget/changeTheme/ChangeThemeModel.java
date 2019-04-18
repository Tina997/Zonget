package es.ulpgc.montesdeoca110.cristina.zonget.changeTheme;

import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class ChangeThemeModel implements ChangeThemeContract.Model {

    private RepositoryContract.Settings repository;

    public ChangeThemeModel(RepositoryContract.Settings repository) {
        this.repository = repository;
    }

    @Override
    public void fetchChangeThemeListData(final RepositoryContract.Settings.GetChangeThemeListCallback callback) {
        repository.loadZonget(new RepositoryContract.Settings.FecthZongetDataCallback() {
            @Override
            public void onZongetDataFetched(boolean error) {
                if (!error){
                    repository.getChangeThemeList(callback);
                }
            }
        });
    }

}
