package com.tomclaw.appsend;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Igor on 06.05.2015.
 */
public class MenuAdapter extends BaseAdapter {

    private Context context;
    private String[] titles;
    private TypedArray icons;

    public MenuAdapter(Context context, int menuTitles, int menuIcons) {
        this.context = context;
        titles = context.getResources().getStringArray(menuTitles);
        icons = context.getResources().obtainTypedArray(menuIcons);
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public Object getItem(int position) {
        return titles[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.menu_item, parent, false);
        }
        ImageView icon = (ImageView) convertView.findViewById(R.id.icon);
        TextView title = (TextView) convertView.findViewById(R.id.title);
        title.setText(titles[position]);
        icon.setImageDrawable(icons.getDrawable(position));
        return convertView;
    }
}