package es.ulpgc.montesdeoca110.cristina.zonget.petsForAdoption;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class PetsForAdoptionModel implements PetsForAdoptionContract.Model {

    public static String TAG = PetsForAdoptionModel.class.getSimpleName();

    public PetsForAdoptionModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
