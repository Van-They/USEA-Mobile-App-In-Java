package com.example.useaapp.student.student_schedule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

import com.example.useaapp.R;

import java.util.Calendar;

public class StudentSchedule extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_schedule);
        toolbar = findViewById(R.id.CustomActionbarStudentSchedule);
        setSupportActionBar(toolbar);
        setTitle(R.string.Schedule);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CalendarView calendarView = findViewById(R.id.Student_calendar);

        

        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            Toast.makeText(view.getContext(), "Year" +year + "Month"+month + "Day"+dayOfMonth, Toast.LENGTH_SHORT).show();
        });
    }
}