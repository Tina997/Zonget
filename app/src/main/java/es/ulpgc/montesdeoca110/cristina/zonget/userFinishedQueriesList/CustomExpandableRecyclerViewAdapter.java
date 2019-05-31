package es.ulpgc.montesdeoca110.cristina.zonget.userFinishedQueriesList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.app.QueryData;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

public abstract class CustomExpandableRecyclerViewAdapter extends ExpandableRecyclerViewAdapter<CustomExpandableRecyclerViewAdapter.QueryViewHolder, CustomExpandableRecyclerViewAdapter.QueryDataViewHolder> {

    private Context context;

    public CustomExpandableRecyclerViewAdapter(Context context, List<? extends ExpandableGroup> groups) {
        super(groups);
        this.context = context;
    }

    @Override
    public QueryViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_finished_queries_list, parent, false);
        return new QueryViewHolder(view);
    }

    @Override
    public QueryDataViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_finished_queries_list_content, parent, false);
        return new QueryDataViewHolder(view);
    }

    @Override
    public void onBindGroupViewHolder(CustomExpandableRecyclerViewAdapter.QueryViewHolder holder, int flatPosition, ExpandableGroup group) {
        holder.setQueryTitle(group);
    }

    @Override
    public void onBindChildViewHolder(QueryDataViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final QueryData query = (QueryData) group.getItems().get(childIndex);
        holder.content.setText(query.content);
        holder.answer.setText(query.answer);
    }

    public void notifyGroupDataChanged() {
        expandableList.expandedGroupIndexes = new boolean[getGroups().size()];
        for (int i = 0; i < getGroups().size(); i++) {
            expandableList.expandedGroupIndexes[i] = false;
        }
    }

    class QueryViewHolder extends GroupViewHolder {

        private TextView queryTitle;
        private ImageView arrow;

        public QueryViewHolder(View itemView) {
            super(itemView);
            this.queryTitle = itemView.findViewById(R.id.user_finished_queries_list_title);
            this.arrow = itemView.findViewById(R.id.user_finished_queries_list_arrow);
        }

        public void setQueryTitle(ExpandableGroup group) {
            this.queryTitle.setText(group.getTitle());
        }

        @Override
        public void expand() {
            animateExpand();
        }

        @Override
        public void collapse() {
            animateCollapse();
        }

        private void animateExpand() {
            RotateAnimation rotate = new RotateAnimation(360, 180, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
            rotate.setDuration(300);
            rotate.setFillAfter(true);
            arrow.setAnimation(rotate);
        }

        private void animateCollapse() {
            RotateAnimation rotate = new RotateAnimation(180, 360, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
            rotate.setDuration(300);
            rotate.setFillAfter(true);
            arrow.setAnimation(rotate);

        }
    }

    class QueryDataViewHolder extends ChildViewHolder {

        private TextView content;
        private TextView answer;

        public QueryDataViewHolder(View itemView) {
            super(itemView);
            this.content = itemView.findViewById(R.id.user_finished_queries_list_content);
            this.answer = itemView.findViewById(R.id.user_finished_queries_list_answer);
        }

        public void setData(QueryData queryData) {
            content.setText(queryData.content);
            answer.setText(queryData.answer);
        }
    }
}

