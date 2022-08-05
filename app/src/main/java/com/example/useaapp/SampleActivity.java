package com.example.useaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.useaapp.student.student_adapter.ListAdapterNews;
import com.example.useaapp.student.student_news.ModelNews;

import java.util.ArrayList;

public class SampleActivity extends AppCompatActivity {
    ListView listView;

    ArrayList<ModelNews> modelNews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
    }

}