package com.example.useaapp.student.student_studyplan.year1;

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

public class Adapter_semester2 extends ArrayAdapter<Semester> {
    public Adapter_semester2(@NonNull Context context, ArrayList<Semester> Semester2) {
        super(context,R.layout.custom_item_studyplan, Semester2);
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_studyplan,parent,false);
        }
        Semester semester2 = getItem(position);
        TextView No = convertView.findViewById(R.id.student_study_plan_no);
        assert semester2 !=null;
        No.setText(semester2.getNo());
        TextView Subject = convertView.findViewById(R.id.student_study_plan_subject);
        Subject.setText(semester2.getSubject());
        TextView Hour = convertView.findViewById(R.id.student_study_plan_hour);
        Hour.setText(semester2.getHour());
        TextView Credit = convertView.findViewById(R.id.student_study_plan_credit);
        Credit.setText(semester2.getCredit());
        return convertView;
    }
}
