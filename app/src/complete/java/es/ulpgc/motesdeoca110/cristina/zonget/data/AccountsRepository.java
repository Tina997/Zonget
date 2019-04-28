package es.ulpgc.motesdeoca110.cristina.zonget.data;

import android.content.Context;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountsRepository implements RepositoryContract.Accounts {

    public static final String JSON_FILE = "zonget.json";
    public static final String JSON_ROOT = "accounts";

    private static AccountsRepository INSTANCE;

    private Context context;

    private List<AccountItem> accounts;

    public static AccountsRepository getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new AccountsRepository(context);
        }
        return INSTANCE;
    }

    private AccountsRepository(Context context) {
        this.context = context;
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
        }

        return json;
    }

    private boolean loadZongetFromJSON(String json) {

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        try {

            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray(JSON_ROOT);

            accounts = new ArrayList();

            if (jsonArray.length() > 0) {

                final List<AccountItem> accounts = Arrays.asList(gson.fromJson(jsonArray.toString(), AccountItem[].class));

                for (AccountItem account : accounts) {
                    insertAccount(account);
                }
                for (AccountItem account : accounts) {

                    for (PetsItem pets : account.getPets()) {
                        pets.userId = account.getId();
                    }
                }
                return true;
            }

        } catch (JSONException error) {
        }

        return false;
    }

    private void insertAccount(AccountItem account) {
        accounts.add(account);
    }

    @Override
    public void loadZonget(final FecthZongetDataCallback callback) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                boolean error = !loadZongetFromJSON(loadJSONFromAsset());
                callback.onZongetDataFetched(error);
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
                    AccountItem account = getAccountchecked(accountName, accountPassword);
                    callback.setCheckAccountExist(exist, account);
                }
            }
        });

    }

    @Override
    public void checkNewAccountDataExist(final String accountDni, final String accountEmail, final CheckNewAccountDataExistCallback callback) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                if (callback != null) {
                    boolean exist = checkNewAccount(accountDni, accountEmail);
                    int idForNewAccount = accounts.size() + 1;
                    callback.setNewAccountExistCallBack(exist, idForNewAccount);
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
                    accounts.add(account);
                    callback.onNewAccountInserted();
                }
            }
        });
    }

    private boolean checkAccount(String accountName, String accountPassword) {
        for (AccountItem account : accounts) {
            if (account.getName().equals(accountName) && account.getPassword().equals(accountPassword)) {
                return true;
            }
        }
        return false;
    }

    private AccountItem getAccountchecked(String accountName, String accountPassword) {
        for (AccountItem account : accounts) {
            if (account.getName().equals(accountName) && account.getPassword().equals(accountPassword)) {
                return account;
            }
        }
        return null;
    }

    private boolean checkNewAccount(String accountDni, String accountEmail) {
        for (AccountItem account : accounts) {
            if (account.getDni().equals(accountDni) && account.getEmail().equals(accountEmail)) {
                return true;
            }
        }
        return false;
    }
}
