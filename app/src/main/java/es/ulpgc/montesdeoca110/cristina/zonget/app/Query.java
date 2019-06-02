package es.ulpgc.montesdeoca110.cristina.zonget.app;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class Query extends ExpandableGroup<QueryData> {

  public Query(String title, List<QueryData> items) {
    super(title, items);
  }
}
