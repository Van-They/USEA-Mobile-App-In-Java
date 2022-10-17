package com.example.useaapp.GUEST.Program;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.useaapp.R;

import java.util.Objects;

public class GuestProgram extends AppCompatActivity {
    Toolbar toolbar;
    LinearLayout Social_Law,Economy_Tourism,Science_technology,Psychology_education,Foreign_language;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_program);
        toolbar = findViewById(R.id.CustomActionbarGuestProgram);
        setSupportActionBar(toolbar);
        setTitle(R.string.Study_program);
        toolbar.setNavigationOnClickListener(v->finish());
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        Initialize();
        Social_Law.setOnClickListener(v->startActivity(new Intent(GuestProgram.this,GuestDetailProgram.class)));
        Economy_Tourism.setOnClickListener(v->startActivity(new Intent(GuestProgram.this,GuestDetailProgram.class)));
        Science_technology.setOnClickListener(v->startActivity(new Intent(GuestProgram.this,GuestDetailProgram.class)));
        Psychology_education.setOnClickListener(v->startActivity(new Intent(GuestProgram.this,GuestDetailProgram.class)));
        Foreign_language.setOnClickListener(v->startActivity(new Intent(GuestProgram.this,GuestDetailProgram.class)));
    }
    void Initialize(){
        Social_Law = findViewById(R.id.Social_Law);
        Economy_Tourism = findViewById(R.id.Economy_Tourism);
        Science_technology = findViewById(R.id.Science_technology);
        Psychology_education = findViewById(R.id.Psychology_education);
        Foreign_language = findViewById(R.id.Foreign_language);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}