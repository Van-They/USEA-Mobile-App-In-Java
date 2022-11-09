package com.example.useaapp.STUDENT.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useaapp.R;
import com.example.useaapp.STUDENT.Score.Score.ModelScore;

import java.util.List;


public class Adapter_score_semester extends RecyclerView.Adapter<Adapter_score_semester.ViewHolder> {

    List<ModelScore> data;

    public Adapter_score_semester(List<ModelScore> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public Adapter_score_semester.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_items_score, parent, false);
        return new Adapter_score_semester.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_score_semester.ViewHolder holder, int position) {
        holder.Student_score_subject.setText(data.get(position).getSubject_name());
        holder.Student_score_rank.setText(data.get(position).getAverage_Score());
        holder.Student_score_grade.setText(data.get(position).getGrade());
        holder.Student_score_total.setText(data.get(position).getTotal_Score());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView Student_score_subject, Student_score_rank, Student_score_grade, Student_score_total;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Student_score_subject = itemView.findViewById(R.id.Student_score_subject);
            Student_score_rank = itemView.findViewById(R.id.Student_score_rank);
            Student_score_grade = itemView.findViewById(R.id.Student_score_grade);
            Student_score_total = itemView.findViewById(R.id.Student_score_total);
        }
    }
}
