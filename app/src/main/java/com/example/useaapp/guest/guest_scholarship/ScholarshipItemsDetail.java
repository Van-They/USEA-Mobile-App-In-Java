package com.example.useaapp.guest.guest_scholarship;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Paint;
import android.os.Bundle;
import android.widget.TextView;

import com.example.useaapp.R;

import java.util.Objects;

public class ScholarshipItemsDetail extends AppCompatActivity {
    private String
            Title = "Title",
            Degree = "Degree",
            Fee = "Fee",
            Date = "Date",
            Month = "Month",
            Year = "Year";
    TextView Detail_title_scholarship_detail;//sample title scholarship
    TextView Date_scholarship_open_detail, Month_scholarship_open_detail, Year_scholarship_open_detail;//Application Open
    TextView Date_scholarship_close_detail, Month_scholarship_close_detail, Year_scholarship_close_detail, Learn_more_scholarship_detail;//last day for application
    TextView Application_required_scholarship_detail, How_to_apply_scholarship_detail;//Application type
    TextView Benefit_type_scholarship_detail, Full_benefit_detail_scholarship_detail;//Benefit type
    TextView Citizenship_requirement_scholarship_detail;//Citizenship_requirement
    TextView Total_value_scholarship_detail;//Total Value
    TextView Application_study_areas_scholarship_detail;//Application Study Area
    TextView School_detail_scholarship_detail;//school detail
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scholarshipitems_detail);
        toolbar = findViewById(R.id.CustomActionbarGuestScholarshipDetail);
        setSupportActionBar(toolbar);
        setTitle(R.string.Scholarship);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        initialize();//connect relationship class with activity
        getString();//get string from intent Guest Scholarship
        setString();//set text to textview in activity xml


    }

    private void initialize() {
        Detail_title_scholarship_detail = findViewById(R.id.Detail_title_scholarship_detail);//sample title scholarship
        //Application Open
        Date_scholarship_open_detail = findViewById(R.id.Date_scholarship_open_detail);
        Month_scholarship_open_detail = findViewById(R.id.Month_scholarship_open_detail);
        Year_scholarship_open_detail = findViewById(R.id.Year_scholarship_open_detail);

        //Last Day for application
        Date_scholarship_close_detail = findViewById(R.id.Date_scholarship_close_detail);
        Month_scholarship_close_detail = findViewById(R.id.Month_scholarship_close_detail);
        Year_scholarship_close_detail = findViewById(R.id.Year_scholarship_close_detail);
        Learn_more_scholarship_detail = findViewById(R.id.Learn_more_scholarship_detail);

        //Application type
        Application_required_scholarship_detail = findViewById(R.id.Application_required_scholarship_detail);
        How_to_apply_scholarship_detail = findViewById(R.id.How_to_apply_scholarship_detail);

        //Benefit type
        Benefit_type_scholarship_detail = findViewById(R.id.Benefit_type_scholarship_detail);
        Full_benefit_detail_scholarship_detail = findViewById(R.id.Full_benefit_detail_scholarship_detail);

        //Citizenship_requirement
        Citizenship_requirement_scholarship_detail = findViewById(R.id.Citizenship_requirement_scholarship_detail);

        //Total Value
        Total_value_scholarship_detail = findViewById(R.id.Total_value_scholarship_detail);

        //Application Study Area
        Application_study_areas_scholarship_detail = findViewById(R.id.Application_study_areas_scholarship_detail);

        //school detail
        School_detail_scholarship_detail = findViewById(R.id.School_detail_scholarship_detail);
    }

    private void getString() {
        Title = getIntent().getStringExtra(Title);
        Degree = getIntent().getStringExtra(Degree);
        Fee = getIntent().getStringExtra(Fee);
        Date = getIntent().getStringExtra(Date);
        Month = getIntent().getStringExtra(Month);
        Year = getIntent().getStringExtra(Year);
    }

    private void setString() {
        Detail_title_scholarship_detail.setText(Title);

        //set under line link
        Learn_more_scholarship_detail.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        How_to_apply_scholarship_detail.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        Full_benefit_detail_scholarship_detail.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
    }
}