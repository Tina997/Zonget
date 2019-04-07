package es.ulpgc.montesdeoca110.cristina.zonget.signUp;

import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class SignUpModel implements SignUpContract.Model {

    public SignUpModel() {

    }


    @Override
    public void checkAccount(String accountDni, String accountEmail, RepositoryContract.Accounts.GetCheckAccountExistCallback callback) {

    }
}
