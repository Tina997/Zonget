package es.ulpgc.montesdeoca110.cristina.zonget.userPendingQueriesList;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class UserPendingQueriesModel implements UserPendingQueriesContract.Model {

    public static String TAG = UserPendingQueriesModel.class.getSimpleName();

    public UserPendingQueriesModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
