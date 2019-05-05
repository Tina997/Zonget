package es.ulpgc.montesdeoca110.cristina.zonget.administratorInbox;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.app.QueryItem;

import java.util.ArrayList;
import java.util.List;

public class AdministratorInboxListAdapter
        extends RecyclerView.Adapter<AdministratorInboxListAdapter.ViewHolder> {

  private List<QueryItem> queryItemList;
  private final View.OnClickListener clickListener;

  public AdministratorInboxListAdapter(View.OnClickListener clickListener) {
    queryItemList = new ArrayList<>();
    this.clickListener = clickListener;
  }

  public void setItems(List<QueryItem> items) {
    queryItemList = items;
    notifyDataSetChanged();
  }

  public void addItem(QueryItem item) {
    queryItemList.add(item);
  }

  public void addItems(List<QueryItem> items) {
    queryItemList.addAll(items);
  }

  @Override
  public int getItemCount() {
    return queryItemList.size();
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.inbox_list_content, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    holder.itemView.setTag(queryItemList.get(position));
    holder.itemView.setOnClickListener(clickListener);

    holder.userID.setText(queryItemList.get(position).sender);
    holder.title.setText(queryItemList.get(position).title);
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
