package es.ulpgc.montesdeoca110.cristina.zonget.administratorInbox;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.EventItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.QueryItem;

public class AdministratorInboxModel implements AdministratorInboxContract.Model {

    public static String TAG = AdministratorInboxModel.class.getSimpleName();

    private final List<QueryItem> queryItems = new ArrayList<>();
    private final int COUNT = 5;

    public AdministratorInboxModel() {
        for(int i = 0; i <= COUNT; i++){
            addQuery(createQuery(i));
        }
    }

    @Override
    public List<QueryItem> fetchData() {
        // Log.e(TAG, "fetchAdministratorAgendaData()");
        return queryItems;
    }

    private void addQuery(QueryItem item){
        queryItems.add(item);
    }

    private QueryItem createQuery(int position){
        String sender = "Usuario " + position;
        String title = "Asunto " + position;
        return new QueryItem(sender, title, position);
    }
}
