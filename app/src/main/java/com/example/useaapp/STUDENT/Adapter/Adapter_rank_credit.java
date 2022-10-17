package com.example.useaapp.STUDENT.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.useaapp.R;

public class Adapter_rank_credit extends BaseAdapter {
    Context context;
    String[] rank_credit, label_rank_credit;
    int[] image_rank_credit;
    LayoutInflater inflater;

    public Adapter_rank_credit(Context context, String[] rank_credit, String[] label_rank_credit, int[] image_rank_credit) {
        this.context = context;
        this.rank_credit = rank_credit;
        this.label_rank_credit = label_rank_credit;
        this.image_rank_credit = image_rank_credit;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        // Return true for clickable, false for not
        return false;
    }

    @Override
    public int getCount() {
        return rank_credit.length;
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
            convertView = inflater.inflate(R.layout.custom_cardview_rank_credit, null);
        }
        ImageView Image_rank_credit = convertView.findViewById(R.id.image_card_rank_credit_view);
        TextView Rank_credit = convertView.findViewById(R.id.txt_card_rank_credit_view);
        TextView Label_rank_credit = convertView.findViewById(R.id.label_card_rank_credit_view);

        Image_rank_credit.setImageResource(image_rank_credit[position]);
        Rank_credit.setText(rank_credit[position]);
        Label_rank_credit.setText(label_rank_credit[position]);
        return convertView;
    }
}
