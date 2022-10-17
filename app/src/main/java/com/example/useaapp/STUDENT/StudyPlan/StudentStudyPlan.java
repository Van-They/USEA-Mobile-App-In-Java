package com.example.useaapp.STUDENT.StudyPlan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.useaapp.R;
import com.example.useaapp.STUDENT.Adapter.Adapter_study_plan_tab_bar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Objects;

public class StudentStudyPlan extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    String[] Tab_title = {"ឆ្នាំទី១", "ឆ្នាំទី២", "ឆ្នាំទី៣", "ឆ្នាំទី៤"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_study_plan);
        Toolbar toolbar = findViewById(R.id.CustomActionbarStudentStudyPlan);
        setSupportActionBar(toolbar);
        setTitle(R.string.Studyplan);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> finish());
        tabLayout = findViewById(R.id.tab_menu_studyPlan);
        viewPager2 = findViewById(R.id.view_pager_menu_studyPlan);

        viewPager2.setAdapter(new Adapter_study_plan_tab_bar(this));
        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> tab.setText(Tab_title[position])).attach();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}