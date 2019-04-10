package es.ulpgc.montesdeoca110.cristina.zonget.editPetForAdoption;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class EditPetForAdoptionModel implements EditPetForAdoptionContract.Model {

    public static String TAG = EditPetForAdoptionModel.class.getSimpleName();

    public EditPetForAdoptionModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
