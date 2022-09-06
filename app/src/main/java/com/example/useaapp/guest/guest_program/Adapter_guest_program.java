package com.example.useaapp.guest.guest_program;


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

public class Adapter_guest_program extends ArrayAdapter<ProgramModel> {
    public Adapter_guest_program(@NonNull Context context, ArrayList<ProgramModel> arrayList) {
        super(context, R.layout.custom_item_guest_program, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_guest_program, parent, false);
        }
        ProgramModel model = getItem(position);
        TextView Subject_program, Credit_program, Hour_program;

        TextView Associative_program, Bachelor_program, Master_program;

        Subject_program = convertView.findViewById(R.id.Subject_guest_program);
        Credit_program = convertView.findViewById(R.id.Credit_guest_program);
        Hour_program = convertView.findViewById(R.id.Hour_guest_program);

        Associative_program = convertView.findViewById(R.id.Associative_guest_program);
        Bachelor_program = convertView.findViewById(R.id.Bachelor_guest_program);
        Master_program = convertView.findViewById(R.id.Master_guest_program);


        Subject_program.setText(model.getSubject_program());
        Credit_program.setText(model.getCredit_program());
        Hour_program.setText(model.getHour_program());


        switch (model.getLabel_program()){
            case "Associative":
                Associative_program.setVisibility(View.VISIBLE);
                Bachelor_program.setVisibility(View.GONE);
                Master_program.setVisibility(View.GONE);
                break;
            case "Bachelor":
                Bachelor_program.setVisibility(View.VISIBLE);
                Associative_program.setVisibility(View.GONE);
                Master_program.setVisibility(View.GONE);
                break;
            case "Master":
                Bachelor_program.setVisibility(View.GONE);
                Associative_program.setVisibility(View.GONE);
                Master_program.setVisibility(View.VISIBLE);
                break;

        }


        return convertView;
    }
}
