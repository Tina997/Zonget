package es.ulpgc.montesdeoca110.cristina.zonget.data;

import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;

public class AccountsRepository implements RepositoryContract.Accounts {

    private static AccountsRepository INSTANCE;

    private Context context;

    public static AccountsRepository getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new AccountsRepository(context);
        }
        return INSTANCE;
    }

    private AccountsRepository(Context context) {
        this.context = context;
    }

    //Todo Hacer implementación correcta
    @Override
    public boolean checkAccountExist(String accountName, String accountPassword){
        return true;
    }

    @Override
    public AccountItem getAccountInfo(String accountName, String accountPassword){
        //return new AccountItem("administrator", "admin", "admin@gmail.com","admin");
        return new AccountItem("user", "admin", "admin@gmail.com", "admin");
    }

}
