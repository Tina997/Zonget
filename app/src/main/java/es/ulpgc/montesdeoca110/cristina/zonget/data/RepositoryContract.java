package es.ulpgc.montesdeoca110.cristina.zonget.data;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;

public interface RepositoryContract {

    interface Accounts {
        boolean checkAccountExist(String accountName, String accountPassword);
        AccountItem getAccountInfo(String accountName, String accountPassword);
    }

}
