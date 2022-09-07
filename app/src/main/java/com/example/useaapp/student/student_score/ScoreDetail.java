package com.example.useaapp.student.student_score;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.useaapp.R;
import com.example.useaapp.student.student_adapter.Adapter_studentscore;
import com.example.useaapp.student.student_score.year1.Adapter_student_score_detail_tabbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ScoreDetail extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_detail);
        toolbar = findViewById(R.id.CustomActionbarStudentScoreDetail);
        setSupportActionBar(toolbar);
        setTitle(R.string.Score);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v->finish());
        String[] score_detail_tab = {"ឆមាសទី១", "ឆមាសទី២"};
        tabLayout=findViewById(R.id.tab_menu_score_detail);
        viewPager=findViewById(R.id.view_pager_menu_score_detail);
        viewPager.setAdapter(new Adapter_student_score_detail_tabbar(this));
        new TabLayoutMediator(tabLayout,viewPager,((tab, position) -> tab.setText(score_detail_tab[position]))).attach();

    }
}