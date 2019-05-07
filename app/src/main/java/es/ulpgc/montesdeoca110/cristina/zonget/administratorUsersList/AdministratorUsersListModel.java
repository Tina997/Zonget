package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersList;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class AdministratorUsersListModel implements AdministratorUsersListContract.Model {

    public static String TAG = AdministratorUsersListModel.class.getSimpleName();

    RepositoryContract.Accounts repository;

    public AdministratorUsersListModel(RepositoryContract.Accounts repository) {
        this.repository = repository;
    }

    @Override
    public void fetchUsersData(final String nameOrDni, final RepositoryContract.Accounts.GetUserListCallback callback) {
        // Log.e(TAG, "fetchInboxData()");
        repository.getUserList(nameOrDni, callback);
    }
}
