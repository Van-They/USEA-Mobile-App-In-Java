package com.example.useaapp.student.student_adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.useaapp.R;
import com.example.useaapp.student.student_news.ModelNews;

import java.util.ArrayList;

public class ListAdapterNews extends ArrayAdapter<ModelNews> {

    public ListAdapterNews(@NonNull Context context, ArrayList<ModelNews> arrayList) {
        super(context, R.layout.custom_items_news,arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_items_news,parent,false);
        }
        ModelNews modelNews = getItem(position);
        LinearLayout LayoutTime,LayoutDate,LayoutDueDate,LayoutCreator,LayoutRoom;
        TextView Time,Room,Creator,Subject,Due_date,Date_exam,Label_news;
//        TextView Label_time,Label_room,Label_date_exam,Label_due_date,Label_creator;
        TextView Homework,Assignment,Midterm;

        //Textview
        Time = convertView.findViewById(R.id.Time_news);
        Room = convertView.findViewById(R.id.Room_news);
        Creator = convertView.findViewById(R.id.Creator_news);
        Subject = convertView.findViewById(R.id.Subject_news);
        Due_date = convertView.findViewById(R.id.Due_date_news);
        Date_exam = convertView.findViewById(R.id.Exam_date_news);
        Label_news = convertView.findViewById(R.id.Label_news);

        //LabelText
//        Label_time = convertView.findViewById(R.id.labeltime);
//        Label_room = convertView.findViewById(R.id.labelroom);
//        Label_date_exam = convertView.findViewById(R.id.lablexamdate);
//        Label_creator = convertView.findViewById(R.id.labelcreator);
//        Label_due_date = convertView.findViewById(R.id.labelduedate);

        LayoutDueDate = convertView.findViewById(R.id.LayoutDueDate);
        LayoutDate = convertView.findViewById(R.id.LayoutDate);
        LayoutRoom = convertView.findViewById(R.id.LayoutRoom);
        LayoutTime = convertView.findViewById(R.id.LayoutTime);
        LayoutCreator = convertView.findViewById(R.id.LayoutCreator);

        //Label News
        Homework = convertView.findViewById(R.id.Label_homework);
        Assignment = convertView.findViewById(R.id.Label_assignment);
        Midterm = convertView.findViewById(R.id.Label_midterm);

        switch (modelNews.getLabel()){
            case "Midterm":
                Midterm.setVisibility(View.VISIBLE);
                Homework.setVisibility(View.GONE);
                Assignment.setVisibility(View.GONE);
                LayoutDueDate.setVisibility(View.GONE);
                LayoutCreator.setVisibility(View.GONE);
                LayoutTime.setVisibility(View.VISIBLE);
                LayoutDate.setVisibility(View.VISIBLE);
                LayoutRoom.setVisibility(View.VISIBLE);
                break;
            case "Homework":
                Homework.setVisibility(View.VISIBLE);
                Assignment.setVisibility(View.GONE);
                Midterm.setVisibility(View.GONE);
                //set view Layout
                LayoutTime.setVisibility(View.GONE);
                LayoutDate.setVisibility(View.GONE);
                LayoutRoom.setVisibility(View.GONE);

                LayoutDueDate.setVisibility(View.VISIBLE);
                LayoutCreator.setVisibility(View.VISIBLE);
                break;
            case "Assignment":
                Assignment.setVisibility(View.VISIBLE);
                Homework.setVisibility(View.GONE);
                Midterm.setVisibility(View.GONE);
                //set view layout
                LayoutTime.setVisibility(View.GONE);
                LayoutDate.setVisibility(View.GONE);
                LayoutRoom.setVisibility(View.GONE);

                LayoutDueDate.setVisibility(View.VISIBLE);
                LayoutCreator.setVisibility(View.VISIBLE);
                break;

//                //set view layout
//                LayoutTime.setVisibility(View.GONE);
//                LayoutDate.setVisibility(View.GONE);
//                LayoutRoom.setVisibility(View.GONE);
//                break;

        }

        Time.setText(modelNews.getTime());
        Room.setText(modelNews.getRoom());
        Creator.setText(modelNews.getCreator());
        Subject.setText(modelNews.getSubject());
        Due_date.setText(modelNews.getDue_date());
        Date_exam.setText(modelNews.getDate());
        Label_news.setText(modelNews.getLabel());

        return convertView;
    }
}
