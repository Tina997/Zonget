package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersList;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class AdministratorUsersListModel implements AdministratorUsersListContract.Model {

    public static String TAG = AdministratorUsersListModel.class.getSimpleName();

    public AdministratorUsersListModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
