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
    public void checkAccount(String accountName, String accountPassword, final RepositoryContract.Accounts.CheckAccountExistCallback callback) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                //Todo Implementar búsqueda

                if (callback != null){

                }
            }
        });
    }
}
