package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersList;

import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class AdministratorUsersListModel implements AdministratorUsersListContract.Model {

  public static String TAG = AdministratorUsersListModel.class.getSimpleName();

  RepositoryContract.Users repository;

  public AdministratorUsersListModel(RepositoryContract.Users repository) {
    this.repository = repository;
  }

  @Override
  public void fetchUsersData(final RepositoryContract.Users.GetUsersListCallback callback) {
    repository.loadUsers(true, new RepositoryContract.Users.FetchUsersDataCallBack() {
      @Override
      public void onUsersDataFetched(boolean error) {
        if (!error) {
          repository.getUsersList(callback);
        }
      }
    });
  }
}
