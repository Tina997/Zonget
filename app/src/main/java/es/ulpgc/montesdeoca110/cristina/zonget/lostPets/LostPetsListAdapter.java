package es.ulpgc.montesdeoca110.cristina.zonget.lostPets;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.app.LostPetItem;

public class LostPetsListAdapter extends RecyclerView.Adapter<LostPetsListAdapter.ViewHolder> {

    private List<LostPetItem> itemList;
    private final View.OnClickListener clickListener;


    public LostPetsListAdapter(View.OnClickListener listener) {

        itemList = new ArrayList();
        clickListener = listener;
    }


    public void addItem(LostPetItem item){
        itemList.add(item);
        notifyDataSetChanged();
    }

    public void addItems(List<LostPetItem> items){
        itemList.addAll(items);
        notifyDataSetChanged();
    }

    public void setItems(List<LostPetItem> items){
        itemList = items;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lost_pets_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.itemView.setTag(itemList.get(position));
        holder.itemView.setOnClickListener(clickListener);

        holder.contentView.setText(itemList.get(position).date);
        holder.contentViewB.setText(itemList.get(position).breed);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView contentView;
        final TextView contentViewB;
        final ImageView imageView;

        ViewHolder(View view) {
            super(view);
            contentView = view.findViewById(R.id.lostDate);
            contentViewB = view.findViewById(R.id.lostPetBreed);
            imageView = view.findViewById(R.id.lostPetImage);
            loadImageFromURL((ImageView) view.findViewById(R.id.lostPetImage),"https://www.freejpg.com.ar/image-900/65/65ab/F100011060-gato.jpg");
        }
    }
    private void loadImageFromURL(ImageView imageView, String imageUrl){
        RequestManager reqManager = Glide.with(imageView.getContext());
        RequestBuilder reqBuilder = reqManager.load(imageUrl);
        RequestOptions reqOptions = new RequestOptions();
        reqOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
        reqBuilder.apply(reqOptions);
        reqBuilder.into(imageView);
    }
}
