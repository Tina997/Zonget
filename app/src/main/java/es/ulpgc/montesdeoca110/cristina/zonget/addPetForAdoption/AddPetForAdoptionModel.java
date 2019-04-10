package es.ulpgc.montesdeoca110.cristina.zonget.addPetForAdoption;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class AddPetForAdoptionModel implements AddPetForAdoptionContract.Model {

    public static String TAG = AddPetForAdoptionModel.class.getSimpleName();

    public AddPetForAdoptionModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
