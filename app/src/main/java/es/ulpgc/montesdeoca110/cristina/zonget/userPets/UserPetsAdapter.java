package es.ulpgc.montesdeoca110.cristina.zonget.userPets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserPetItem;

public class UserPetsAdapter extends ArrayAdapter<UserPetItem> {
    private List<UserPetItem> itemList;
    private final View.OnClickListener clickListener;

    public UserPetsAdapter(Context context, List<UserPetItem> itemList, View.OnClickListener clickListener) {

        super(context,0,itemList);

        this.itemList = itemList;
        this.clickListener = clickListener;
    }
    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public UserPetItem getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;

        if (itemView == null) {
            itemView = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.pets_list_content, parent, false);
        }

        itemView.setTag(itemList.get(position));
        itemView.setOnClickListener(clickListener);

        final TextView contentView = itemView.findViewById(R.id.content);
        contentView.setText(itemList.get(position).getName());
        contentView.setTextSize(25);
        final TextView contentView2 = itemView.findViewById(R.id.content2);
        contentView2.setText(itemList.get(position).getSpecies());
        contentView2.setTextSize(20);


        return itemView;
    }
    public void setItems(List<UserPetItem> items){
        itemList = items;
        notifyDataSetChanged();
    }

}
