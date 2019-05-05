package es.ulpgc.montesdeoca110.cristina.zonget.data;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AdministratorButtonMenuItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.ChangeThemeItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.LostPetItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.PetForAdoptionItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserButtonMenuItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserItem;
import es.ulpgc.motesdeoca110.cristina.zonget.data.AccountsRepository;
import es.ulpgc.motesdeoca110.cristina.zonget.data.SettingsRepository;

import java.util.List;

public interface RepositoryContract {

  interface Settings {

    interface FecthZongetDataCallback {
      void onZongetDataFetched(boolean error);
    }

    void loadZonget(SettingsRepository.FecthZongetDataCallback callback);

    interface GetChangeThemeListCallback {
      void setChangeThemeList(List<ChangeThemeItem> themeList);
    }


    void getChangeThemeList(SettingsRepository.GetChangeThemeListCallback callback);

    // ---------------- Administrator ------------------
    interface GetAdministratorMenuButtonsListCallback {
      void setAdministratorMenuButtonsList(List<AdministratorButtonMenuItem> administratorButtons);
    }

    void getAdministratorMenuButtonsList(
            SettingsRepository.GetAdministratorMenuButtonsListCallback callback);

    // -------------------- User -----------------------
    interface GetUserMenuButtonsListCallback {
      void setUserMenuButtonsList(List<UserButtonMenuItem> userButtons);
    }

    void getUserMenuButtonsList(SettingsRepository.GetUserMenuButtonsListCallback callback);

  }

  interface Accounts {

    interface FecthZongetDataCallback {
      void onZongetDataFetched(boolean error);
    }

    void loadZonget(boolean clearFirst, AccountsRepository.FecthZongetDataCallback callback);

    interface GetCheckAccountExistCallback {
      void setCheckAccountExist(boolean exist, AccountItem account);
    }

    void getCheckAccount(String accountName, String accountPassword,
                         RepositoryContract.Accounts.GetCheckAccountExistCallback callback);

    interface CheckNewAccountDataExistCallback {
      void setNewAccountExistCallBack(boolean exist, int lastId);
    }

    void checkNewAccountDataExist(String dni, String email, RepositoryContract.Accounts
            .CheckNewAccountDataExistCallback callback);

    interface InsertNewAccountCallback {
      void onNewAccountInserted();
    }

    void insertNewAccount(AccountItem account,
                          RepositoryContract.Accounts.InsertNewAccountCallback callback);


    interface GetUserPetsListCallback {
      void setUserPetsList(List<PetsItem> userPets);
    }

    interface GetUserPetsCallback {
      void setUserPets(PetsItem user);
    }

    //void loadUserPets(boolean clearFirst, AccountsRepository.FetchUserPetsDataCallBack callback);
    void getUserPetsList(AccountItem accountItem,
                         AccountsRepository.GetUserPetsListCallback callback);

    void getUserPetsList(int userId, AccountsRepository.GetUserPetsListCallback callback);

  }

  interface LostPets {

    interface FetchLostPetsDataCallBack {
      void onLostPetsDataFetched(boolean error);
    }

    interface GetLostPetsListCallback {
      void setLostPetsList(List<LostPetItem> lostPets);
    }

    interface GetLostPetsCallback {
      void setLostPets(LostPetItem lostPet);
    }

    void loadLostPets(boolean clearFirst, LostPetsRepository.FetchLostPetsDataCallBack callback);

    void getLostPetsList(LostPetsRepository.GetLostPetsListCallback callback);

    void getLostPets(int id, LostPetsRepository.GetLostPetsCallback callback);
  }

  interface PetsForAdoption {

    interface FetchPetsForAdoptionDataCallBack {
      void onPetsForAdoptionDataFetched(boolean error);
    }

    interface GetPetsForAdoptionListCallback {
      void setPetsForAdoptionList(List<PetForAdoptionItem> items);
    }

    interface GetPetsForAdoptionCallback {
      void setPetsForAdoption(PetForAdoptionItem petForAdoption);
    }

    void loadCatalog(PetsForAdoptionRepository.FetchPetsForAdoptionDataCallBack callback);

    void getPetsForAdoptionList(PetsForAdoptionRepository.GetPetsForAdoptionListCallback callback);

    void getPetsForAdoption(int id, PetsForAdoptionRepository.GetPetsForAdoptionCallback callback);
  }

  interface Users {

    interface FetchUsersDataCallBack {
      void onUsersDataFetched(boolean error);
    }

    interface GetUsersListCallback {
      void setUsersList(List<UserItem> users);
    }

    interface GetUsersCallback {
      void setUsers(UserItem user);
    }

    void loadUsers(boolean clearFirst, UsersRepository.FetchUsersDataCallBack callback);

    void getUsersList(UsersRepository.GetUsersListCallback callback);
  }
  /* interface UserPets {

      interface FetchUserPetsDataCallBack {
          void onUserPetsDataFetched(boolean error);
      }

      interface GetUserPetsListCallback {
          void setUserPetsList(List<PetsItem> userPets);
      }

      interface GetUserPetsCallback {
          void setUserPets(PetsItem user);
      }

      void loadUserPets(boolean clearFirst,
      UserPetsRepository.FetchUserPetsDataCallBack callback);

      void getUserPetsList(UserPetsRepository.GetUserPetsListCallback callback);
  }*/

}
