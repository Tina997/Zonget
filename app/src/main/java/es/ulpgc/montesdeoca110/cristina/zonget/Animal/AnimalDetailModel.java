package es.ulpgc.montesdeoca110.cristina.zonget.Animal;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class AnimalDetailModel implements AnimalDetailContract.Model {

    public static String TAG = AnimalDetailModel.class.getSimpleName();

    public AnimalDetailModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
