package com.example.useaapp.student.student_schedule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.example.useaapp.R;

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
    }
}