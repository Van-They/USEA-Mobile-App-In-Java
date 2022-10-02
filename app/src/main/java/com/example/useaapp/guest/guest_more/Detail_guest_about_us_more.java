package com.example.useaapp.guest.guest_more;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.example.useaapp.R;

import java.util.Objects;

public class Detail_guest_about_us_more extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_guest_about_us_more);

        toolbar = findViewById(R.id.CustomActionbarGuestAboutUsDetail);
        setSupportActionBar(toolbar);
        setTitle(R.string.About_Us);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(view -> finish());


    }
}