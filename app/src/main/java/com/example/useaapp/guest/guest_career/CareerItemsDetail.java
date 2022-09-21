package com.example.useaapp.guest.guest_career;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.TextView;

import com.example.useaapp.R;

import java.util.Objects;

public class CareerItemsDetail extends AppCompatActivity {
    private String
            Title = "Title",
            Detail = "Detail",
            Province = "Province",
            Month = "Month",
            Date = "Date",
            Year = "Year",
            Require = "Require",
            Label = "Label";

    Toolbar toolbar;
    TextView
             Title_guest_career_detail,
             Detail_guest_career_detail,
             Province_guest_career_detail,
             Month_guest_career_detail,
             Date_guest_career_detail,
             Year_guest_career_detail,
             Require_guest_career_detail,
             Label_guest_career_detail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_career_items_detail);
        toolbar = findViewById(R.id.CustomActionbarGuestCareerDetail);
        setSupportActionBar(toolbar);
        setTitle(R.string.Career);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(view -> finish());

        initialize();
        getString();
        setString();
    }
    public void initialize(){
        Title_guest_career_detail = findViewById(R.id.Title_guest_career_detail);

        Detail_guest_career_detail = findViewById(R.id.Detail_guest_career_detail);

        Province_guest_career_detail = findViewById(R.id.Province_guest_career_detail);

        Month_guest_career_detail = findViewById(R.id.Month_guest_career_detail);

        Date_guest_career_detail = findViewById(R.id.Date_guest_career_detail);

        Year_guest_career_detail = findViewById(R.id.Year_guest_career_detail);

        Require_guest_career_detail = findViewById(R.id.Require_guest_career_detail);

        Label_guest_career_detail = findViewById(R.id.Label_guest_career_detail);

    }
    public void getString(){
        Title = getIntent().getStringExtra(Title);
        Detail = getIntent().getStringExtra(Detail);
        Province = getIntent().getStringExtra(Province);
        Month = getIntent().getStringExtra(Month);
        Date = getIntent().getStringExtra(Date);
        Year = getIntent().getStringExtra(Year);
        Require = getIntent().getStringExtra(Require);
        Label = getIntent().getStringExtra(Label);
    }
    public void setString(){
        Title_guest_career_detail.setText(Title);
        Detail_guest_career_detail.setText(Detail);
        Province_guest_career_detail.setText(Province);
        Month_guest_career_detail.setText(Month);
        Date_guest_career_detail.setText(Date);
        Year_guest_career_detail.setText(Year);
        Require_guest_career_detail.setText(Require);
        Label_guest_career_detail.setText(Label);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}