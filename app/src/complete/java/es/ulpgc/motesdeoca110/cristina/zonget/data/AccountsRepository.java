package es.ulpgc.motesdeoca110.cristina.zonget.data;

import android.arch.persistence.room.Room;
import android.content.Context;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;
import es.ulpgc.montesdeoca110.cristina.zonget.database.AccountDao;
import es.ulpgc.montesdeoca110.cristina.zonget.database.PetsDao;
import es.ulpgc.montesdeoca110.cristina.zonget.database.ZongetDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
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

    //--------------------------------------------------------------------------------

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
                    getAccountDao().insertAccount(account);
                    callback.onNewAccountInserted();
                }
            }
        });
    }




    //----------------------------Métodos de mascotas---------------------------------
    @Override
    public void getUserPetsList(final AccountItem accountItem, final GetUserPetsListCallback callback) {
        Log.e("", accountItem.getName());
        getUserPetsList(accountItem.getId(),callback);
    }

    @Override
    public void getUserPetsList(final int userId, final GetUserPetsListCallback callback) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                if(callback != null){
                    callback.setUserPetsList(getPetsDao().loadPets(userId));
                }
            }
        });

    }
    //---------------------------- Métodos privados ----------------------------------

    private AccountDao getAccountDao(){
        return database.accountDao();
    }

    private PetsDao getPetsDao(){
        return database.petsDao();
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
                    getAccountDao().insertAccount(account);
                }
                for (AccountItem account : accounts) {

                    for (PetsItem pets : account.getPets()) {
                        pets.userId = account.getId();

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

        AccountItem account = getAccountDao().findAccount(accountName,accountPassword);

        if(account != null){
            return true;
        }

        return false;
    }

    private AccountItem getAccountchecked(String accountName, String accountPassword) {
        return getAccountDao().findAccount(accountName,accountPassword);
    }

    private boolean checkNewAccountData(String accountDni, String accountEmail) {

        AccountItem account = getAccountDao().checkAccountExist(accountDni,accountEmail);

        if(account == null) {
            return false;
        }

        return true;
    }
}
