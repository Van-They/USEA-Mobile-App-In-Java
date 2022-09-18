package com.example.useaapp.guest.guest_scholarship;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.widget.ListView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.useaapp.R;
import com.example.useaapp.guest.guest_home.FragmentImageSlider;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GuestScholarship extends AppCompatActivity {
    Toolbar toolbar;
    ListView Listview_scholarship;
    ArrayList<ScholarshipModel> Data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//       Start Action Bar
        setContentView(R.layout.activity_guest_scholarship);
        toolbar = findViewById(R.id.CustomActionbarGuestScholarship);
        setSupportActionBar(toolbar);
        setTitle(R.string.Scholarship);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(view -> finish());
//        End Action Bar

        ImageSlider slide_image = findViewById(R.id.SlideImageScholarship);

        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.sale, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.store, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.students, ScaleTypes.FIT));
        slide_image.setImageList(slideModels, ScaleTypes.FIT);

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
        Data.add(new ScholarshipModel("Mathematics: Fully Funded Royal Society PhD" +
                " at Swansea: Molecular " +
                "Quantum Materials ","PhD","Full cost of UK tuition fees and an" +
                "annual stipend","3<sup>rd</sup>","March","2022"));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}