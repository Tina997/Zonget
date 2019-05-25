package es.ulpgc.motesdeoca110.cristina.zonget.data;

import android.arch.persistence.room.Room;
import android.content.Context;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountBDItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserPetBDItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserPetItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;
import es.ulpgc.montesdeoca110.cristina.zonget.database.AccountDao;
import es.ulpgc.montesdeoca110.cristina.zonget.database.PetsDao;
import es.ulpgc.montesdeoca110.cristina.zonget.database.UserDao;
import es.ulpgc.montesdeoca110.cristina.zonget.database.UsersPetDao;
import es.ulpgc.montesdeoca110.cristina.zonget.database.ZongetDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountsRepository implements RepositoryContract.Accounts {

    public static final String DB_FILE = "zonget.db";
    public static final String JSON_FILE = "zonget.json";
    public static final String JSON_ROOT = "accounts";

    private static AccountsRepository INSTANCE;

    private ZongetDatabase database;
    private Context context;

    public static AccountsRepository getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new AccountsRepository(context);
        }
        return INSTANCE;
    }

    private AccountsRepository(Context context) {
        this.context = context;

        database = Room.databaseBuilder(context, ZongetDatabase.class, DB_FILE).build();
    }



    @Override
    public void loadZonget(final boolean clearFirst, final FecthZongetDataCallback callback) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                if (clearFirst) {
                    database.clearAllTables();
                }

                boolean error = false;
                if (getAccountDao().loadAccounts().size() == 0) {
                    error = !loadZongetFromJSON(loadJSONFromAsset());
                }

                if (callback != null) {
                    callback.onZongetDataFetched(error);
                }
            }
        });
    }

    //---------------------------- Métodos de usuarios ----------------------------------

    @Override
    public void getCheckAccount(final String accountName, final String accountPassword, final GetCheckAccountExistCallback callback) {
        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if (callback != null) {
                    boolean exist = checkAccount(accountName, accountPassword);
                    AccountItem account = null;
                    if(exist){
                        account = getAccountchecked(accountName, accountPassword);
                    }
                    callback.setCheckAccountExist(exist, account);
                }
            }
        });

    }

    @Override
    public void checkNewAccountDataExist(final String accountDni, final String accountEmail, final CheckNewAccountDataExistCallback callback) {
        AsyncTask.execute( new Runnable() {
            @Override
            public void run() {
                if (callback != null) {
                    boolean exist = checkNewAccountData(accountDni, accountEmail);
                    int lastId = 0;
                    if(!exist){
                        lastId = getAccountDao().loadAccounts().size() + 1;
                    }
                    callback.setNewAccountExistCallBack(exist, lastId);
                }
            }
        });
    }

    @Override
    public void insertNewAccount(final AccountItem account, final InsertNewAccountCallback callback) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                if (callback != null) {
                    AccountBDItem accountBDItem =  new AccountBDItem(account.getId(),account.getName(),account.getDni(),account.getEmail(),account.getPassword());
                    getAccountDao().insertAccount(accountBDItem);

                    UserItem userItem =  new UserItem(getUserDao().loadUsers().size() + 1,account.getType(),account.getId());
                    getUserDao().insertUser(userItem);

                    callback.onNewAccountInserted();
                }
            }
        });
    }
    @Override
    public void getUserList(final String nameOrDni, final GetUserListCallback callback) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                if(callback != null){
                    callback.setUsers(getUsers(nameOrDni));
                }
            }
        });

    }

    //----------------------------Métodos de mascotas---------------------------------

    @Override
    public void getUserPetsList(final int userId, final GetUserPetsListCallback callback) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                if (callback != null) {
                    callback.setUserPetsList(accountGetPets(userId));
                }
            }
        });

    }
    @Override
    public void insertNewPet(final int userID, final String name, final String species, final String breed, final String chipNum, final String birthday, final InsertNewUserPetCallback callback) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                if(callback != null){
                    PetsItem petsItem = new PetsItem(getPetsDao().loadPets().size()+2 ,breed,userID);
                    getPetsDao().insertPet(petsItem);
                    UserPetBDItem userPetBDItem = new UserPetBDItem(petsItem.getId(),name,species,chipNum,birthday,petsItem.getId());
                    getUserPetDao().insertUserPet(userPetBDItem);

                }
            }
        });
    }

    @Override
    public void deleteUserPet(final UserPetItem pet, final DeleteUserPetCallback deleteUserPetCallback) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                if(deleteUserPetCallback != null){
                    UserPetBDItem userPetBDItem = new UserPetBDItem(pet.getId(),pet.getName(),pet.getSpecies(),pet.getChipNum(),pet.getBirthday(),pet.getPetId());
                    getUserPetDao().deleteCategory(userPetBDItem);

                }
            }
        });
    }

    @Override
    public void updatePet(final UserPetItem pet, final UpdateNewUserPetCallback callback) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                if(callback != null){
                    UserPetBDItem userPetBDItem = new UserPetBDItem(pet.getId(),pet.getName(),pet.getSpecies(),pet.getChipNum(),pet.getBirthday(),pet.getId());
                    getUserPetDao().updateCategory(userPetBDItem);
                    getPetsDao().update(pet.getBreed(),pet.getId());

                }
            }
        });
    }


    //---------------------------- Métodos privados ----------------------------------

    private AccountDao getAccountDao() {
        return database.accountDao();
    }

    private UserDao getUserDao() {
        return database.userDao();
    }

    private PetsDao getPetsDao() {
        return database.petsDao();
    }

    private UsersPetDao getUserPetDao() {
        return database.usersPetDao();
    }

    private String loadJSONFromAsset() {
        String json = null;

        try {

            InputStream is = context.getAssets().open(JSON_FILE);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException error) {
            Log.e("AccountsRepository", "error: " + error);
        }

        return json;
    }

    private boolean loadZongetFromJSON(String json) {


        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        try {

            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray(JSON_ROOT);

            if (jsonArray.length() > 0) {

                final List<AccountItem> accounts = Arrays.asList(gson.fromJson(jsonArray.toString(), AccountItem[].class));

                for (AccountItem account : accounts) {

                    AccountBDItem accountBD = new AccountBDItem(account.getId(), account.getName(), account.getDni(), account.getEmail(), account.getPassword());
                    getAccountDao().insertAccount(accountBD);

                    UserItem userItem = new UserItem(getUserDao().loadUsers().size() + 1, account.getType(), account.getId());
                    getUserDao().insertUser(userItem);

                }

                for (AccountItem account : accounts) {
                    for (UserPetItem pet : account.getPets()) {

                        PetsItem petsItem = new PetsItem(pet.getId(), pet.getBreed(), account.getId());
                        getPetsDao().insertPet(petsItem);

                        UserPetBDItem userPetBDItem = new UserPetBDItem(pet.getId(), pet.getName(), pet.getSpecies(), pet.getChipNum(), pet.getBirthday(), pet.getId());
                        getUserPetDao().insertUserPet(userPetBDItem);

                    }
                }

                return true;
            }

        } catch (JSONException error) {
            Log.e("AccountsRepository", "error: " + error);
        }

        return false;
    }

    private boolean checkAccount(String accountName, String accountPassword) {

        AccountBDItem account = getAccountDao().findAccount(accountName, accountPassword);

        if (account != null) {
            return true;
        }

        return false;
    }

    private AccountItem getAccountchecked(String accountName, String accountPassword) {

        AccountBDItem accountBDItem = getAccountDao().findAccount(accountName, accountPassword);
        UserItem userItem = getUserDao().loadUser(accountBDItem.getId());

        AccountItem account = new AccountItem(accountBDItem.getId(), userItem.getRol(), accountBDItem.getName(), accountBDItem.getDni(), accountBDItem.getEmail(), accountBDItem.getPassword());
        account.setPets(accountGetPets(account.getId()));

        return account;
    }

    private List<UserPetItem> accountGetPets(int userId) {
        List<UserPetItem> pets = new ArrayList<>();
        List<PetsItem> petsItems = getPetsDao().loadPets(userId);
        for (int i = 0; i < petsItems.size(); i++) {
            int petId = petsItems.get(i).getId();
            PetsItem pet = getPetsDao().loadPet(petId);
            UserPetBDItem userPetBDItem = getUserPetDao().loadUserPet(pet.getId());
            if(userPetBDItem!=null) {
                UserPetItem userPetItem = new UserPetItem(userPetBDItem.getId(), userPetBDItem.getName(), userPetBDItem.getSpecies(), pet.getBreed(), userPetBDItem.getChipNum(), userPetBDItem.getBirthday());
                pets.add(userPetItem);
            }
        }

        return pets;
    }

    private List<AccountItem> getUsers(String nameOrDni) {
        List<AccountItem> accountItems = new ArrayList<>();
        List<AccountBDItem> accountBDItems = new ArrayList<>();
        if (getAccountDao().loadAccountFromNameOrDni(nameOrDni) != null) {
            accountBDItems = getAccountDao().loadAccountFromNameOrDni(nameOrDni);
        }
        for (int i = 0; i < accountBDItems.size(); i++) {
            AccountBDItem infoAccount = accountBDItems.get(i);
            UserItem user = getUserDao().loadUser(infoAccount.getId());
            AccountItem accountItem = new AccountItem(infoAccount.getId(), user.getRol(), infoAccount.getName(), infoAccount.getDni(), infoAccount.getEmail(), infoAccount.getPassword());
            accountItems.add(accountItem);
        }
        return accountItems;
    }

    private boolean checkNewAccountData(String accountDni, String accountEmail) {

        AccountBDItem account = getAccountDao().checkAccountExist(accountDni, accountEmail);

        if (account == null) {
            return false;
        }

        return true;
    }

}
