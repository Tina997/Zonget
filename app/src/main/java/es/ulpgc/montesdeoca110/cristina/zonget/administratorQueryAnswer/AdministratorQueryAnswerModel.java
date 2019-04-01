package es.ulpgc.montesdeoca110.cristina.zonget.administratorQueryAnswer;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class AdministratorQueryAnswerModel implements AdministratorQueryAnswerContract.Model {

    public static String TAG = AdministratorQueryAnswerModel.class.getSimpleName();

    public AdministratorQueryAnswerModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchPetsForAdoptionListData()");
        return "Hello";
    }
}
