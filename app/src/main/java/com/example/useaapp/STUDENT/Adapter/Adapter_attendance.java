package com.example.useaapp.STUDENT.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useaapp.R;
import com.example.useaapp.STUDENT.Attendance.Response_model_student_attendance;
import com.example.useaapp.STUDENT.StudyPlan.year1.Response_model_SemesterStudyPlan;

import java.util.List;

public class Adapter_attendance extends RecyclerView.Adapter<Adapter_attendance.ViewHolder> {

    List<Response_model_student_attendance> data;
    public Adapter_attendance(List<Response_model_student_attendance> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_cardview_attendance, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textTitle.setText(data.get(position).getSubject_name());
        holder.textHours.setText(data.get(position).getHours());
        holder.textPermissions.setText(data.get(position).getPermission());
        holder.textAbsents.setText(data.get(position).getAbsent());
        holder.textCome.setText(data.get(position).getPresent());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView textTitle, textHours, textPermissions, textAbsents, textCome;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textTitle = itemView.findViewById(R.id.subject_attendance);
            textHours = itemView.findViewById(R.id.hour_attendance);
            textPermissions = itemView.findViewById(R.id.permission_attendance);
            textAbsents = itemView.findViewById(R.id.absent_attendance);
            textCome = itemView.findViewById(R.id.come_attendance);


        }
    }

}
