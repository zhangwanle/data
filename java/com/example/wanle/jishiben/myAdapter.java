package com.example.wanle.jishiben;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class myAdapter extends BaseAdapter {

    Context mContext;
    int layoutId;
    List<UserBean> list;


    public myAdapter(Context mContext, int layoutId, List<UserBean> list) {
        this.mContext = mContext;
        this.layoutId = layoutId;
        this.list = list;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(mContext).inflate(layoutId,parent,false);

        TextView title = convertView.findViewById(R.id.tv_title);
        TextView content = convertView.findViewById(R.id.tv_content);

        UserBean m = list.get(position);
        title.setText(""+m.getTitle());
        content.setText(""+m.getContent());

        return convertView;
    }
}
