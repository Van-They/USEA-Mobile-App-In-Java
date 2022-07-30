package com.example.useaapp.student.student_feedback;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.example.useaapp.R;

public class StudentFeedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_feedback);
        Toolbar toolbar = findViewById(R.id.CustomActionbarStudentFeedback);
        setSupportActionBar(toolbar);
        setTitle(R.string.Feedback);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}