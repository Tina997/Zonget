package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersList;

import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class AdministratorUsersListModel implements AdministratorUsersListContract.Model {

  public static String TAG = AdministratorUsersListModel.class.getSimpleName();

  private final RepositoryContract.Accounts repository;

  public AdministratorUsersListModel(RepositoryContract.Accounts repository) {
    this.repository = repository;
  }

  @Override
  public void fetchUsersData(final String nameOrDni, final RepositoryContract.Accounts.GetUserListCallback callback) {
    // Log.e(TAG, "fetchInboxData()");
    repository.getUserList(nameOrDni, callback);
  }
}
