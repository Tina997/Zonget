package es.ulpgc.montesdeoca110.cristina.zonget.userAgenda;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.EventItem;

public class UserAgendaModel implements UserAgendaContract.Model {

    public static String TAG = UserAgendaModel.class.getSimpleName();

    private final List<EventItem> eventItems = new ArrayList<>();
    private final int COUNT = 1;

    public UserAgendaModel() {
        for(int index = 1; index <= COUNT; index++){
            addDate(createDate(index));
        }

    }

    @Override
    public List<EventItem> fetchData() {
        // Log.e(TAG, "fetchDateListData()");
        return eventItems;
    }

    private void addDate(EventItem item){
        eventItems.add(item);
    }

    private EventItem createDate(int position){
        String content = "Cita" + position;
        return new EventItem(content, position);
    }
}
