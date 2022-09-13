package com.example.useaapp.guest.guest_program;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.example.useaapp.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Objects;

public class GuestDetailProgram extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager;
    Toolbar toolbar;
    String [] Tab_menu = {""};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_detail_program);
        toolbar = findViewById(R.id.CustomActionbarGuestProgramDetail);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        tabLayout = findViewById(R.id.tab_menu_program_detail);
        viewPager = findViewById(R.id.view_pager_menu_program_detail);
        viewPager.setAdapter(new Adapter_guest_program_detail_tab_bar(this));
        new TabLayoutMediator(tabLayout,viewPager,(tab, position) -> tab.setText(Tab_menu[position])).attach();
    }
}