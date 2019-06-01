package es.ulpgc.montesdeoca110.cristina.zonget.administratorInbox;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.app.Query;
import es.ulpgc.montesdeoca110.cristina.zonget.app.QueryItem;

import java.util.ArrayList;
import java.util.List;

public class AdministratorInboxListAdapter
        extends RecyclerView.Adapter<AdministratorInboxListAdapter.ViewHolder> {

  private List<Query> queryList;
  private final View.OnClickListener clickListener;

  public AdministratorInboxListAdapter( View.OnClickListener clickListener) {
    this.queryList = new ArrayList<>();
    this.clickListener = clickListener;
  }

  public void setItems(List<Query> items) {
    queryList = items;
    notifyDataSetChanged();
  }

  public void addItem(Query item) {
    queryList.add(item);
  }

  public void addItems(List<Query> items) {
    queryList.addAll(items);
  }

  @Override
  public int getItemCount() {
    return queryList.size();
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.inbox_list_content, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    holder.itemView.setTag(queryList.get(position));
    holder.itemView.setOnClickListener(clickListener);

    //holder.userID.setText(queryItemList.get(position).sender);
    holder.title.setText(queryList.get(position).getTitle());
  }



  public class ViewHolder extends RecyclerView.ViewHolder {

    final TextView userID;
    final TextView title;


    public ViewHolder(View view) {
      super(view);
      userID = view.findViewById(R.id.userID);
      title = view.findViewById(R.id.title);

    }
  }
}
