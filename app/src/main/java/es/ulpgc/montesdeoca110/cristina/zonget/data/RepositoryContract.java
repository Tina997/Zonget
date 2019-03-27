package es.ulpgc.montesdeoca110.cristina.zonget.data;

import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AdministratorButtonMenuItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserButtonMenuItem;

public interface RepositoryContract {

    interface Settings{
        List<AdministratorButtonMenuItem> getAdministratorMenuButtons();
        List<UserButtonMenuItem> getUserAdministratorMenuButtons();
    }

    interface Accounts {
        boolean checkAccountExist(String accountName, String accountPassword);
        AccountItem getAccountInfo(String accountName, String accountPassword);
    }

}
