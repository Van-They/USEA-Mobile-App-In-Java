package com.example.useaapp.student.student_studyPlan.year1;

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

public class Adapter_Studyplan_Semester extends ArrayAdapter<SemesterStudyPlan> {
    public Adapter_Studyplan_Semester(@NonNull Context context, ArrayList<SemesterStudyPlan> Semester1) {
        super(context, R.layout.custom_items_studyplan, Semester1);
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_items_studyplan, parent, false);
        }
        SemesterStudyPlan semester1 = getItem(position);
        TextView No = convertView.findViewById(R.id.student_study_plan_no);
        No.setText(semester1.getNo());
        TextView Subject = convertView.findViewById(R.id.student_study_plan_subject);
        TextView Hour = convertView.findViewById(R.id.student_study_plan_hour);
        TextView Credit = convertView.findViewById(R.id.student_study_plan_credit);
        Subject.setText(semester1.getSubject());
        Hour.setText(semester1.getHour());
        Credit.setText(semester1.getCredit());

        return convertView;
    }
}
