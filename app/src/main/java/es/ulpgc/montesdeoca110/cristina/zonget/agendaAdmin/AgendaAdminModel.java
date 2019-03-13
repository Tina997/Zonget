package es.ulpgc.montesdeoca110.cristina.zonget.agendaAdmin;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class AgendaAdminModel implements AgendaAdminContract.Model {

    public static String TAG = AgendaAdminModel.class.getSimpleName();

    public AgendaAdminModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
