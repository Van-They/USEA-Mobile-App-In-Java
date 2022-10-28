package com.example.useaapp.GUEST.Program;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.useaapp.GUEST.Program.associative.Fragment_associative;
import com.example.useaapp.GUEST.Program.bachelor.Fragment_bachelor;
import com.example.useaapp.GUEST.Program.master.Fragment_master;
import com.example.useaapp.R;
import com.example.useaapp.SampleFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Objects;

public class GuestDetailProgram extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager;
    Toolbar toolbar;
    Fragment fragment;
    String [] Tab_menu = {"ថ្នាក់បរិញ្ញាបត្ររង","ថ្នាក់បរិញ្ញាបត្រ","ថ្នាក់បរិញ្ញាបត្រជាន់ខ្ពស់"};
    public static final String text = "txt";
    String txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_detail_program);
        toolbar = findViewById(R.id.CustomActionbarGuestProgramDetail);
        setSupportActionBar(toolbar);
        setTitle(R.string.Study_program);
        toolbar.setNavigationOnClickListener(v -> finish());
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        tabLayout = findViewById(R.id.tab_menu_program_detail);

        txt = getIntent().getStringExtra(text);

        if(txt.equals("1")){
            tabLayout.addTab(tabLayout.newTab().setText("ថ្នាក់បរិញ្ញាបត្រ"));
            ChangeFragment(new Fragment_bachelor());
        }else if(txt.equals("2")){
            tabLayout.addTab(tabLayout.newTab().setText("ថ្នាក់បរិញ្ញាបត្ររង"));
            ChangeFragment(new Fragment_associative());
            tabLayout.addTab(tabLayout.newTab().setText("ថ្នាក់បរិញ្ញាបត្រ"));
        }else if(txt.equals("3")){
            tabLayout.addTab(tabLayout.newTab().setText("ថ្នាក់បរិញ្ញាបត្រ"));
            ChangeFragment(new Fragment_bachelor());
        }else if(txt.equals("4")){
            tabLayout.addTab(tabLayout.newTab().setText("ថ្នាក់បរិញ្ញាបត្រ"));
            ChangeFragment(new Fragment_bachelor());
        }

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                switch (tab.getPosition()){
                    case 0:
                        ChangeFragment(new Fragment_associative());
                        break;
                    case 1:
                        ChangeFragment(new Fragment_bachelor());
                        break;
                    case 2:
                        ChangeFragment(new Fragment_master());
                        break;
                    default:
                        Toast.makeText(GuestDetailProgram.this, "Hi", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    public void ChangeFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_menu_program_detail, fragment).commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}