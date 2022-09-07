package com.example.useaapp.student.student_schedule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.useaapp.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class StudentSchedule extends AppCompatActivity {
    Toolbar toolbar;
    List<ScheduleModel> models;
    ListView Listview_student_schedule;
    Adpter_student_schedule adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_schedule);
        toolbar = findViewById(R.id.CustomActionbarStudentSchedule);
        setSupportActionBar(toolbar);
        setTitle(R.string.Schedule);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Listview_student_schedule = findViewById(R.id.Listview_student_schedule);
        models = new ArrayList<>();

        CalendarView calendarView = findViewById(R.id.Student_calendar);

        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            models.clear();
            models.add(new ScheduleModel(dayOfMonth,month,year));
            adapter = new Adpter_student_schedule(getApplicationContext(),models);
            adapter.notifyDataSetChanged();
            Listview_student_schedule.setAdapter(adapter);
        });
    }

}