package es.ulpgc.montesdeoca110.cristina.zonget.signIn;

import android.os.AsyncTask;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class SignInModel implements SignInContract.Model{

    public static String TAG = SignInModel.class.getSimpleName();

    private RepositoryContract.Accounts repository;

    public SignInModel(RepositoryContract.Accounts repository) {
        this.repository = repository;
    }


    @Override
    public void checkAccount(final String accountName, final String accountPassword, final RepositoryContract.Accounts.GetCheckAccountExistCallback callback) {
        repository.loadZonget(new RepositoryContract.Accounts.FecthZongetDataCallback() {
            @Override
            public void onZongetDataFetched(boolean error) {
                if (!error){
                    repository.getCheckAccount(accountName, accountPassword, callback);
                }
            }
        });
    }
}
