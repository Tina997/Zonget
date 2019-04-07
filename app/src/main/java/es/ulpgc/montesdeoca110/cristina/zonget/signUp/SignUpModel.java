package es.ulpgc.montesdeoca110.cristina.zonget.signUp;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class SignUpModel implements SignUpContract.Model {

    private RepositoryContract.Accounts repository;

    public SignUpModel(RepositoryContract.Accounts repository) {
        this.repository = repository;
    }


    @Override
    public void checkNewAccount(String accountDni, String accountEmail, RepositoryContract.Accounts.CheckNewAccountDataExistCallback callback) {

    }

    @Override
    public void insertNewAccount(AccountItem account, RepositoryContract.Accounts.InsertNewAccountCallback callback) {

    }
}
