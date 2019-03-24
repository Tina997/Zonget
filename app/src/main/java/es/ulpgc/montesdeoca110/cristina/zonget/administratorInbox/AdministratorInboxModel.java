package es.ulpgc.montesdeoca110.cristina.zonget.administratorInbox;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class AdministratorInboxModel implements AdministratorInboxContract.Model {

    public static String TAG = AdministratorInboxModel.class.getSimpleName();

    public AdministratorInboxModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
