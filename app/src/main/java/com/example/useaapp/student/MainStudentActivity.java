package com.example.useaapp.student;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.useaapp.R;
import com.example.useaapp.SampleActivity;
import com.example.useaapp.student.student_home.FragmentStudentHome;
import com.example.useaapp.student.student_news.FragmentStudentNews;
import com.google.android.material.navigation.NavigationBarView;

public class MainStudentActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_student);
        Toolbar toolbar = findViewById(R.id.customActionbarMainStudent);
        setSupportActionBar(toolbar);
        setTitle(R.string.StudentAccount);
        toolbar.setVisibility(View.GONE);
        NavigationBarView navigationBarView = findViewById(R.id.bottomNavigationBarStudent);
        getSupportFragmentManager().beginTransaction().replace(R.id.Frame_category, new FragmentStudentHome()).commit();
        navigationBarView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home_dashboard_student:
                    toolbar.setVisibility(View.GONE);
                    getSupportFragmentManager().beginTransaction().replace(R.id.Frame_category, new FragmentStudentHome()).commit();
                    break;
                case R.id.news_dashboard_student:
                    setTitle(R.string.News);
                    toolbar.setVisibility(View.VISIBLE);
                    getSupportFragmentManager().beginTransaction().replace(R.id.Frame_category, new FragmentStudentNews()).commit();
                    break;
            }
            return true;
        });
    }
}