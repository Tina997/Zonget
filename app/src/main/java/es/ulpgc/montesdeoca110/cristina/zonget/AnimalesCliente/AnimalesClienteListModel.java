package es.ulpgc.montesdeoca110.cristina.zonget.AnimalesCliente;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class AnimalesClienteListModel implements AnimalesClienteListContract.Model {

    public static String TAG = AnimalesClienteListModel.class.getSimpleName();

    public AnimalesClienteListModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
