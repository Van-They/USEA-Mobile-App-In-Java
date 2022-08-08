package com.example.useaapp.student.student_score.year1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.useaapp.R;
import com.example.useaapp.student.student_score.ModelScore;

import java.util.ArrayList;


public class Adapter_Score_Semester extends ArrayAdapter<ModelScore> {


    public Adapter_Score_Semester(@NonNull Context context, ArrayList<ModelScore> arrayList) {
        super(context, R.layout.custom_items_score,arrayList);
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null)
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_items_score,parent,false);
        TextView Subject_score,Rank_score,Grade_score,Total_score;
        ModelScore score = getItem(position);
        Subject_score = convertView.findViewById(R.id.Student_score_subject);
        Rank_score = convertView.findViewById(R.id.Student_score_rank);
        Grade_score = convertView.findViewById(R.id.Student_score_grade);
        Total_score = convertView.findViewById(R.id.Student_score_total);

        Subject_score.setText(score.getSubject_score());
        Rank_score.setText(score.getRank_score());
        Grade_score.setText(score.getGrade_score());
        Total_score.setText(score.getTotal_score());


        return convertView;
    }
}
