package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPetDetail;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class AdministratorUserPetsDetailModel implements AdministratorUserPetsDetailContract.Model {

    public static String TAG = AdministratorUserPetsDetailModel.class.getSimpleName();

    public AdministratorUserPetsDetailModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
