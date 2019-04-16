package es.ulpgc.montesdeoca110.cristina.zonget.changeTheme;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class ChangeThemeModel implements ChangeThemeContract.Model {

    public static String TAG = ChangeThemeModel.class.getSimpleName();

    public ChangeThemeModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
