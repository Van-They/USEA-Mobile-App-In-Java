package com.example.useaapp.GUEST.Career;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.useaapp.R;

import java.util.Objects;

public class Detail_guest_career extends AppCompatActivity {
    Toolbar toolbar;

    TextView
            Title_guest_career_detail, Detail_guest_career_detail, Province_guest_career_detail,
            Month_guest_career_detail, Date_guest_career_detail, Year_guest_career_detail,
            Require_guest_career_detail, Label_guest_career_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_career);

        toolbar = findViewById(R.id.CustomActionbarGuestCareerDetail);
        setSupportActionBar(toolbar);
        setTitle(R.string.Career);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(view -> finish());

        Title_guest_career_detail = findViewById(R.id.Title_guest_career_detail);
        Detail_guest_career_detail = findViewById(R.id.Detail_guest_career_detail);
        Province_guest_career_detail = findViewById(R.id.Province_guest_career_detail);
        Month_guest_career_detail = findViewById(R.id.Month_guest_career_detail);
        Date_guest_career_detail = findViewById(R.id.Date_guest_career_detail);
        Year_guest_career_detail = findViewById(R.id.Year_guest_career_detail);
        Label_guest_career_detail = findViewById(R.id.Label_guest_career_detail);
        Require_guest_career_detail = findViewById(R.id.Require_guest_career_detail);

        String Title_guest_career = getIntent().getStringExtra("Title_guest_career");
        String Detail_guest_career = getIntent().getStringExtra("Detail_guest_career");
        String Province_guest_career = getIntent().getStringExtra("Province_guest_career");
        String Month_guest_career = getIntent().getStringExtra("Month_guest_career");
        String Date_guest_career = getIntent().getStringExtra("Date_guest_career");
        String Year_guest_career = getIntent().getStringExtra("Year_guest_career");
        String Label_guest_career = getIntent().getStringExtra("Label_guest_career");
        String Requirement_detail_guest_career = getIntent().getStringExtra("Requirement_detail_guest_career");

        Title_guest_career_detail.setText(Title_guest_career);
        Detail_guest_career_detail.setText(Detail_guest_career);
        Province_guest_career_detail.setText(Province_guest_career);
        Month_guest_career_detail.setText(Month_guest_career);
        Date_guest_career_detail.setText(Date_guest_career);
        Year_guest_career_detail.setText(Year_guest_career);
        Label_guest_career_detail.setText(Label_guest_career);
        Require_guest_career_detail.setText(Requirement_detail_guest_career);

    }

}