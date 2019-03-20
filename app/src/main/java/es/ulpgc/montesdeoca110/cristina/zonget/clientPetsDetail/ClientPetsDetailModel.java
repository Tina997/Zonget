package es.ulpgc.montesdeoca110.cristina.zonget.clientPetsDetail;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class ClientPetsDetailModel implements ClientPetsDetailContract.Model {

    public static String TAG = ClientPetsDetailModel.class.getSimpleName();

    public ClientPetsDetailModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
