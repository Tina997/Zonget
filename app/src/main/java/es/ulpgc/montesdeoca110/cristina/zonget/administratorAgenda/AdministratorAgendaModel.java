package es.ulpgc.montesdeoca110.cristina.zonget.administratorAgenda;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.EventItem;

public class AdministratorAgendaModel implements AdministratorAgendaContract.Model {

    public static String TAG = AdministratorAgendaModel.class.getSimpleName();

    private final List<EventItem> eventItems = new ArrayList<>();
    private final int COUNT = 10;

    public AdministratorAgendaModel() {
        for(int index = 1; index <= COUNT; index++){
            addDate(createDate(index));
        }

    }

    @Override
    public List<EventItem> fetchData() {
        // Log.e(TAG, "fetchAdministratorAgendaData()");
        return eventItems;
    }

    private void addDate(EventItem item){
        eventItems.add(item);
    }

    private EventItem createDate(int position){
        String content = "Cita" + position;
        return new EventItem(content, position);
    }

    @Override
    public long fetchDateData(){
        long time = System.currentTimeMillis();
        return time;
    }
}
