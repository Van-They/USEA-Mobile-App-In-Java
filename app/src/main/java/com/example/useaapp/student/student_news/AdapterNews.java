package com.example.useaapp.student.student_news;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useaapp.R;
import com.example.useaapp.SampleActivity;

import java.util.List;

public class AdapterNews extends RecyclerView.Adapter<AdapterNews.ViewHolder> {
    private final List<String> Sub,room,date,time,creator,label,duedate;

    public AdapterNews(List<String> sub, List<String> room, List<String> date, List<String> time, List<String> creator, List<String> label, List<String> duedate) {
        Sub = sub;
        this.room = room;
        this.date = date;
        this.time = time;
        this.creator = creator;
        this.label = label;
        this.duedate = duedate;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_items_news,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String txtsubject,txtroom,txtdate,txttime,txtcreator,txtlabel,txtduedate;
        txtsubject = Sub.get(position);
        txtroom = room.get(position);
        txtdate = date.get(position);
        txttime = time.get(position);
        txtcreator = creator.get(position);
        txtlabel = label.get(position);
        txtduedate = duedate.get(position);

        holder.subject.setText(txtsubject);
        holder.duedate.setText(txtduedate);
        holder.label.setText(txtlabel);
        holder.room.setText(txtroom);
        holder.date.setText(txtdate);
        holder.time.setText(txttime);
        holder.creator.setText(txtcreator);
    }

    @Override
    public int getItemCount() {
        return label.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView subject,room,date,time,creator,label,duedate;
        TextView labeltime,labelexamdate,labelroom;
        @SuppressLint("ResourceAsColor")
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            subject = itemView.findViewById(R.id.subject_news);
            room = itemView.findViewById(R.id.roomnews);
            date = itemView.findViewById(R.id.examdatenews);
            time = itemView.findViewById(R.id.timenews);
            creator = itemView.findViewById(R.id.creatornews);
            label = itemView.findViewById(R.id.labelnews);
            duedate = itemView.findViewById(R.id.duedatenews);

            //label
            labeltime = itemView.findViewById(R.id.labeltime);
            labelexamdate = itemView.findViewById(R.id.lablexamdate);
            labelroom = itemView.findViewById(R.id.labelroom);

            if (AdapterNews.this.label.contains("Homework")) {
                time.setVisibility(View.GONE);
                date.setVisibility(View.GONE);
                room.setVisibility(View.GONE);
                //label
                labeltime.setVisibility(View.GONE);
                labelexamdate.setVisibility(View.GONE);
                labelroom.setVisibility(View.GONE);
            } else if (AdapterNews.this.label.contains("Midterm")){
                time.setVisibility(View.VISIBLE);
                date.setVisibility(View.VISIBLE);
                room.setVisibility(View.VISIBLE);
                labeltime.setVisibility(View.VISIBLE);
                labelexamdate.setVisibility(View.VISIBLE);
                labelroom.setVisibility(View.VISIBLE);
            }
        }
    }
}
