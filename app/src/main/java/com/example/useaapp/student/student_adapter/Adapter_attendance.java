package com.example.useaapp.student.student_adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useaapp.R;

import java.util.List;

public class Adapter_attendance extends RecyclerView.Adapter<Adapter_attendance.ViewHolder> {

    private final List<String> subject;
    private final List<String> hour;
    private final List<String> permission;
    private final List<String> absent;
    private final List<String> come;
    public Adapter_attendance(List<String> subject, List<String> hour, List<String> permission, List<String> absent,List<String> come) {
        this.subject = subject;
        this.hour = hour;
        this.permission = permission;
        this.absent = absent;
        this.come = come;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_cardview_attendance, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        String title = subject.get(position);
        String hours = hour.get(position);
        String permissions = permission.get(position);
        String absents = absent.get(position);
        String Come = come.get(position);

        holder.textTitle.setText(title);
        holder.textHours.setText(hours);
        holder.textPermissions.setText(permissions);
        holder.textAbsents.setText(absents);
        holder.textCome.setText(Come);
    }

    @Override
    public int getItemCount() {
        return subject.size();
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
