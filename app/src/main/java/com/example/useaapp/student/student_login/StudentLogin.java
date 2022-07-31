package com.example.useaapp.student.student_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.useaapp.R;
import com.example.useaapp.student.MainStudentActivity;

public class StudentLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        Button logIn = findViewById(R.id.student_btn_login);
        logIn.setOnClickListener(v-> startActivity(new Intent(this, MainStudentActivity.class)));
    }
}