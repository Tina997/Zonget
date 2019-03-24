package es.ulpgc.montesdeoca110.cristina.zonget.userButtonsMenuList;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class UserButtonsMenuListModel implements UserButtonsMenuListContract.Model {

    public static String TAG = UserButtonsMenuListModel.class.getSimpleName();

    public UserButtonsMenuListModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
