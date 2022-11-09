package com.example.useaapp.STUDENT.StudyPlan.year1;

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
import java.util.List;

public class Adapter_Studyplan_Semester extends ArrayAdapter<Response_model_SemesterStudyPlan> {

    public Adapter_Studyplan_Semester(@NonNull Context context, List<Response_model_SemesterStudyPlan> Semester) {
        super(context, R.layout.custom_items_studyplan, Semester);
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
        Response_model_SemesterStudyPlan semester = getItem(position);
        TextView Subject = convertView.findViewById(R.id.student_study_plan_subject);
        TextView Hour = convertView.findViewById(R.id.student_study_plan_hour);
        TextView Credit = convertView.findViewById(R.id.student_study_plan_credit);
        Subject.setText(semester.getSubject_name());
        Hour.setText(semester.getHours());
        Credit.setText(semester.getCredits());

        return convertView;
    }
}