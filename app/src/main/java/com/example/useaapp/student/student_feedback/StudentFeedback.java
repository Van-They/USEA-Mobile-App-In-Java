package com.example.useaapp.student.student_feedback;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.useaapp.R;

public class StudentFeedback extends AppCompatActivity {
    Button btnSubmit_feedback;
    RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_feedback);
        Toolbar toolbar = findViewById(R.id.CustomActionbarStudentFeedback);
        setSupportActionBar(toolbar);
        setTitle(R.string.Feedback);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(view -> finish());
        btnSubmit_feedback = findViewById(R.id.submit_btn_feedback);
        ratingBar = findViewById(R.id.rating_star);

        btnSubmit_feedback.setOnClickListener(v->{
            String star = String.valueOf(ratingBar.getRating());
            Toast.makeText(this, star+"Rating star", Toast.LENGTH_SHORT).show();
        });

    }
}