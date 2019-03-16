package es.ulpgc.montesdeoca110.cristina.zonget.agregarCita;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class AgregarCitaModel implements AgregarCitaContract.Model {

    public static String TAG = AgregarCitaModel.class.getSimpleName();

    public AgregarCitaModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
