package com.example.useaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.useaapp.sample.ListAdapterNews;
import com.example.useaapp.sample.ModelNews;

import java.util.ArrayList;
import java.util.List;

public class SampleActivity extends AppCompatActivity {
    ListView listView;
    TextView ltime,lroom,ldateexam,lduedate,lcreator;
    ArrayList<ModelNews> modelNews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        ltime = findViewById(R.id.labeltime);
        lroom = findViewById(R.id.labelroom);
        ldateexam = findViewById(R.id.lablexamdate);
        lcreator = findViewById(R.id.labelcreator);
        lduedate = findViewById(R.id.duedatenews);
        listView = findViewById(R.id.samplelistview);
        addItem();
        listView.setAdapter(new ListAdapterNews(getApplicationContext(),modelNews));




    }

    private void addItem() {
        modelNews = new ArrayList<>();
        modelNews.add(new ModelNews("Java programing I","20-08-2022","01-09-2022","6:00","Preahkan","Sa Sokngim","Homework"));
        modelNews.add(new ModelNews("Java programing II","20-08-2022","01-09-2022","6:00","Preahkan","Sa Sokngim","Assigment"));
        modelNews.add(new ModelNews("Web Development","20-08-2022","01-09-2022","6:00","Preahkan","Sa Sokngim","Midterm"));

    }
}