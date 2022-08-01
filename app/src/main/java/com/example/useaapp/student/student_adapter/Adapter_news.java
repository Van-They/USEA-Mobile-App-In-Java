package com.example.useaapp.student.student_adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useaapp.R;
import com.example.useaapp.student.student_news.Assignment;
import com.example.useaapp.student.student_news.Homework;
import com.example.useaapp.student.student_news.Midterm;
import com.example.useaapp.student.student_news.Model;

import java.util.List;

public class Adapter_news extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<Model> models;

    public Adapter_news(List<Model> models) {
        this.models = models;
    }

    @Override
    public int getItemViewType(int position) {
        return models.get(position).getViewType();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if (viewType == 1) {
            return new AssignmentHolder(layoutInflater.inflate(R.layout.custom_cardview_assignment, parent, false));
        } else if (viewType == 2) {
            return new HomeworkHolder(layoutInflater.inflate(R.layout.custom_cardview_homework, parent, false));
        } else if (viewType == 3) {
            return new MidtermHolder(layoutInflater.inflate(R.layout.custom_cardview_midterm, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == 1) {
            AssignmentHolder assignmentHolder = (AssignmentHolder) holder;
            Assignment assignment = (Assignment) models.get(position).getObject();
            assignmentHolder.setViewAssignment(assignment);
        } else if (holder.getItemViewType() == 2) {
            HomeworkHolder homeworkHolder = (HomeworkHolder) holder;
            Homework homework = (Homework) models.get(position).getObject();
            homeworkHolder.setViewHomework(homework);
        } else if (holder.getItemViewType() == 3) {
            MidtermHolder midtermHolder = (MidtermHolder) holder;
            Midterm midterm = (Midterm) models.get(position).getObject();
            midtermHolder.setViewMidterm(midterm);
        }
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    static class AssignmentHolder extends RecyclerView.ViewHolder{
        private final TextView subject_assignment, due_date_assignment, create_by_assignment;

        public AssignmentHolder(@NonNull View itemView) {
            super(itemView);
            subject_assignment = itemView.findViewById(R.id.subject_assignment_news);
            due_date_assignment = itemView.findViewById(R.id.due_date_assignment_news);
            create_by_assignment = itemView.findViewById(R.id.create_by_assignment_news);
        }

        public void setViewAssignment(Assignment assignment) {
            subject_assignment.setText(assignment.getSubject_assignment());
            due_date_assignment.setText(assignment.getDue_date_assignment());
            create_by_assignment.setText(assignment.getCreate_by_assigment());
        }
    }

    static class HomeworkHolder extends RecyclerView.ViewHolder {
        private final TextView subject_homework, due_date_homework, create_by_homework;

        public HomeworkHolder(@NonNull View itemView) {
            super(itemView);
            subject_homework = itemView.findViewById(R.id.subject_homework_news);
            due_date_homework = itemView.findViewById(R.id.due_date_homework_news);
            create_by_homework = itemView.findViewById(R.id.create_by_homework_news);
        }

        public void setViewHomework(Homework homework) {
            subject_homework.setText(homework.getSubject_homework());
            due_date_homework.setText(homework.getDue_date_homework());
            create_by_homework.setText(homework.getCreate_by_homework());
        }
    }

    static class MidtermHolder extends RecyclerView.ViewHolder {
        private final TextView subject_midterm, date_midterm, time_midterm, room_midterm;

        public MidtermHolder(@NonNull View itemView) {
            super(itemView);
            subject_midterm = itemView.findViewById(R.id.subject_midterm_news);
            date_midterm = itemView.findViewById(R.id.date_midterm_news);
            time_midterm = itemView.findViewById(R.id.time_midterm_news);
            room_midterm = itemView.findViewById(R.id.room_midterm_news);
        }

        public void setViewMidterm(Midterm midterm) {
            subject_midterm.setText(midterm.getSubject_midterm());
            date_midterm.setText(midterm.getExam_date_midterm());
            time_midterm.setText(midterm.getTime_midterm());
            room_midterm.setText(midterm.getRoom_midterm());

        }
    }
}