package es.ulpgc.montesdeoca110.cristina.zonget.AdministratorMenu;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class AdministratorMenuModel implements AdministratorMenuContract.Model {

    public static String TAG = AdministratorMenuModel.class.getSimpleName();

    public AdministratorMenuModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
