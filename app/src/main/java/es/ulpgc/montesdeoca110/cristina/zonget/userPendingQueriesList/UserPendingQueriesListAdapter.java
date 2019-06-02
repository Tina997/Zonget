package es.ulpgc.montesdeoca110.cristina.zonget.userPendingQueriesList;

import android.content.Context;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.Query;

@SuppressWarnings("ALL")
class UserPendingQueriesListAdapter extends CustomPendingQueriesExpandableRecyclerViewAdapter {

  public UserPendingQueriesListAdapter(Context context, List<? extends ExpandableGroup> groups) {
    super(context, groups);
  }

  public void setItems(List<Query> groups) {
    getGroups().clear();
    ((List<Query>) getGroups()).addAll(groups);
    notifyGroupDataChanged();
    notifyDataSetChanged();
  }
}
