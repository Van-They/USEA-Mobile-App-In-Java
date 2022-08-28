package com.example.useaapp.guest.guest_adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.useaapp.R;

public class GuestCategoryAdapter extends BaseAdapter {
    Context context;
    String[] titles;
    int[] images;
    LayoutInflater inflater;

    public GuestCategoryAdapter(Context context, String[] titles, int[] images) {
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
        if (convertView == null){
            convertView = inflater.inflate(R.layout.custom_gridview_category,parent,false);
        }
        ImageView imageCategory = convertView.findViewById(R.id.item_images);
        TextView titleCategory = convertView.findViewById(R.id.item_titles);

        imageCategory.setImageResource(images[position]);
        titleCategory.setText(titles[position]);
        return convertView;
    }
}
