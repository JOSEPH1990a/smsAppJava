package com.gsmmodem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.gsmmodem.entities.UsersEntity;
import java.util.ArrayList;

public class CustomUserListAdapter extends BaseAdapter {
    private ArrayList<UsersEntity> arrayUsers;
    private LayoutInflater layoutInflater;

    public long getItemId(int i) {
        return (long) i;
    }

    public CustomUserListAdapter(Context context, ArrayList<UsersEntity> arrayList) {
        this.arrayUsers = arrayList;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return this.arrayUsers.size();
    }

    public Object getItem(int i) {
        return this.arrayUsers.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = this.layoutInflater.inflate(R.layout.custom_users_list, (ViewGroup) null);
            viewHolder = new ViewHolder();
            viewHolder.nameView = (TextView) view.findViewById(R.id.userName);
            viewHolder.isCheckView = (ImageView) view.findViewById(R.id.isCheckedUser);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.nameView.setText(this.arrayUsers.get(i).getName());
        if (this.arrayUsers.get(i) != null && this.arrayUsers.get(i).getChecked().booleanValue()) {
            viewHolder.isCheckView.setImageResource(R.drawable.checked);
        }
        return view;
    }

    static class ViewHolder {
        ImageView isCheckView;
        TextView nameView;

        ViewHolder() {
        }
    }
}
