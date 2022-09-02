package com.example.useaapp.guest.guest_program;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.useaapp.R;

import java.util.ArrayList;

public class GuestProgram extends AppCompatActivity {

    Toolbar toolbar;
    ListView program_list_view;
    ArrayList<ProgramModel> models;
    LinearLayout Social_law, Economy_tourism, Science_technology, Psychology_education, Foreign_language;
    LinearLayout Guest_program_parent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_program);
        toolbar = findViewById(R.id.CustomActionbarGuestProgram);
        setSupportActionBar(toolbar);
        setTitle(R.string.Guest_Program);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        program_list_view = findViewById(R.id.Guest_program_list_view);
        Social_law = findViewById(R.id.Social_Law);
        Economy_tourism = findViewById(R.id.Economy_Tourism);
        Science_technology = findViewById(R.id.Science_technology);
        Psychology_education = findViewById(R.id.Psychology_education);
        Foreign_language = findViewById(R.id.Foreign_language);
        Guest_program_parent = findViewById(R.id.Guest_program_parent);

        Social_law.setOnClickListener(v->{
            Social_Law_Data();
            toolbar.setTitle(R.string.Social_law);
            program_list_view.setAdapter(new Adapter_guest_program(getApplicationContext(),models));
            startActivity(new Intent(GuestProgram.this,ProgramItemsDetail.class));
        });
        Economy_tourism.setOnClickListener(v->{
            Economy_Tourism_Data();
            program_list_view.setAdapter(new Adapter_guest_program(getApplicationContext(),models));
            toolbar.setTitle(R.string.Social_law);
            Guest_program_parent.setVisibility(View.GONE);
            program_list_view.setVisibility(View.VISIBLE);
        });
        Science_technology.setOnClickListener(v->{
            Science_technology_Data();
            program_list_view.setAdapter(new Adapter_guest_program(getApplicationContext(),models));
            toolbar.setTitle(R.string.Social_law);
            Guest_program_parent.setVisibility(View.GONE);
            program_list_view.setVisibility(View.VISIBLE);
        });




    }
    private void Social_Law_Data() {
        models = new ArrayList<>();
        models.add(new ProgramModel("ហិរញ្ញវត្ថុ និងធនាគារ","១៥","២៧០","Associative"));
        models.add(new ProgramModel("គ្រប់គ្រង","១៥","២៧០","Bachelor"));
        models.add(new ProgramModel("គ្រប់គ្រង","១៥","២៧០","Master"));
    }
    private void Economy_Tourism_Data() {
        models = new ArrayList<>();
        models.add(new ProgramModel("ហិរញ្ញវត្ថុ និងធនាគារ","១៥","២៧០","Associative"));
        models.add(new ProgramModel("គ្រប់គ្រង","១៥","២៧០","Bachelor"));
        models.add(new ProgramModel("គ្រប់គ្រង","១៥","២៧០","Master"));
    }
    private void Science_technology_Data() {
        models = new ArrayList<>();
        models.add(new ProgramModel("ហិរញ្ញវត្ថុ និងធនាគារ","១៥","២៧០","Associative"));
        models.add(new ProgramModel("គ្រប់គ្រង","១៥","២៧០","Bachelor"));
        models.add(new ProgramModel("គ្រប់គ្រង","១៥","២៧០","Master"));
    }
    private void Psychology_education_Data() {
        models = new ArrayList<>();
        models.add(new ProgramModel("ហិរញ្ញវត្ថុ និងធនាគារ","១៥","២៧០","Associative"));
        models.add(new ProgramModel("គ្រប់គ្រង","១៥","២៧០","Bachelor"));
        models.add(new ProgramModel("គ្រប់គ្រង","១៥","២៧០","Master"));
    }
    private void Foreign_language_Data() {
        models = new ArrayList<>();
        models.add(new ProgramModel("ហិរញ្ញវត្ថុ និងធនាគារ","១៥","២៧០","Associative"));
        models.add(new ProgramModel("គ្រប់គ្រង","១៥","២៧០","Bachelor"));
        models.add(new ProgramModel("គ្រប់គ្រង","១៥","២៧០","Master"));
    }
}