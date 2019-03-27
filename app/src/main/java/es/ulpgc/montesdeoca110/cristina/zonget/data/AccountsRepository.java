package es.ulpgc.montesdeoca110.cristina.zonget.data;

import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;

public class AccountsRepository implements RepositoryContract.Accounts {

    private static AccountsRepository INSTANCE;

    private Context context;

    public static AccountsRepository getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = new AccountsRepository(context);
        }
        return INSTANCE;
    }

    private AccountsRepository(Context context){
        this.context = context;
    }

    @Override
    public boolean checkAccountExist(String accountName, String accountPassword) {
        return false;
    }

    @Override
    public AccountItem getAccountInfo(String accountName, String accountPassword) {
        return null;
    }

}
