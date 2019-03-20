package es.ulpgc.montesdeoca110.cristina.zonget.signIn;

public class SignInModel implements SignInContract.Model {

    public static String TAG = SignInModel.class.getSimpleName();

    public SignInModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchDateListData()");
        return "Hello";
    }
}
