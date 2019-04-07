package es.ulpgc.montesdeoca110.cristina.zonget.lostPetsDetail;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class LostPetsDetailModel implements LostPetsDetailContract.Model {

    public static String TAG = LostPetsDetailModel.class.getSimpleName();

    public LostPetsDetailModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
