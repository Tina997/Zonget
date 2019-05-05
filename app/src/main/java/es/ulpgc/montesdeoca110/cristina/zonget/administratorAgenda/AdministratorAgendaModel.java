package es.ulpgc.montesdeoca110.cristina.zonget.administratorAgenda;

import es.ulpgc.montesdeoca110.cristina.zonget.app.EventItem;
import java.util.ArrayList;
import java.util.List;

public class AdministratorAgendaModel implements AdministratorAgendaContract.Model {

  public static String TAG = AdministratorAgendaModel.class.getSimpleName();

  private final List<EventItem> eventItems = new ArrayList<>();
  private final int ID = 10;

  public AdministratorAgendaModel() {
    for (int index = 1; index <= ID; index++) {
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
    long time = System.currentTimeMillis();
    return time;
  }
}
