package com.example.useaapp.guest.guest_career;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.useaapp.R;
import com.example.useaapp.guest.guest_events.GuestEventModel;

import java.util.ArrayList;
import java.util.Date;

public class Adapter_guest_career extends ArrayAdapter<GuestCareerModel> {

    public Adapter_guest_career(@NonNull Context context, ArrayList<GuestCareerModel> guestCareerModel) {
        super(context, R.layout.custom_items_guest_career , guestCareerModel);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_items_guest_career, parent, false);
        }
        GuestCareerModel guestCareerModel = getItem(position);
        TextView Title_guest_career_item,Detail_guest_career_item, Province_guest_career_item, Month_guest_career_item, Date_guest_career_item, Year_guest_career_item;
        Title_guest_career_item = convertView.findViewById(R.id.Title_guest_career_item);
        Detail_guest_career_item = convertView.findViewById(R.id.Detail_guest_career_item);
        Province_guest_career_item = convertView.findViewById(R.id.Province_guest_career_item);
        Month_guest_career_item = convertView.findViewById(R.id.Month_guest_career_item);
        Date_guest_career_item = convertView.findViewById(R.id.Date_guest_career_item);
        Year_guest_career_item = convertView.findViewById(R.id.Year_guest_career_item);

        //get data
        Title_guest_career_item.setText(guestCareerModel.getTitle());
        Detail_guest_career_item.setText(guestCareerModel.getDetail());
        Province_guest_career_item.setText(guestCareerModel.getProvince());
        Month_guest_career_item.setText(guestCareerModel.getMonth());
        Date_guest_career_item.setText(guestCareerModel.getDate());
        Year_guest_career_item.setText(guestCareerModel.getYear());
        return  convertView;

    }
}
