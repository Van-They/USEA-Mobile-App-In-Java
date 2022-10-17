package com.example.useaapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.useaapp.GUEST.Login.GuestLogin;
import com.example.useaapp.STUDENT.Login.StudentLogin;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button guest,student;
        guest= findViewById(R.id.guest_account);
        student= findViewById(R.id.studentaccount);
        guest.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, GuestLogin.class));
        });
        student.setOnClickListener(v -> {
            startActivity(new Intent(this,StudentLogin.class));
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}