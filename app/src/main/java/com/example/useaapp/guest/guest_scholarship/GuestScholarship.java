package com.example.useaapp.guest.guest_scholarship;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.useaapp.R;
import com.example.useaapp.guest.guest_home.FragmentImageSlider;

import java.util.ArrayList;
import java.util.List;

public class GuestScholarship extends AppCompatActivity {
    Toolbar toolbar;
    ListView Listview_scholarship;
    ArrayList<ScholarshipModel> Data;
    Button ReadDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//       Start Action Bar
        setContentView(R.layout.activity_guest_scholarship);
        toolbar = findViewById(R.id.CustomActionbarGuestScholarship);
        setSupportActionBar(toolbar);
        setTitle(R.string.Scholarship);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        End Action Bar

        getSupportFragmentManager().beginTransaction().replace(R.id.ImageSliderGuestScholarship,new FragmentImageSlider()).commit();
        Listview_scholarship = findViewById(R.id.Listview_guest_scholarship);
        addData();
        Listview_scholarship.setAdapter(new Adapter_guest_scholarship(getApplicationContext(),Data));
    }
    private void addData(){
        Data = new ArrayList<>();
        Data.add(new ScholarshipModel("Chemistry: Fully Funded Royal Society PhD" +
                " at Swansea: Molecular " +
                "Quantum Materials ","PhD","Full cost of UK tuition fees and an" +
                "annual stipend","2<sup>nd</sup>","March","2022"));
        Data.add(new ScholarshipModel("Physical: Fully Funded Royal Society PhD" +
                " at Swansea: Molecular " +
                "Quantum Materials ","PhD","Full cost of UK tuition fees and an" +
                "annual stipend","3<sup>rd</sup>","March","2022"));
        Data.add(new ScholarshipModel("Mathemathic: Fully Funded Royal Society PhD" +
                " at Swansea: Molecular " +
                "Quantum Materials ","PhD","Full cost of UK tuition fees and an" +
                "annual stipend","3<sup>rd</sup>","March","2022"));
    }

}