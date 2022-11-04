package com.example.useaapp.GUEST.Scholarship;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.useaapp.R;

public class Detail_guest_scholarship extends AppCompatActivity {
    Toolbar toolbar;

    TextView usea_name, School_detail_scholarship_detail, Date_scholarship_open_detail, Date_scholarship_close_detail,
            Learn_more_scholarship_detail, Application_required_scholarship_detail, How_to_apply_scholarship_detail,
            Benefit_type_scholarship_detail, Full_benefit_detail_scholarship_detail, Citizenship_requirement_scholarship_detail,
            Total_value_scholarship_detail, Application_study_areas_scholarship_detail;
    //Link to URL
    private void gotUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_scholarship);

        toolbar = findViewById(R.id.CustomActionbarGuestScholarship);
        setSupportActionBar(toolbar);
        setTitle(R.string.Scholarship);
        assert getSupportActionBar() !=null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(view -> finish());


        usea_name = findViewById(R.id.usea_name);
        School_detail_scholarship_detail = findViewById(R.id.School_detail_scholarship_detail);
        Date_scholarship_open_detail = findViewById(R.id.Date_scholarship_open_detail);
        Date_scholarship_close_detail = findViewById(R.id.Date_scholarship_close_detail);
        Learn_more_scholarship_detail = findViewById(R.id.Learn_more_scholarship_detail);
        Application_required_scholarship_detail = findViewById(R.id.Application_required_scholarship_detail);
        How_to_apply_scholarship_detail = findViewById(R.id.How_to_apply_scholarship_detail);
        Benefit_type_scholarship_detail = findViewById(R.id.Benefit_type_scholarship_detail);
        Full_benefit_detail_scholarship_detail = findViewById(R.id.Full_benefit_detail_scholarship_detail);
        Citizenship_requirement_scholarship_detail = findViewById(R.id.Citizenship_requirement_scholarship_detail);
        Total_value_scholarship_detail = findViewById(R.id.Total_value_scholarship_detail);
        Application_study_areas_scholarship_detail = findViewById(R.id.Application_study_areas_scholarship_detail);

        String University_guest_scholarship = getIntent().getStringExtra("University_guest_scholarship");
        String Detail_description_guest_scholarship = getIntent().getStringExtra("Detail_description_guest_scholarship");
        String Date_open_detail_guest_scholarship = getIntent().getStringExtra("Date_open_detail_guest_scholarship");
        String Date_close_detail_guest_scholarship = getIntent().getStringExtra("Date_close_detail_guest_scholarship");
        String Learnmore_guest_scholarship = getIntent().getStringExtra("Learnmore_guest_scholarship");
        String Application_required_detail_guest_scholarship = getIntent().getStringExtra("Application_required_detail_guest_scholarship");
        String How_to_apply_detail_guest_scholarship = getIntent().getStringExtra("How_to_apply_detail_guest_scholarship");
        String Benefit_type_detail_guest_scholarship = getIntent().getStringExtra("Benefit_type_detail_guest_scholarship");
        String Full_benefit_detail_guest_scholarship = getIntent().getStringExtra("Full_benefit_detail_guest_scholarship");
        String Citizenship_requirement_detail_guest_scholarship = getIntent().getStringExtra("Citizenship_requirement_detail_guest_scholarship");
        String Total_value_detail_guest_scholarship = getIntent().getStringExtra("Total_value_detail_guest_scholarship");
        String Application_study_areas_detail_guest_scholarship = getIntent().getStringExtra("Application_study_areas_detail_guest_scholarship");

        usea_name.setText(University_guest_scholarship);
        School_detail_scholarship_detail.setText(Detail_description_guest_scholarship);
        Date_scholarship_open_detail.setText(Date_open_detail_guest_scholarship);
        Date_scholarship_close_detail.setText(Date_close_detail_guest_scholarship);
        //
//        Learn_more_scholarship_detail.setText(Learnmore_guest_scholarship);
        Application_required_scholarship_detail.setText(Application_required_detail_guest_scholarship);
//        How_to_apply_scholarship_detail.setText(How_to_apply_detail_guest_scholarship);
        Benefit_type_scholarship_detail.setText(Benefit_type_detail_guest_scholarship);
//        Full_benefit_detail_scholarship_detail.setText(Full_benefit_detail_guest_scholarship);
        Citizenship_requirement_scholarship_detail.setText(Citizenship_requirement_detail_guest_scholarship);
        Total_value_scholarship_detail.setText(Total_value_detail_guest_scholarship);
        Application_study_areas_scholarship_detail.setText(Application_study_areas_detail_guest_scholarship);

        Learn_more_scholarship_detail.setOnClickListener(View -> gotUrl(Learnmore_guest_scholarship));
        How_to_apply_scholarship_detail.setOnClickListener(View -> gotUrl(How_to_apply_detail_guest_scholarship));
        Full_benefit_detail_scholarship_detail.setOnClickListener(View -> gotUrl(Full_benefit_detail_guest_scholarship));

    }

}