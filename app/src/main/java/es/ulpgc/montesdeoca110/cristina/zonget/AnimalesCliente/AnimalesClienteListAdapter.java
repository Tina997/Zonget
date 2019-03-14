package es.ulpgc.montesdeoca110.cristina.zonget.AnimalesCliente;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.App.AnimalClientesItem;
import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class AnimalesClienteListAdapter extends ArrayAdapter<AnimalClientesItem> {

    private final List<AnimalClientesItem> itemList;
    private final View.OnClickListener clickListener;

    public AnimalesClienteListAdapter(Context context, List<AnimalClientesItem> itemList, View.OnClickListener clickListener) {

        super(context,0,itemList);

        this.itemList = itemList;
        this.clickListener = clickListener;
    }
    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public AnimalClientesItem getItem(int position) {
        return itemList.get(position);
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
                    .inflate(R.layout.animales_list_content, parent, false);
        }

        itemView.setTag(itemList.get(position));
        itemView.setOnClickListener(clickListener);

        final TextView contentView = itemView.findViewById(R.id.content);
        contentView.setText(itemList.get(position).nombre);

        return itemView;
    }

}
