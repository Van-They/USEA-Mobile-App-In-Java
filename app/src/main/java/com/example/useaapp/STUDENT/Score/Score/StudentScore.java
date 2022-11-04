package com.example.useaapp.STUDENT.Score.Score;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.example.useaapp.R;
import com.example.useaapp.STUDENT.Adapter.Adapter_score_tab_bar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class StudentScore extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_score);
        Toolbar toolbar = findViewById(R.id.CustomActionbarStudentScore);
        setSupportActionBar(toolbar);
        setTitle(R.string.Score);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(v -> finish());

        String[] Tab_title = {"ឆ្នាំទី១", "ឆ្នាំទី២", "ឆ្នាំទី៣", "ឆ្នាំទី៤"};

        tabLayout = findViewById(R.id.tab_menu_score);
        viewPager = findViewById(R.id.view_pager_menu_score);

        viewPager.setAdapter(new Adapter_score_tab_bar(this));
        new TabLayoutMediator(tabLayout, viewPager, ((tab, position) -> tab.setText(Tab_title[position]))).attach();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}