package com.example.useaapp.STUDENT;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.useaapp.R;
import com.example.useaapp.STUDENT.Home.FragmentStudentHome;
import com.example.useaapp.STUDENT.Login.StudentLogin;
import com.example.useaapp.STUDENT.News.FragmentStudentNews;
import com.example.useaapp.databinding.ActivityMainStudentBinding;
import com.example.useaapp.databinding.CustomDialogBackBinding;

public class MainStudentActivity extends AppCompatActivity {
    private final static String Student_Name = "name";
    private final static String SHARE_PREFNAME = "Student_Name";
    ActivityMainStudentBinding binding;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainStudentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.customActionbarMainStudent.toolbar);
        setTitle(R.string.StudentAccount);
        sharedPreferences = getSharedPreferences(SHARE_PREFNAME, MODE_PRIVATE);
        String st_name = sharedPreferences.getString(Student_Name, "");
        if (st_name.equals("")) {
            finish();
            startActivity(new Intent(MainStudentActivity.this, StudentLogin.class));
        }
        binding.customActionbarMainStudent.toolbar.setVisibility(View.GONE);
        getSupportFragmentManager().beginTransaction().replace(R.id.Frame_category, new FragmentStudentHome()).commit();
        binding.bottomNavigationBarStudent.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case (R.id.home_dashboard_student):
                    binding.customActionbarMainStudent.toolbar.setVisibility(View.GONE);
                    getSupportFragmentManager().beginTransaction().replace(R.id.Frame_category, new FragmentStudentHome()).commit();
                    break;
                case (R.id.news_dashboard_student):
                    setTitle(R.string.News);
                    binding.customActionbarMainStudent.toolbar.setVisibility(View.VISIBLE);
                    getSupportFragmentManager().beginTransaction().replace(R.id.Frame_category, new FragmentStudentNews()).commit();
                    break;
            }
            return true;
        });
    }

    @Override
    public void onBackPressed() {
        CustomDialogBackBinding binding = CustomDialogBackBinding.inflate(getLayoutInflater());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setView(binding.getRoot());
        AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        binding.CancelBack.setOnClickListener(v -> alertDialog.dismiss());
        binding.LeaveApp.setOnClickListener(v -> finishAffinity());
        alertDialog.show();
    }
}