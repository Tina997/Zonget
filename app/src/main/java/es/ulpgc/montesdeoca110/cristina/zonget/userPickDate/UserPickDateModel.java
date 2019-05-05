package es.ulpgc.montesdeoca110.cristina.zonget.userPickDate;

import es.ulpgc.montesdeoca110.cristina.zonget.app.HourItem;
import java.util.ArrayList;
import java.util.List;

public class UserPickDateModel implements UserPickDateContract.Model {

  public static String TAG = UserPickDateModel.class.getSimpleName();
  private final List<HourItem> hourItems = new ArrayList<>();
  private final int Count = 10;

  public UserPickDateModel() {
    for (int index = 1; index <= Count; index++) {
      addDate(createDate(index));
    }

  }

  @Override
  public List<HourItem> fetchData() {
    // Log.e(TAG, "fetchAdministratorAgendaData()");
    return hourItems;
  }

  private void addDate(HourItem item) {
    hourItems.add(item);
  }

  private HourItem createDate(int position) {
    String content = "Hora " + position;
    return new HourItem(content, position);
  }

  @Override
  public long fetchDateData() {
    long time = System.currentTimeMillis();
    return time;
  }
}
