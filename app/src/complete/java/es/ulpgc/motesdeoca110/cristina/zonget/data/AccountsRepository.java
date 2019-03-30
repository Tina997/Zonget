package es.ulpgc.motesdeoca110.cristina.zonget.data;

import android.content.Context;

import android.renderscript.ScriptGroup;
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

    private String loadJSONFromAsset(){
        String json = null;

        try {

            InputStream is = context.getAssets().open(JSON_FILE);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        }catch (IOException error){}

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

                for (AccountItem account: accounts) {
                    insertAccount(account);
                }
                for (AccountItem account: accounts) {

                    for (PetsItem pets: account.getPets()) {
                        pets.accountId = account.getId();
                    }
                }

                return true;

            }

        } catch (JSONException error) { }

        return false;

    }

    private void insertAccount(AccountItem account) {
        accounts.add(account);
    }


}
