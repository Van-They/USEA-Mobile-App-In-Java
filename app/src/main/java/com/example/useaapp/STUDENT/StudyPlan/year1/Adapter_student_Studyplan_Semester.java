package com.example.useaapp.STUDENT.StudyPlan.year1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useaapp.GUEST.Program.bachelor.Response_model_guest_program_faculty_bachelor;
import com.example.useaapp.R;

import java.util.List;

public class Adapter_student_Studyplan_Semester extends RecyclerView.Adapter<Adapter_student_Studyplan_Semester.ViewHolder> {
    List<Response_model_SemesterStudyPlan> data;
    public Adapter_student_Studyplan_Semester(List<Response_model_SemesterStudyPlan> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_items_studyplan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.student_study_plan_subject.setText(data.get(position).getSubject_name());
        holder.student_study_plan_hour.setText(data.get(position).getHours());
        holder.student_study_plan_credit.setText(data.get(position).getCredits());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView student_study_plan_subject, student_study_plan_hour, student_study_plan_credit;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            student_study_plan_subject = itemView.findViewById(R.id.student_study_plan_subject);
            student_study_plan_hour = itemView.findViewById(R.id.student_study_plan_hour);
            student_study_plan_credit = itemView.findViewById(R.id.student_study_plan_credit);
        }
    }
}
