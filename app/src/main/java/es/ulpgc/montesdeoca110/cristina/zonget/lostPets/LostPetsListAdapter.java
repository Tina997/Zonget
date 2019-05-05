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
import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.app.LostPetItem;
import java.util.ArrayList;
import java.util.List;

public class LostPetsListAdapter extends RecyclerView.Adapter<LostPetsListAdapter.ViewHolder> {

  private List<LostPetItem> itemList;
  private final View.OnClickListener clickListener;


  public LostPetsListAdapter(View.OnClickListener listener) {

    itemList = new ArrayList();
    clickListener = listener;
  }


  public void addItem(LostPetItem item) {
    itemList.add(item);
    notifyDataSetChanged();
  }

  public void addItems(List<LostPetItem> items) {
    itemList.addAll(items);
    notifyDataSetChanged();
  }

  public void setItems(List<LostPetItem> items) {
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

    holder.contentView.setText(itemList.get(position).name);
    loadImageFromURL(holder.imageView, itemList.get(position).picture);

  }

  @Override
  public int getItemCount() {
    return itemList.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    final TextView contentView;
    final ImageView imageView;

    ViewHolder(View view) {
      super(view);
      contentView = view.findViewById(R.id.lostName);
      imageView = view.findViewById(R.id.lostPetImage);
    }

  }

  private void loadImageFromURL(ImageView imageView, String imageUrl) {
    RequestManager reqManager = Glide.with(imageView.getContext());
    RequestBuilder reqBuilder = reqManager.load(imageUrl);
    RequestOptions reqOptions = new RequestOptions();
    reqOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
    reqBuilder.apply(reqOptions);
    reqBuilder.into(imageView);
  }

}
