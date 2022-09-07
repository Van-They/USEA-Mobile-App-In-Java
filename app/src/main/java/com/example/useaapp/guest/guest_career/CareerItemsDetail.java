package com.example.useaapp.guest.guest_career;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toolbar;

import com.example.useaapp.R;

import java.util.Objects;

public class CareerItemsDetail extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_career_items_detail);
        toolbar = findViewById(R.id.CustomActionbarGuestCareerDetail);
        setTitle(R.string.Career);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(view -> finish());
    }
}