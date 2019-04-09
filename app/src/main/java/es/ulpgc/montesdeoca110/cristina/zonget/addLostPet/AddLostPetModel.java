package es.ulpgc.montesdeoca110.cristina.zonget.addLostPet;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class AddLostPetModel implements AddLostPetContract.Model {

    public static String TAG = AddLostPetModel.class.getSimpleName();

    public AddLostPetModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
