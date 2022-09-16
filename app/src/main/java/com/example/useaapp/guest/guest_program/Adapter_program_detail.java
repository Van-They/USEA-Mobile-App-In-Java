package com.example.useaapp.guest.guest_program;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.useaapp.R;
import com.example.useaapp.student.student_studyPlan.StudentStudyPlan;

import java.util.ArrayList;

public class Adapter_program_detail extends BaseAdapter {
    ArrayList<String> title;
    Context context;
    LayoutInflater inflater;
    public Adapter_program_detail(Context context ,ArrayList<String> title) {
        this.title = title;
        this.context = context;
    }

    @Override
    public int getCount() {
        return title.size();
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
        if (inflater == null)
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_item_guest_program,parent,false);
        TextView Major = convertView.findViewById(R.id.Guest_program_major);
        Major.setText(title.get(position));

        Major.setOnClickListener(v->{
            Intent intent = new Intent(v.getContext(), StudentStudyPlan.class);
            v.getContext().startActivity(intent);
        });
        return convertView;
    }
}
