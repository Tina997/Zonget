package es.ulpgc.montesdeoca110.cristina.zonget.userAgenda;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.app.EventItem;
import java.util.List;

class UserAgendaListAdapter extends ArrayAdapter<EventItem> {

  private final List<EventItem> eventItemList;
  private final View.OnClickListener clickListener;

  public UserAgendaListAdapter(Context context, List<EventItem> eventItemList,
                               View.OnClickListener clickListener) {
    super(context, 0, eventItemList);
    this.eventItemList = eventItemList;
    this.clickListener = clickListener;
  }

  @Override
  public int getCount() {
    return eventItemList.size();
  }

  @Override
  public EventItem getItem(int position) {
    return eventItemList.get(position);
  }

  @Override
  public long getItemId(int position) {
    return getItem(position).id;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View itemView = convertView;

    if (itemView == null) {
      itemView = LayoutInflater
              .from(parent.getContext())
              .inflate(R.layout.event_list_content, parent, false);
    }

    itemView.setTag(eventItemList.get(position));
    itemView.setOnClickListener(clickListener);

    final TextView contentView = itemView.findViewById(R.id.content);
    contentView.setText(eventItemList.get(position).title);

    return itemView;
  }
}