package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPets;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserPetItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class AdministratorUsersPetsListModel implements AdministratorUsersPetsListContract.Model {

    public static String TAG = AdministratorUsersPetsListModel.class.getSimpleName();
    private RepositoryContract.Accounts repository;
    AdministratorUsersPetsListModel(RepositoryContract.Accounts repository) {
        this.repository = repository;
    }
    @Override
    public void fetchPetsData(final AccountItem item, final RepositoryContract.Accounts.GetUserPetsListCallback callback){
        repository.getUserPetsList(item.getId(),callback);
    }
}
