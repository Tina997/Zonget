package es.ulpgc.montesdeoca110.cristina.zonget.agendaAdmin;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.CitaItem;

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
        return new CitaItem(content, position);
    }
}
