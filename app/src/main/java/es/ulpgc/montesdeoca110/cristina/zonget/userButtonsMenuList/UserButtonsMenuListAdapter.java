package es.ulpgc.montesdeoca110.cristina.zonget.userButtonsMenuList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserButtonMenuItem;

public class UserButtonsMenuListAdapter extends ArrayAdapter<UserButtonMenuItem> {

    private final List<UserButtonMenuItem> user_buttons_list;

    private final View.OnClickListener clickListener;

    public UserButtonsMenuListAdapter(Context context, List<UserButtonMenuItem> items, View.OnClickListener listener) {

        super(context, 0, items);

        user_buttons_list = items;
        clickListener = listener;
    }

    @Override
    public int getCount() {
        return user_buttons_list.size();
    }

    @Override
    public UserButtonMenuItem getItem(int position) {
        return user_buttons_list.get(position);
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
                    .inflate(R.layout.administrator_buttons_list_content, parent, false);
        }

        itemView.setTag(user_buttons_list.get(position));
        itemView.setOnClickListener(clickListener);

        final TextView contentView = itemView.findViewById(R.id.administrator_button_text_label);
        final ImageView imageView = itemView.findViewById(R.id.administrator_button_image_view);

        contentView.setText(user_buttons_list.get(position).text);

        return itemView;
    }
}
