package es.ulpgc.montesdeoca110.cristina.zonget.modificarCita;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class ModificarCitaModel implements ModificarCitaContract.Model {

    public static String TAG = ModificarCitaModel.class.getSimpleName();

    public ModificarCitaModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchDateListData()");
        return "Hello";
    }
}