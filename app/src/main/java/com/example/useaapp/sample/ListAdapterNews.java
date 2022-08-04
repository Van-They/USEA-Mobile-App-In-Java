package com.example.useaapp.sample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.useaapp.R;

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
        TextView time,room,creator,subject,duedate,dateexam,labelnews;

        time = convertView.findViewById(R.id.timenews);
        room = convertView.findViewById(R.id.roomnews);
        creator = convertView.findViewById(R.id.creatornews);
        subject = convertView.findViewById(R.id.subject_news);
        duedate = convertView.findViewById(R.id.duedatenews);
        dateexam = convertView.findViewById(R.id.examdatenews);
        labelnews = convertView.findViewById(R.id.labelnews);

        time.setText(modelNews.getTime());
        room.setText(modelNews.getRoom());
        creator.setText(modelNews.getCreator());
        subject.setText(modelNews.getSubject());
        duedate.setText(modelNews.getDuedate());
        dateexam.setText(modelNews.getDate());
        labelnews.setText(modelNews.getLabel());

        return convertView;
    }
}
