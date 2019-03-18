package es.ulpgc.montesdeoca110.cristina.zonget.agendaAdmin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.App.CitaItem;
import es.ulpgc.montesdeoca110.cristina.zonget.R;


public class AgendaAdminListAdapter extends ArrayAdapter<CitaItem> {

    private final List<CitaItem> citaItemList;
    private final View.OnClickListener clickListener;

    public AgendaAdminListAdapter(Context context, List<CitaItem> citaItemList,
                                  View.OnClickListener clickListener){
        super(context, 0, citaItemList);
        this.citaItemList = citaItemList;
        this.clickListener = clickListener;
    }

    @Override
    public int getCount() {
        return citaItemList.size();
    }

    @Override
    public CitaItem getItem(int position) {
        return citaItemList.get(position);
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
                    .inflate(R.layout.lista_citas_content, parent, false);
        }

        itemView.setTag(citaItemList.get(position));
        itemView.setOnClickListener(clickListener);

        final TextView contentView = itemView.findViewById(R.id.content);
        contentView.setText(citaItemList.get(position).titulo);

        return itemView;
    }
}