package es.ulpgc.motesdeoca110.cristina.zonget.data;

import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

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
