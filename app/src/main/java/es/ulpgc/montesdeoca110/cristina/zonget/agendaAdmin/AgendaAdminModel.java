package es.ulpgc.montesdeoca110.cristina.zonget.agendaAdmin;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.App.CitaItem;

public class AgendaAdminModel implements AgendaAdminContract.Model {

    public static String TAG = AgendaAdminModel.class.getSimpleName();

    private final List<CitaItem> citaItems = new ArrayList<>();
    private final int COUNT = 10;

    public AgendaAdminModel() {
        for(int index = 1; index <= COUNT; index++){
            addDate(createDate(index));
        }

    }

    @Override
    public List<CitaItem> fetchData() {
        // Log.e(TAG, "fetchDateListData()");
        return citaItems;
    }

    private void addDate(CitaItem item){
        citaItems.add(item);
    }

    private CitaItem createDate(int position){
        String content = "Cita" + position;
        return new CitaItem(content);
    }
}
