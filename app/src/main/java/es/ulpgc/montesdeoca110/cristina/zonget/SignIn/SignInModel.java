package es.ulpgc.montesdeoca110.cristina.zonget.SignIn;

import android.util.Log;

public class SignInModel implements SignInContract.Model {

    public static String TAG = SignInModel.class.getSimpleName();

    public SignInModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
