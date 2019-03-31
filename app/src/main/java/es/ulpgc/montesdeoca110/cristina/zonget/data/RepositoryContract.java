package es.ulpgc.montesdeoca110.cristina.zonget.data;

import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AdministratorButtonMenuItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserButtonMenuItem;
import es.ulpgc.motesdeoca110.cristina.zonget.data.AccountsRepository;
import es.ulpgc.motesdeoca110.cristina.zonget.data.SettingsRepository;

public interface RepositoryContract {

    interface Settings{

        interface FecthZongetDataCallback {
            void onZongetDataFetched(boolean error);
        }

        void loadZonget(SettingsRepository.FecthZongetDataCallback callback);

        // ---------------- Administrator ------------------
        interface GetAdministratorMenuButtonsListCallback {
            void setAdministratorMenuButtonsList(List<AdministratorButtonMenuItem> administratorButtons);
        }

        void getAdministratorMenuButtonsList(SettingsRepository.GetAdministratorMenuButtonsListCallback callback);
    }

    interface Accounts {

        interface FecthZongetDataCallback {
            void onZongetDataFetched(boolean error);
        }

        void loadZonget(AccountsRepository.FecthZongetDataCallback callback);

        interface GetCheckAccountExistCallback {
            void setCheckAccountExist(boolean exist, AccountItem account);
        }

        void getCheckAccount(String accountName, String accountPassword, RepositoryContract.Accounts.GetCheckAccountExistCallback callback);



    }

}
