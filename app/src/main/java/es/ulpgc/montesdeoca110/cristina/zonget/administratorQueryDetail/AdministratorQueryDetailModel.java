package es.ulpgc.montesdeoca110.cristina.zonget.administratorQueryDetail;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class AdministratorQueryDetailModel implements AdministratorQueryDetailContract.Model {

    public static String TAG = AdministratorQueryDetailModel.class.getSimpleName();

    public AdministratorQueryDetailModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchPetsForAdoptionListData()");
        return "Hello";
    }
}
