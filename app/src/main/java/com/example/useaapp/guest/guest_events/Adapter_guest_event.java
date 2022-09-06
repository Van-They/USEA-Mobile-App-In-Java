package com.example.useaapp.guest.guest_events;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.useaapp.R;

import java.util.ArrayList;

public class Adapter_guest_event extends ArrayAdapter<GuestEventModel> {
    public Adapter_guest_event(@NonNull Context context, ArrayList<GuestEventModel> guestEventModels) {
        super(context, R.layout.custom_items_guest_event, guestEventModels);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_items_guest_event, parent, false);
        }
        GuestEventModel guestEventModel = getItem(position);

        TextView Title_guest_event_item, Detail_guest_event_item, Day_guest_event_item, Month_guest_event_item, Date_guest_event_item, Year_guest_event_item, Time_guest_event_item;
        ImageView eventImg;
        Title_guest_event_item = convertView.findViewById(R.id.Title_guest_event_item);
        Detail_guest_event_item = convertView.findViewById(R.id.Detail_guest_event_item);
        Day_guest_event_item = convertView.findViewById(R.id.Day_guest_event_item);
        Month_guest_event_item = convertView.findViewById(R.id.Month_guest_event_item);
        Date_guest_event_item = convertView.findViewById(R.id.Date_guest_event_item);
        Year_guest_event_item = convertView.findViewById(R.id.Year_guest_event_item);
        Time_guest_event_item = convertView.findViewById(R.id.Time_guest_event_item);
        eventImg = convertView.findViewById(R.id.eventImg);

        //get data
        Title_guest_event_item.setText(guestEventModel.getTitle());
        Detail_guest_event_item.setText(guestEventModel.getDetail());
        Day_guest_event_item.setText(guestEventModel.getDay());
        Month_guest_event_item.setText(guestEventModel.getMonth());
        Date_guest_event_item.setText(guestEventModel.getDate());
        Year_guest_event_item.setText(guestEventModel.getYear());
        Time_guest_event_item.setText(guestEventModel.getTime());
        eventImg.setImageResource(guestEventModel.eventIMG);

        return convertView;

    }
}
