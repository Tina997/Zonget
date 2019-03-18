package es.ulpgc.montesdeoca110.cristina.zonget.SignUpConfirmation;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class SignUpConfirmationModel implements SignUpConfirmationContract.Model {

    public static String TAG = SignUpConfirmationModel.class.getSimpleName();

    public SignUpConfirmationModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchDateListData()");
        return "Hello";
    }
}
