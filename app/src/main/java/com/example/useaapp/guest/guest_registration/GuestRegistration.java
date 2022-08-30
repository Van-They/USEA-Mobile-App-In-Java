package com.example.useaapp.guest.guest_registration;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.example.useaapp.R;
import com.example.useaapp.guest.guest_adapter.RegistrationExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GuestRegistration extends AppCompatActivity {
    Toolbar toolbar;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String,List<String>> expandableListDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //       Start Action Bar
        setContentView(R.layout.activity_guest_registration);
        toolbar = findViewById(R.id.CustomActionbarGuestRegistration);
        setSupportActionBar(toolbar);
        setTitle(R.string.GuestRegistration);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        End Action Bar
        expandableListView = findViewById(R.id.expandableListView);

        expandableListDetail = RegistrationExpandableList.getData();

        expandableListTitle = new ArrayList<>(expandableListDetail.keySet());

        expandableListAdapter = new RegistrationExpandableListAdapter
                (this,expandableListTitle,expandableListDetail);

        expandableListView.setAdapter(expandableListAdapter);
    }
}