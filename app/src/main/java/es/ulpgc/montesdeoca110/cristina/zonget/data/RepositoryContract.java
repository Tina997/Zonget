package es.ulpgc.montesdeoca110.cristina.zonget.data;

import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AdministratorButtonMenuItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserButtonMenuItem;
import es.ulpgc.motesdeoca110.cristina.zonget.data.AccountsRepository;

public interface RepositoryContract {

    interface Settings{
        List<AdministratorButtonMenuItem> getAdministratorMenuButtons();
        List<UserButtonMenuItem> getUserAdministratorMenuButtons();
    }

    interface Accounts {

        interface CheckAccountExistCallback {
            void onCheckAccountExist(boolean exist, AccountItem account);
        }

    }

}
