package es.ulpgc.montesdeoca110.cristina.zonget.app;

public class InboxItem {

  public final String userName;
  public final QueryItem queryItem;

  public InboxItem(String userName, QueryItem queryItem) {
    this.userName = userName;
    this.queryItem = queryItem;
  }
}
