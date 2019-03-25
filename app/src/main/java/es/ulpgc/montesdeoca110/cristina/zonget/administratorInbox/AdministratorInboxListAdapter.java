package es.ulpgc.montesdeoca110.cristina.zonget.administratorInbox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.app.QueryItem;

public class AdministratorInboxListAdapter extends ArrayAdapter<QueryItem> {

    private final List<QueryItem> queryItemList;
    private final View.OnClickListener clickListener;

    public AdministratorInboxListAdapter(Context context, List<QueryItem> queryItemList,
                                         View.OnClickListener clickListener){
        super(context, 0, queryItemList);
        this.queryItemList =queryItemList;
        this.clickListener = clickListener;
    }

    @Override
    public int getCount() {
        return queryItemList.size();
    }

    @Override
    public QueryItem getItem(int position) {
        return queryItemList.get(position);
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
                    .inflate(R.layout.inbox_list_content, parent, false);
        }

        itemView.setTag(queryItemList.get(position));
        itemView.setOnClickListener(clickListener);

        final TextView sender = itemView.findViewById(R.id.userID);
        sender.setText(queryItemList.get(position).sender);

        final TextView title = itemView.findViewById(R.id.title);
        title.setText(queryItemList.get(position).title);

        return itemView;
    }
}
