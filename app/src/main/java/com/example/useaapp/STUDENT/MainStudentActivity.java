package com.example.useaapp.STUDENT;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.useaapp.R;
import com.example.useaapp.STUDENT.Home.FragmentStudentHome;
import com.example.useaapp.STUDENT.News.FragmentStudentNews;
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
            switch (item.getItemId()) {
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

    @Override
    public void onBackPressed() {
        View layout = getLayoutInflater().inflate(R.layout.custom_dialog_back, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setView(layout);
        View Cancel = layout.findViewById(R.id.CancelBack);
        View Leave = layout.findViewById(R.id.LeaveApp);
        AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Cancel.setOnClickListener(v -> alertDialog.dismiss());
        Leave.setOnClickListener(v -> finishAffinity());
        alertDialog.show();
    }
}