package com.example.useaapp.guest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.useaapp.R;
import com.example.useaapp.guest.guest_home.FragmentGuestHome;
import com.example.useaapp.guest.guest_more.FragmentGuestMore;
import com.google.android.material.navigation.NavigationBarView;

public class MainGuestActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashobard_guest);
        NavigationBarView navigationBarView = findViewById(R.id.bottomNavigationBarGuest);
        getSupportFragmentManager().beginTransaction().replace(R.id.guestLayoutDashboard, new FragmentGuestHome()).commit();
        navigationBarView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home_guest_dashboard:
                    getSupportFragmentManager().beginTransaction().replace(R.id.guestLayoutDashboard, new FragmentGuestHome()).commit();
                    break;
                case R.id.more_guest_dashboard:
                    getSupportFragmentManager().beginTransaction().replace(R.id.guestLayoutDashboard, new FragmentGuestMore()).commit();
                    break;
            }
            return true;
        });
    }
}