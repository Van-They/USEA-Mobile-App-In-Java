package com.example.useaapp.STUDENT.Score.Detail_score_s1s2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useaapp.R;
import com.example.useaapp.STUDENT.Adapter.Adapter_score_semester;
import com.example.useaapp.STUDENT.Score.Score.ModelScore;

import java.util.ArrayList;
import java.util.List;

public class Adapter_score_detail extends RecyclerView.Adapter<Adapter_score_detail.ViewHolder> {
    List<ModelScore> data;
    public Adapter_score_detail(List<ModelScore> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public Adapter_score_detail.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_cardview_item_score_detail, parent, false);
        return new Adapter_score_detail.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_score_detail.ViewHolder holder, int position) {
        holder.Subject_student_score_detail.setText(data.get(position).getSubject_name());
        holder.Attendance_student_score_detail.setText(data.get(position).getSc_at());
        holder.Exercise_student_score_detail.setText(data.get(position).getSc_ex());
        holder.Homework_student_score_detail.setText(data.get(position).getSc_hw());
        holder.Assignment_student_score_detail.setText(data.get(position).getSc_as());
        holder.Midterm_student_score_detail.setText(data.get(position).getSc_mt());
        holder.Semester_exam_student_score_detail.setText(data.get(position).getSc_fn());
        holder.Total_student_score_detail.setText(data.get(position).getTotal_Score());
        holder.Average_student_score_detail.setText(data.get(position).getAverage_Score());
        holder.Rank_student_score_detail.setText(data.get(position).getGrade());
        holder.Grade_student_score_detail.setText(data.get(position).getGrade());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView Subject_student_score_detail, Attendance_student_score_detail, Exercise_student_score_detail,
                Homework_student_score_detail, Assignment_student_score_detail, Midterm_student_score_detail,
                Semester_exam_student_score_detail,Total_student_score_detail, Average_student_score_detail,
                Rank_student_score_detail, Grade_student_score_detail;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            Subject_student_score_detail = itemView.findViewById(R.id.Subject_student_score_detail);
            Attendance_student_score_detail = itemView.findViewById(R.id.Attendance_student_score_detail);
            Exercise_student_score_detail = itemView.findViewById(R.id.Exercise_student_score_detail);
            Homework_student_score_detail = itemView.findViewById(R.id.Homework_student_score_detail);
            Assignment_student_score_detail = itemView.findViewById(R.id.Assignment_student_score_detail);
            Midterm_student_score_detail = itemView.findViewById(R.id.Midterm_student_score_detail);
            Semester_exam_student_score_detail = itemView.findViewById(R.id.Semester_exam_student_score_detail);
            Total_student_score_detail = itemView.findViewById(R.id.Total_student_score_detail);
            Average_student_score_detail = itemView.findViewById(R.id.Average_student_score_detail);
            Rank_student_score_detail = itemView.findViewById(R.id.Rank_student_score_detail);
            Grade_student_score_detail = itemView.findViewById(R.id.Grade_student_score_detail);
        }
    }
}
