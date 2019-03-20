package es.ulpgc.montesdeoca110.cristina.zonget.signUpConfirmation;

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
