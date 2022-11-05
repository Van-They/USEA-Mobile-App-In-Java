package com.example.useaapp.STUDENT.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.useaapp.R;

public class Adapter_category extends BaseAdapter {

    Context context;
    String[] titles;
    int[] images;
    LayoutInflater inflater;

    public Adapter_category(Context context, String[] titles, int[] images) {
        this.context = context;
        this.titles = titles;
        this.images = images;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.custom_gridview_category, parent, false);
        }
        ImageView icon_category = convertView.findViewById(R.id.item_images);
        TextView textView = convertView.findViewById(R.id.item_titles);

        icon_category.setImageResource(images[position]);
        textView.setText(titles[position]);
        return convertView;
    }
}
