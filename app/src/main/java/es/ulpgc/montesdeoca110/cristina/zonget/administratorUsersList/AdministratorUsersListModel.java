package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersList;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.UserItem;

public class AdministratorUsersListModel implements AdministratorUsersListContract.Model {

    public static String TAG = AdministratorUsersListModel.class.getSimpleName();
    private final List<UserItem> itemList = new ArrayList<>();
    private final int COUNT = 7;

    public AdministratorUsersListModel() {
        for(int index = 1; index<=COUNT; index++){
            addUser(createUser(index));
        }
    }

    @Override
    public List<UserItem> fetchUsersData() {
        // Log.e(TAG, "fetchInboxData()");
        return itemList;
    }
    private void addUser(UserItem userItem){
        itemList.add(userItem);
    }
    private UserItem createUser(int index){
        String content = "Usuario "+ index;
        String dni = ""+ index + index + index +index + index + index + index+ index + "-X";
        return new UserItem(index,content,dni);
    }
}
