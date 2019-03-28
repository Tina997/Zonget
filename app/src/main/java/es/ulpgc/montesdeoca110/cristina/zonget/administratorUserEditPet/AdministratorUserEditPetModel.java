package es.ulpgc.montesdeoca110.cristina.zonget.administratorUserEditPet;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class AdministratorUserEditPetModel implements AdministratorUserEditPetContract.Model {

    public static String TAG = AdministratorUserEditPetModel.class.getSimpleName();

    public AdministratorUserEditPetModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
