package com.example.useaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.useaapp.student.student_news.AdapterNews;

import java.util.ArrayList;
import java.util.List;

public class SampleActivity extends AppCompatActivity {
     List<String> Sub,room,time,date,due,label,creator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        AdapterNews adapterNews;
        RecyclerView recyclerView = findViewById(R.id.sampleRecycler);
        AddDataView();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapterNews = new AdapterNews(Sub,room,date,time,creator,label,due);
        recyclerView.setAdapter(adapterNews);
    }

    private void AddDataView() {
        declareArray();

        Sub.add("Java Progaming");
        room.add("Preahkan");
        time.add("6:00");
        due.add("20.07.2022");
        date.add("11.07.2022");
        label.add("Midterm");
        creator.add("Soknigm");

        Sub.add("Java Progaming");
        room.add("");
        time.add("");
        due.add("20.07.2022");
        date.add("");
        label.add("Homework");
        creator.add("Soknigm");

        Sub.add("Java Progaming");
        room.add("");
        time.add("");
        due.add("20.07.2022");
        date.add("");
        label.add("Assignment");
        creator.add("Soknigm");

        Sub.add("Java Progaming");
        room.add("Preahkan");
        time.add("6:00");
        due.add("20.07.2022");
        date.add("11.07.2022");
        label.add("Midterm");
        creator.add("Soknigm");
    }
    private void declareArray() {
        Sub = new ArrayList<>();
        room = new ArrayList<>();
        time = new ArrayList<>();
        date = new ArrayList<>();
        due = new ArrayList<>();
        label = new ArrayList<>();
        creator = new ArrayList<>();
    }

}