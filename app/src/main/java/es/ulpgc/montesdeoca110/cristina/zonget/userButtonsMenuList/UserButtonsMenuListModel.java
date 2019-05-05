package es.ulpgc.montesdeoca110.cristina.zonget.userButtonsMenuList;

import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class UserButtonsMenuListModel implements UserButtonsMenuListContract.Model {

  public RepositoryContract.Settings repository;

  public UserButtonsMenuListModel(RepositoryContract.Settings repository) {
    this.repository = repository;

  }

  @Override
  public void fetchUserButtonsMenuListData(final RepositoryContract.Settings
          .GetUserMenuButtonsListCallback callback) {
    repository.loadZonget(new RepositoryContract.Settings.FecthZongetDataCallback() {
      @Override
      public void onZongetDataFetched(boolean error) {
        if (!error) {
          repository.getUserMenuButtonsList(callback);
        }
      }
    });
  }
}
