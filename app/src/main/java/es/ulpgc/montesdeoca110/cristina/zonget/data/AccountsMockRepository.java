package es.ulpgc.montesdeoca110.cristina.zonget.data;

import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;

public class AccountsMockRepository implements RepositoryContract.Accounts {

    private static AccountsMockRepository INSTANCE;

    private Context context;

    public static AccountsMockRepository getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new AccountsMockRepository(context);
        }
        return INSTANCE;
    }

    private AccountsMockRepository(Context context) {
        this.context = context;
    }

    //Todo Hacer implementación correcta
    @Override
    public boolean checkAccountExist(String accountName, String accountPassword){
        return true;
    }

    @Override
    public AccountItem getAccountInfo(String accountName, String accountPassword){
        return new AccountItem("administrator", "admin", "admin@gmail.com","admin");
        //return new AccountItem("user", "1234", "1234@gmail.com", "1234");
    }

}
