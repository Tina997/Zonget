package es.ulpgc.montesdeoca110.cristina.zonget.data;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.UserItem;
import es.ulpgc.montesdeoca110.cristina.zonget.database.LostPetsDao;
import es.ulpgc.montesdeoca110.cristina.zonget.database.UserDao;
import es.ulpgc.montesdeoca110.cristina.zonget.database.UsersPetDao;
import es.ulpgc.montesdeoca110.cristina.zonget.database.ZongetDatabase;

public class UsersRepository implements RepositoryContract.Users {

    public static String TAG = UsersRepository.class.getSimpleName();

    public static final String DB_FILE = "user.db";
    public static final String JSON_FILE = "zonget.json";
    public static final String JSON_ROOT = "accounts";

    private static UsersRepository INSTANCE;

    private ZongetDatabase database;
    private Context context;

    private UsersRepository(Context context) {
        this.context = context;
        database = Room.databaseBuilder(context, ZongetDatabase.class, DB_FILE).build();
    }

    public static RepositoryContract.Users getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new UsersRepository(context);
        }
        return INSTANCE;
    }

    @Override
    public void loadUsers(final boolean clearFirst, final FetchUsersDataCallBack callback) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                if (clearFirst) {
                    database.clearAllTables();
                }
                boolean error = false;
                if (getUsersDao().loadUsers().size() == 0) {
                    error = !loadUsersFromJSON(loadJSONFromAsset());
                }
                if (callback != null) {
                    callback.onUsersDataFetched(error);
                }
            }


        });
    }


    @Override
    public void getUsersList(final GetUsersListCallback callback) {
        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                if (callback != null) {
                    callback.setUsersList(getUsersDao().loadUsers());
                }
            }
        });
    }

    private UserDao getUsersDao() {
        return database.userDao();
    }

    public boolean loadUsersFromJSON(String json) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        try {

            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray(JSON_ROOT);
            if (jsonArray.length() > 0) {

                final List<UserItem> users = Arrays.asList(
                        gson.fromJson(jsonArray.toString(), UserItem[].class)
                );


                for (UserItem userItem : users) {
                    getUsersDao().insertUser(userItem);
                }

                return true;
            }
        } catch (JSONException error) {
            Log.e(TAG, "error: " + error);
        }
        return false;
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

        } catch (IOException error) {
            Log.e(TAG, "error: " + error);
        }

        return json;
    }


}
