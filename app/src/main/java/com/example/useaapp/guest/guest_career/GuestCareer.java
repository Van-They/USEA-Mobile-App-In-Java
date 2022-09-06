package com.example.useaapp.guest.guest_career;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.useaapp.R;
import com.example.useaapp.guest.guest_scholarship.Adapter_guest_scholarship;
import com.example.useaapp.guest.guest_scholarship.ScholarshipModel;

import java.util.ArrayList;

public class GuestCareer extends AppCompatActivity {
    Toolbar toolbar;
    ArrayList<GuestCareerModel> data;
    ListView listView_career;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //       Start Action Bar
        setContentView(R.layout.activity_guest_career);
        toolbar = findViewById(R.id.CustomActionbarGuestCareer);
        setSupportActionBar(toolbar);
        setTitle(R.string.Career);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v->finish());
//        End Action Bar
        listView_career = findViewById(R.id.Listview_guest_career);
        addData();
        listView_career.setAdapter(new Adapter_guest_career(getApplicationContext(),data));
    }
    private void addData(){
        data = new ArrayList<>();
        data.add(new GuestCareerModel("Admin Operation Officer","Administration", "រាជធានីភ្នំពេញ", "កុម្ភៈ", "១២", "២០២២"));
        data.add(new GuestCareerModel("Human Resource","Human Resource Management", "បន្ទាយមានជ័យ", "សីហា", "២១", "២០២២"));

    }
}
