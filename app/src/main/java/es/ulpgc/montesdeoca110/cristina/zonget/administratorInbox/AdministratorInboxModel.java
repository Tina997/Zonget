package es.ulpgc.montesdeoca110.cristina.zonget.administratorInbox;

import es.ulpgc.montesdeoca110.cristina.zonget.app.QueryItem;
import java.util.ArrayList;
import java.util.List;

public class AdministratorInboxModel implements AdministratorInboxContract.Model {

  public static String TAG = AdministratorInboxModel.class.getSimpleName();

  private final List<QueryItem> queryItems = new ArrayList<>();
  private final int Count = 5;

  public AdministratorInboxModel() {
    for (int i = 0; i <= Count; i++) {
      addQuery(createQuery(i));
    }
  }

  @Override
  public List<QueryItem> fetchData() {
    return queryItems;
  }

  private void addQuery(QueryItem item) {
    queryItems.add(item);
  }

  private QueryItem createQuery(int position) {
    String sender = "Usuario " + position;
    String title = "Asunto " + position;
    //return new QueryItem(sender, data,,in position);
    return null;
  }
}
