package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersAddPet;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class AdministratorUsersAddPetModel implements AdministratorUsersAddPetContract.Model {

    public static String TAG = AdministratorUsersAddPetModel.class.getSimpleName();

    public AdministratorUsersAddPetModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchPetsForAdoptionListData()");
        return "Hello";
    }
}
