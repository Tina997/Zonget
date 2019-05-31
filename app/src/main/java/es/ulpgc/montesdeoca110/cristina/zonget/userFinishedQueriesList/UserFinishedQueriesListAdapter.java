package es.ulpgc.montesdeoca110.cristina.zonget.userFinishedQueriesList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.app.FinishedQueryItem;

public class UserFinishedQueriesListAdapter extends RecyclerView.Adapter<UserFinishedQueriesListAdapter.ViewHolder> {

    private Context context;
    private List<FinishedQueryItem> itemList;

    private static int currentPosition = 0;

    public UserFinishedQueriesListAdapter(Context context, List<FinishedQueryItem> queriesList) {
        this.context = context;
        this.itemList = queriesList;
    }

    public void addItem(FinishedQueryItem item) {
        this.itemList.add(item);
        notifyDataSetChanged();
    }

    public void addItems(List<FinishedQueryItem> items) {
        this.itemList.addAll(items);
        notifyDataSetChanged();
    }

    public void setItems(List<FinishedQueryItem> queries) {
        this.itemList = queries;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_finished_queries_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.itemView.setTag(itemList.get(position));

        holder.title.setText(itemList.get(position).title);
        holder.content.setText(itemList.get(position).content);
        holder.answer.setText(itemList.get(position).answer);

        holder.linearLayout.setVisibility(View.GONE);

        if (currentPosition == position) {
            //creating an animation
            Animation slideDown = AnimationUtils.loadAnimation(context, R.anim.slide_down);

            //toggling visibility
            holder.linearLayout.setVisibility(View.VISIBLE);

            //adding sliding effect
            holder.linearLayout.startAnimation(slideDown);
        }

        holder.slideDownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getting the position of the item to expand it
                currentPosition = position;

                //reloding the list
                notifyDataSetChanged();
            }
        });
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        LinearLayout linearLayout;
        ImageButton slideDownButton;
        final TextView title;
        final TextView content;
        final TextView answer;

        ViewHolder(View view) {
            super(view);

            linearLayout = view.findViewById(R.id.user_finished_queries_list_linearLayout);
            slideDownButton = view.findViewById(R.id.user_finished_queries_list_button);

            title = view.findViewById(R.id.user_finished_queries_list_title);
            content = view.findViewById(R.id.user_finished_queries_list_content);
            answer =  view.findViewById(R.id.user_finished_queries_list_answer);
        }

    }
}
