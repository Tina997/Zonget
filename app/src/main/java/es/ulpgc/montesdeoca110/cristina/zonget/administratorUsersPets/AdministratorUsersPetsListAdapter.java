package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPets;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserPetItem;

public class AdministratorUsersPetsListAdapter extends RecyclerView.Adapter<AdministratorUsersPetsListAdapter.ViewHolder> {
    private List<UserPetItem> itemList;
    private final View.OnClickListener clickListener;

    public AdministratorUsersPetsListAdapter(View.OnClickListener clickListener) {

        this.itemList = new ArrayList();
        this.clickListener = clickListener;
    }
    public void setItems(List<UserPetItem> items) {
        itemList = items;
        notifyDataSetChanged();
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pets_list_content, parent, false);
        return new ViewHolder(view);
    }
    /*@Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public UserPetItem getItem(int position) {
        return itemList.get(position);
    }*/

    /*@Override
    public AdministratorUsersPetsListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }*/

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemView.setTag(itemList.get(position));
        holder.itemView.setOnClickListener(clickListener);

        holder.name.setText(itemList.get(position).getName());
        holder.breed.setText(itemList.get(position).getBreed());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        final TextView name;
        final TextView breed;


        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.content);
            breed = view.findViewById(R.id.content2);

        }
    /*@Override
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
    }*/

    }
}
