package com.example.useaapp.GUEST.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.useaapp.R;

import java.util.ArrayList;

public class Adapter_guest_program_detail extends ArrayAdapter<String> {
    ArrayList<String> arr;
    public Adapter_guest_program_detail(@NonNull Context context, ArrayList<String> arrayList) {
        super(context, R.layout.custom_item_guest_program, arrayList);
        arr = arrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView Guest_program_major;
        if (convertView == null)
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_guest_program, parent, false);

        Guest_program_major = convertView.findViewById(R.id.Guest_program_major);

        Guest_program_major.setText(arr.get(position));


        return convertView;
    }
}
