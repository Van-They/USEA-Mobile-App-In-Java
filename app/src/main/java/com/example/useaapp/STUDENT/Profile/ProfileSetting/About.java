package com.example.useaapp.STUDENT.Profile.ProfileSetting;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.useaapp.R;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = findViewById(R.id.CustomActionbarStudentAbout);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(R.string.About);
        TextView AboutDetail = findViewById(R.id.AboutDetail);
        AboutDetail.setText(R.string.AboutDetail);
        toolbar.setNavigationOnClickListener(v -> finish());
    }
}