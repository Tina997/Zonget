package es.ulpgc.montesdeoca110.cristina.zonget.editLostPet;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class EditLostPetModel implements EditLostPetContract.Model {

    public static String TAG = EditLostPetModel.class.getSimpleName();

    public EditLostPetModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
