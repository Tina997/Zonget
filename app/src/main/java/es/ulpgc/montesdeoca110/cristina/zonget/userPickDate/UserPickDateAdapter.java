package es.ulpgc.montesdeoca110.cristina.zonget.userPickDate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.app.EventItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.HourItem;

public class UserPickDateAdapter extends ArrayAdapter<HourItem> {

    private final List<HourItem> hoursItemList;
    private final View.OnClickListener clickListener;

    public UserPickDateAdapter(Context context, List<HourItem> hoursItemList,
                                          View.OnClickListener clickListener){
        super(context, 0, hoursItemList);
        this.hoursItemList = hoursItemList;
        this.clickListener = clickListener;
    }

    @Override
    public int getCount() {
        return hoursItemList.size();
    }

    @Override
    public HourItem getItem(int position) {
        return hoursItemList.get(position);
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
                    .inflate(R.layout.free_hours_content, parent, false);
        }

        itemView.setTag(hoursItemList.get(position));
        itemView.setOnClickListener(clickListener);

        final TextView contentView = itemView.findViewById(R.id.content);
        contentView.setText(hoursItemList.get(position).hour);

        return itemView;
    }
}
