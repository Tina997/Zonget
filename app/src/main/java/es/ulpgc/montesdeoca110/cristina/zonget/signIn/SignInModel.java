package es.ulpgc.montesdeoca110.cristina.zonget.signIn;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class SignInModel implements SignInContract.Model{

    public static String TAG = SignInModel.class.getSimpleName();

    private RepositoryContract.Accounts repository;

    public SignInModel(RepositoryContract.Accounts repository) {
        this.repository = repository;
    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchDateListData()");
        return "Hello";
    }

    @Override
    public boolean checkAccount(String accountName, String accountPassword) {
        return repository.checkAccountExist(accountName,accountPassword);
    }

    @Override
    public AccountItem getAccountInfo(String accountName, String accountPassword) {
        return repository.getAccountInfo(accountName,accountPassword);
    }
}
