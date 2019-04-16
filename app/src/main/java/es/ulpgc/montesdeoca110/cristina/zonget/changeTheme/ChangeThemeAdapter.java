package es.ulpgc.montesdeoca110.cristina.zonget.changeTheme;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.app.ChangeThemeItem;

public class ChangeThemeAdapter extends RecyclerView.Adapter<ChangeThemeAdapter.ViewHolder> {

    private List<ChangeThemeItem> itemList;
    private final View.OnClickListener clickListener;

    public ChangeThemeAdapter(View.OnClickListener listener){
        this.itemList = new ArrayList<>();
        this.clickListener = listener;
    }

    public void addItem(ChangeThemeItem item){
        this.itemList.add(item);
        notifyDataSetChanged();
    }

    public void addItems(List<ChangeThemeItem> items){
        this.itemList.addAll(items);
        notifyDataSetChanged();
    }

    public void setItems(List<ChangeThemeItem> items){
        this.itemList = items;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    @Override
    public ChangeThemeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.change_theme_list_content, parent, false);
        return new ChangeThemeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ChangeThemeAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(itemList.get(position));
        holder.itemView.setOnClickListener(clickListener);

        holder.cardView.setCardBackgroundColor(Color.parseColor(itemList.get(position).firstColor));
        holder.image.setColorFilter(Color.parseColor(itemList.get(position).secondColor));
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final CardView cardView;
        final ImageView image;

        ViewHolder(View view) {
            super(view);
            image = view.findViewById(R.id.change_theme_image_view);
            cardView = view.findViewById(R.id.change_theme_card_view);
        }
    }

}
