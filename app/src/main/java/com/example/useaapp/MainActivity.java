package com.example.useaapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.useaapp.guest.MainGuestActivity;
import com.example.useaapp.guest.guest_login.GuestLogin;
import com.example.useaapp.student.student_login.StudentLogin;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button guest, student;
        guest = findViewById(R.id.guestaccount);
        student = findViewById(R.id.studentaccount);
        guest.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, GuestLogin.class)));
        student.setOnClickListener(v -> startActivity(new Intent(this, StudentLogin.class)));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}