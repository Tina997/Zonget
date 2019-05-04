package es.ulpgc.montesdeoca110.cristina.zonget.signIn;

import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class SignInModel implements SignInContract.Model{

    private RepositoryContract.Accounts repository;

    public SignInModel(RepositoryContract.Accounts repository) {
        this.repository = repository;
    }


    @Override
    public void checkAccount(final String accountName, final String accountPassword, final RepositoryContract.Accounts.GetCheckAccountExistCallback callback) {
        repository.loadZonget(false,new RepositoryContract.Accounts.FecthZongetDataCallback() {
            @Override
            public void onZongetDataFetched(boolean error) {
                if (!error){
                    repository.getCheckAccount(accountName, accountPassword, callback);
                }
            }
        });
    }
}
