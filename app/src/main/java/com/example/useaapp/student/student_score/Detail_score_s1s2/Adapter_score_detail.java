package com.example.useaapp.student.student_score.Detail_score_s1s2;

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

public class Adapter_score_detail extends ArrayAdapter<ModelDetail> {
    public Adapter_score_detail(@NonNull Context context, ArrayList<ModelDetail> list) {
        super(context, R.layout.custom_cardview_item_score_detail, list);
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView Attendance_student_score_detail,
                Subject_student_score_detail,
                Exercise_student_score_detail,
                Homework_student_score_detail,
                Midterm_student_score_detail,
                Assignment_student_score_detail,
                Semester_exam_student_score_detail;//student score list detail
        TextView Total_student_score_detail,
                Average_student_score_detail,
                Rank_student_score_detail,
                Grade_student_score_detail;//total Score Detail
        ModelDetail modelDetail = getItem(position);
        if (convertView == null)
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_cardview_item_score_detail, parent, false);
        //student score list detail
        Subject_student_score_detail = convertView.findViewById(R.id.Subject_student_score_detail);
        Attendance_student_score_detail = convertView.findViewById(R.id.Attendance_student_score_detail);
        Exercise_student_score_detail = convertView.findViewById(R.id.Exercise_student_score_detail);
        Homework_student_score_detail = convertView.findViewById(R.id.Homework_student_score_detail);
        Midterm_student_score_detail = convertView.findViewById(R.id.Midterm_student_score_detail);
        Semester_exam_student_score_detail = convertView.findViewById(R.id.Semester_exam_student_score_detail);
        Assignment_student_score_detail=convertView.findViewById(R.id.Assignment_student_score_detail);

        //total Score Detail
        Total_student_score_detail = convertView.findViewById(R.id.Total_student_score_detail);
        Average_student_score_detail = convertView.findViewById(R.id.Average_student_score_detail);
        Rank_student_score_detail = convertView.findViewById(R.id.Rank_student_score_detail);
        Grade_student_score_detail = convertView.findViewById(R.id.Grade_student_score_detail);

        //student score list detail
        Subject_student_score_detail.setText(modelDetail.getTitle());
        Attendance_student_score_detail.setText(modelDetail.getAttendance());
        Exercise_student_score_detail.setText(modelDetail.getExercise());
        Homework_student_score_detail.setText(modelDetail.getHomework());
        Midterm_student_score_detail.setText(modelDetail.getMidterm());
        Semester_exam_student_score_detail.setText(modelDetail.getSemester_exam());
        Assignment_student_score_detail.setText(modelDetail.getAssignment());

        //total Score Detail
        Total_student_score_detail.setText(modelDetail.getTotal());
        Average_student_score_detail.setText(modelDetail.getAverage());
        Rank_student_score_detail.setText(modelDetail.getRank());
        Grade_student_score_detail.setText(modelDetail.getGrade());


        return convertView;
    }
}
