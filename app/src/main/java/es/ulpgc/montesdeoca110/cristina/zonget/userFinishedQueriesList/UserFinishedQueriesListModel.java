package es.ulpgc.montesdeoca110.cristina.zonget.userFinishedQueriesList;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class UserFinishedQueriesListModel implements UserFinishedQueriesListContract.Model {

    public static String TAG = UserFinishedQueriesListModel.class.getSimpleName();

    public UserFinishedQueriesListModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
