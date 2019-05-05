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

        database = Room.databaseBuilder(context,ZongetDatabase.class, DB_FILE).build();
    }

    @Override
    public void loadZonget(final boolean clearFirst, final FecthZongetDataCallback callback) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                if(clearFirst){
                    database.clearAllTables();
                }

                boolean error = false;
                if(getAccountDao().loadAccounts().size() == 0){
                    error = !loadZongetFromJSON(loadJSONFromAsset());
                }

                if(callback != null){
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

    //----------------------------Métodos de mascotas---------------------------------

    @Override
    public void getUserPetsList(final int userId, final GetUserPetsListCallback callback) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                if(callback != null){
                    //callback.setUserPetsList();
                }
            }
        });

    }

    //---------------------------- Métodos privados ----------------------------------

    private AccountDao getAccountDao(){
        return database.accountDao();
    }

    private UserDao getUserDao(){
        return database.userDao();
    }

    private PetsDao getPetsDao(){
        return database.petsDao();
    }

    private UsersPetDao getUserPetDao(){
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
            Log.e("AccountsRepository","error: " + error);
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

                    AccountBDItem accountBD = new AccountBDItem(account.getId(),account.getName(),account.getDni(),account.getEmail(),account.getPassword());
                    getAccountDao().insertAccount(accountBD);

                    UserItem userItem = new UserItem(getUserDao().loadUsers().size() + 1,account.getType(),account.getId());
                    getUserDao().insertUser(userItem);

                }

                for (AccountItem account : accounts) {
                    for (UserPetItem pet : account.getPets()) {

                        PetsItem petsItem = new PetsItem(pet.getId(),pet.getBreed(),account.getId());
                        getPetsDao().insertPet(petsItem);

                        //TODO no se estan insertando
                        int userPetId = getUserPetDao().loadUserPets().size() + 1;
                        UserPetBDItem userPetBDItem = new UserPetBDItem(userPetId,pet.getName(),pet.getSpecies(),pet.getChipNum(),pet.getBirthday(),pet.getId());
                        getUserPetDao().insertUserPet(userPetBDItem);

                    }
                }

                return true;
            }

        } catch (JSONException error) {
            Log.e("AccountsRepository","error: " + error);
        }

        return false;
    }

    private boolean checkAccount(String accountName, String accountPassword) {

        AccountBDItem account = getAccountDao().findAccount(accountName,accountPassword);

        if(account != null){
            return true;
        }

        return false;
    }

    private AccountItem getAccountchecked(String accountName, String accountPassword) {

        AccountBDItem accountBDItem =  getAccountDao().findAccount(accountName,accountPassword);
        UserItem userItem = getUserDao().loadUser(accountBDItem.getId());

        AccountItem account =  new AccountItem(accountBDItem.getId(),userItem.getRol(), accountBDItem.getName(),accountBDItem.getDni(),accountBDItem.getEmail(),accountBDItem.getPassword());
        account.setPets(accountGetPets(account.getId()));

        return account;
    }

    private List<UserPetItem> accountGetPets(int userId){


        Log.e("Cuenta: "+ userId,"(Yguanira = 1)");

        List<UserPetItem> pets =  new ArrayList<>();

        List<PetsItem>  petsBD = getPetsDao().loadPets(userId);

        Log.e("Cuenta: "+ userId,"PetsBD " + petsBD);

        for (int i = 0; i <= petsBD.size(); i++){

            Log.e("Cuenta: "+ userId,"PetsBD size " + petsBD.size());

            PetsItem userPet = petsBD.get(i);

            Log.e("Cuenta: "+ userId,"PetsBD: " + petsBD.get(i).getId() +" "+petsBD.get(i).getBreed() +" "+petsBD.get(i).getUserId());

            UserPetBDItem infoUserPet = getUserPetDao().loadUserPet(userPet.getId());

            Log.e("Cuenta: "+ userId,"infoPet: " + infoUserPet);

            Log.e("Cuenta: "+ userId,"infoPet: " + getUserPetDao().loadUserPets());

            UserPetItem userPetItem = new UserPetItem(infoUserPet.getId(),infoUserPet.getName(),infoUserPet.getSpecies(),userPet.getBreed(),infoUserPet.getChipNum(),infoUserPet.getBirthday());
            pets.add(userPetItem);
        }

        return pets;
    }

    private boolean checkNewAccountData(String accountDni, String accountEmail) {

        AccountBDItem account = getAccountDao().checkAccountExist(accountDni,accountEmail);

        if(account == null) {
            return false;
        }

        return true;
    }
}
