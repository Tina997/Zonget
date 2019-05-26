package es.ulpgc.montesdeoca110.cristina.zonget.data;

import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AdministratorButtonMenuItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.ChangeThemeItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.FinishedQueryItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.LostPetItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.PetForAdoptionItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.QueryItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserButtonMenuItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserPetItem;
import es.ulpgc.motesdeoca110.cristina.zonget.data.AccountsRepository;
import es.ulpgc.motesdeoca110.cristina.zonget.data.SettingsRepository;

public interface RepositoryContract {

    interface Settings{

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

        void getAdministratorMenuButtonsList(SettingsRepository.GetAdministratorMenuButtonsListCallback callback);

        // -------------------- User -----------------------
        interface GetUserMenuButtonsListCallback {
            void setUserMenuButtonsList(List<UserButtonMenuItem> userButtons);
        }

        void getUserMenuButtonsList(SettingsRepository.GetUserMenuButtonsListCallback callback);

    }

    interface Accounts {

        void insertNewPet(int userID, String name, String species, String breed, String chipNum, String birthday, InsertNewUserPetCallback callback);

        void deleteUserPet(UserPetItem pet, DeleteUserPetCallback deleteUserPetCallback);

        void updatePet(UserPetItem userPetItem, UpdateNewUserPetCallback callback);

        interface FecthZongetDataCallback {
            void onZongetDataFetched(boolean error);
        }

        void loadZonget(boolean clearFirst, AccountsRepository.FecthZongetDataCallback callback);

        interface GetCheckAccountExistCallback {
            void setCheckAccountExist(boolean exist, AccountItem account);
        }

        void getCheckAccount(String accountName, String accountPassword, RepositoryContract.Accounts.GetCheckAccountExistCallback callback);

        interface CheckNewAccountDataExistCallback {
            void setNewAccountExistCallBack(boolean exist, int lastId);
        }

        void checkNewAccountDataExist(String dni, String email, RepositoryContract.Accounts.CheckNewAccountDataExistCallback callback);

        interface InsertNewAccountCallback{
            void onNewAccountInserted();
        }

        void insertNewAccount(AccountItem account, RepositoryContract.Accounts.InsertNewAccountCallback callback);

        interface InsertNewUserPetCallback{
        }
        interface UpdateNewUserPetCallback{
        }
        interface DeleteUserPetCallback{

        }
        interface GetUserPetsListCallback {
            void setUserPetsList(List<UserPetItem> userPets);
        }

        interface GetUserPetsCallback {
            void setUserPets(UserPetItem user);
        }

        void getUserPetsList(int userId, AccountsRepository.GetUserPetsListCallback callback);

        void getUserList(String nameOrDni, AccountsRepository.GetUserListCallback callback);

        interface GetUserListCallback{
            void setUsers(List<AccountItem> users);
        }

    }
    interface LostPets{

        interface FetchLostPetsDataCallBack{
            void onLostPetsDataFetched(boolean error);
        }
        interface GetLostPetsListCallback{
            void setLostPetsList(List<LostPetItem> lostPets);
        }
        interface GetLostPetsCallback{
            void setLostPets(LostPetItem lostPet);
        }
        void loadLostPets(LostPetsRepository.FetchLostPetsDataCallBack callback);
        void getLostPetsList(LostPetsRepository.GetLostPetsListCallback callback);

        void getLostPets(int id, LostPetsRepository.GetLostPetsCallback callback);
    }

    interface PetsForAdoption{

        interface FetchPetsForAdoptionDataCallBack{
            void onPetsForAdoptionDataFetched(boolean error);
        }
        interface GetPetsForAdoptionListCallback{
            void setPetsForAdoptionList(List<PetForAdoptionItem> items);
        }
        interface GetPetsForAdoptionCallback{
            void setPetsForAdoption(PetForAdoptionItem petForAdoption);
        }
        void loadCatalog(PetsForAdoptionRepository.FetchPetsForAdoptionDataCallBack callback);
        void getPetsForAdoptionList(PetsForAdoptionRepository.GetPetsForAdoptionListCallback callback);

        void getPetsForAdoption(int id, PetsForAdoptionRepository.GetPetsForAdoptionCallback callback);
    }

    interface Queries {

        interface SetNewQueryCallback {
            void onNewQuerySet(boolean correct);
        }

        void setNewQuery(int senderUserId, String title, String Content, RepositoryContract.Queries.SetNewQueryCallback callback);

        interface GetPendingQueriesListCallback {
            void setQueriesList(List<QueryItem> pendingQueriesList);
        }

        void getPendindQueriesList(int userId,RepositoryContract.Queries.GetPendingQueriesListCallback callback);

        interface GetFinishedQueriesListCallback {
            void setQueriesList(List<FinishedQueryItem> finishedQueriesList);
        }

        void getFinishedQueriesList(int userId,RepositoryContract.Queries.GetFinishedQueriesListCallback callback);
    }

}
