package com.example.useaapp.STUDENT.StudyPlan.year1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useaapp.R;

import java.util.List;

public class Adapter_student_Studyplan_Semester_Thesis extends RecyclerView.Adapter<Adapter_student_Studyplan_Semester_Thesis.ViewHolder> {
    List<Response_model_SemesterStudyPlan_Thesis> data;
    public Adapter_student_Studyplan_Semester_Thesis(List<Response_model_SemesterStudyPlan_Thesis> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_items_studyplan_thesis, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.student_study_plan_subject.setText(data.get(position).getSubject_name());
        holder.student_study_plan_credit.setText(data.get(position).getCredits());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView student_study_plan_subject, student_study_plan_credit;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            student_study_plan_subject = itemView.findViewById(R.id.student_study_plan_subject_th);
            student_study_plan_credit = itemView.findViewById(R.id.student_study_plan_credit_th);
        }
    }
}
