package com.example.useaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.useaapp.guest.MainGuestActivity;
import com.example.useaapp.student.MainStudentActivity;
import com.example.useaapp.student.student_login.StudentLogin;

public class MainActivity extends AppCompatActivity {

    @Override
    public void overridePendingTransition(int enterAnim, int exitAnim) {
        super.overridePendingTransition(enterAnim, exitAnim);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button guest,student;
        guest= findViewById(R.id.guestaccount);
        student= findViewById(R.id.studentaccount);
        guest.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MainGuestActivity.class));
        });
        student.setOnClickListener(v ->{
            startActivity(new Intent(MainActivity.this, StudentLogin.class));
        });
    }
}