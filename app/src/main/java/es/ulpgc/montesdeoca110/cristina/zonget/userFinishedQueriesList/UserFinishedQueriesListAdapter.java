package es.ulpgc.montesdeoca110.cristina.zonget.userFinishedQueriesList;

import android.content.Context;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.Query;


public class UserFinishedQueriesListAdapter extends CustomExpandableRecyclerViewAdapter {

    public UserFinishedQueriesListAdapter(Context context, List<? extends ExpandableGroup> groups) {
        super(context, groups);
    }

    public void setItems(List<Query> groups) {
        getGroups().clear();
        ((List<Query>)getGroups()).addAll(groups);
        notifyGroupDataChanged();
        notifyDataSetChanged();
    }
}
