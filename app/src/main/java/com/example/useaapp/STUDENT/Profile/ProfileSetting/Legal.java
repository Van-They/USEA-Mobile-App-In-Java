package com.example.useaapp.STUDENT.Profile.ProfileSetting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.TextView;

import com.example.useaapp.R;

public class Legal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legal);
        Toolbar toolbar = findViewById(R.id.CustomActionbarStudentLegal);
        setSupportActionBar(toolbar);
        setTitle(R.string.Legal);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView LegalDetail = findViewById(R.id.LegalDetail);
        LegalDetail.setText(R.string.LegalDetail);
        toolbar.setNavigationOnClickListener(v->finish());
    }
}