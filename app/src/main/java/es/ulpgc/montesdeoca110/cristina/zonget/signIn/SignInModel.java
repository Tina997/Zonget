package es.ulpgc.montesdeoca110.cristina.zonget.signIn;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;

public class SignInModel implements SignInContract.Model {

    public static String TAG = SignInModel.class.getSimpleName();

    public SignInModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchDateListData()");
        return "Hello";
    }

    @Override
    public boolean checkAccount(String accountName, String accountPassword) {
        //Todo Acceder a la base de datos

        return false;
    }

    @Override
    public AccountItem getAccountInfo() {
        //Todo Acceder a la base de datos
        return null;
    }
}
