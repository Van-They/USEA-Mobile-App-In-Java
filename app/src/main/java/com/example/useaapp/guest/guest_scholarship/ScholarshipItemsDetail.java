package com.example.useaapp.guest.guest_scholarship;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.useaapp.R;

public class ScholarshipItemsDetail extends AppCompatActivity {
    private String
            Title = "Title",
            Degree = "Degree",
            Fee = "Fee",
            Date = "Date",
            Month = "Month",
            Year = "Year";
    TextView Title_,Degree_,Fee_,Date_,Month_,Year_;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scholarshipitems_detail);
        toolbar = findViewById(R.id.CustomActionbarGuestScholarshipDetail);
        setSupportActionBar(toolbar);
        setTitle(R.string.Scholarship);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Title = getIntent().getStringExtra(Title);
        Degree = getIntent().getStringExtra(Degree);
        Fee = getIntent().getStringExtra(Fee);
        Date = getIntent().getStringExtra(Date);
        Month = getIntent().getStringExtra(Month);
        Year = getIntent().getStringExtra(Year);

        Title_ = findViewById(R.id.testtxtdetailscholarship);

        Title_.setText(Title);
    }
}