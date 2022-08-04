package com.example.useaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import com.example.useaapp.guest.MainGuestActivity;
import com.example.useaapp.student.MainStudentActivity;
import com.example.useaapp.student.student_login.StudentLogin;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    private static String SHARED_PREF_NAME = "mypref";
    private static String KEY_STUDENT_ID = "student_id";
    private static String KEY_PWD = "pwd";
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

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        guest.setOnClickListener(v -> {
            startActivity(new Intent(this, MainGuestActivity.class));
        });
        student.setOnClickListener(v -> {
            sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
            String st_id = sharedPreferences.getString(KEY_STUDENT_ID, "");
            if (st_id != null){
                startActivity(new Intent(this,MainStudentActivity.class));
            } else {
                startActivity(new Intent(this,StudentLogin.class));
            }
        });
    }
}