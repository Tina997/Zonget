package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPets;

import android.util.Log;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class AdministratorUsersPetsListModel implements AdministratorUsersPetsListContract.Model {

  private static final String TAG = AdministratorUsersPetsListModel.class.getSimpleName();
  private final RepositoryContract.Accounts repository;

  AdministratorUsersPetsListModel(RepositoryContract.Accounts repository) {
    this.repository = repository;
  }

  @Override
  public void fetchPetsData(final AccountItem item, final RepositoryContract.Accounts.GetUserPetsListCallback callback) {
    Log.e(TAG, "fetchPetsData()");
    repository.getUserPetsList(item.getId(), callback);
  }
}
