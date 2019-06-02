package es.ulpgc.montesdeoca110.cristina.zonget.userAgenda;

import es.ulpgc.montesdeoca110.cristina.zonget.app.EventItem;
import java.util.ArrayList;
import java.util.List;

public class UserAgendaModel implements UserAgendaContract.Model {

  public static String TAG = UserAgendaModel.class.getSimpleName();

  private final List<EventItem> eventItems = new ArrayList<>();

  public UserAgendaModel() {
    int COUNT = 1;
    for (int index = 1; index <= COUNT; index++) {
      addDate(createDate(index));
    }

  }

  @Override
  public List<EventItem> fetchData() {
    return eventItems;
  }

  private void addDate(EventItem item) {
    eventItems.add(item);
  }

  private EventItem createDate(int position) {
    String content = "Cita" + position;
    return new EventItem(content, position);
  }

  @Override
  public long fetchDateData() {
    return System.currentTimeMillis();
  }
}
