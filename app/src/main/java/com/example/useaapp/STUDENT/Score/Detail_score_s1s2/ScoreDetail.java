package com.example.useaapp.STUDENT.Score.Detail_score_s1s2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.example.useaapp.R;
import com.example.useaapp.STUDENT.Adapter.Adapter_score_detail_tab_bar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Objects;

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
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> finish());
        String[] score_detail_tab = {"ឆមាសទី១", "ឆមាសទី២"};
        tabLayout = findViewById(R.id.tab_menu_score_detail);
        viewPager = findViewById(R.id.view_pager_menu_score_detail);
        viewPager.setAdapter(new Adapter_score_detail_tab_bar(this));
        new TabLayoutMediator(tabLayout, viewPager, ((tab, position) -> tab.setText(score_detail_tab[position]))).attach();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}