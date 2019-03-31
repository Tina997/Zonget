package es.ulpgc.montesdeoca110.cristina.zonget.administratorButtonsMenuList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AdministratorButtonMenuItem;
import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class AdministratorButtonsMenuListAdapter extends RecyclerView.Adapter<AdministratorButtonsMenuListAdapter.ViewHolder> {

    private List<AdministratorButtonMenuItem> itemlist;
    private final View.OnClickListener clickListener;

    public AdministratorButtonsMenuListAdapter(View.OnClickListener listener){
        itemlist = new ArrayList<>();
        this.clickListener = listener;
    }

    public void addItem(AdministratorButtonMenuItem item){
        itemlist.add(item);
        notifyDataSetChanged();
    }

    public void addItems(List<AdministratorButtonMenuItem> items){
        itemlist.addAll(items);
        notifyDataSetChanged();
    }

    public void setItems(List<AdministratorButtonMenuItem> items){
        itemlist = items;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return itemlist.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.administrator_buttons_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.itemView.setTag(itemlist.get(position));
        holder.itemView.setOnClickListener(clickListener);

        holder.text.setText(itemlist.get(position).text);
        holder.image.setImageBitmap(decodeToImage(itemlist.get(position).imagen));
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView image;
        final TextView text;

        ViewHolder(View view) {
            super(view);
            image = view.findViewById(R.id.administrator_button_image_view);
            text = view.findViewById(R.id.administrator_button_text_label);
        }
    }

    private static Bitmap decodeToImage(String imageString) {
        String base64String = imageString;
        String base64Image = base64String.split(",")[1];

        byte[] decodedString = Base64.decode(base64Image, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

        return decodedByte;
    }

}
