package com.example.useaapp.guest.guest_scholarship;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.useaapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GuestScholarship extends AppCompatActivity {
    Toolbar toolbar;
    List<com.example.useaapp.guest.guest_scholarship.Response_model_guest_scholarship> responsemodels;
    RecyclerView recview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_scholarship);
        toolbar = findViewById(R.id.CustomActionbarGuestScholarship);
        setSupportActionBar(toolbar);
        setTitle(R.string.Scholarship);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(view -> finish());
        getSupportFragmentManager().beginTransaction().replace(R.id.ImageSliderGuestScholarship, new FragmentImageSlider()).commit();
        responsemodels = new ArrayList<com.example.useaapp.guest.guest_scholarship.Response_model_guest_scholarship>();

        recview = findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        processdata();
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

    public void processdata()
    {
        Call<List<com.example.useaapp.guest.guest_scholarship.Response_model_guest_scholarship>> call = ApiController_guest_scholarship
                .getInstance()
                .getapi()
                .getdata();

        call.enqueue(new Callback<List<com.example.useaapp.guest.guest_scholarship.Response_model_guest_scholarship>>() {
            @Override
            public void onResponse(Call<List<com.example.useaapp.guest.guest_scholarship.Response_model_guest_scholarship>> call, Response<List<com.example.useaapp.guest.guest_scholarship.Response_model_guest_scholarship>> response) {
                responsemodels = response.body();
                com.example.useaapp.guest.guest_scholarship.Adapter_guest_scholarship myadapter = new com.example.useaapp.guest.guest_scholarship.Adapter_guest_scholarship(responsemodels, getApplicationContext());
                if (responsemodels !=null && !responsemodels.isEmpty()){
                    recview.setAdapter(myadapter);
                }else {
                    Toast.makeText(GuestScholarship.this, "No data found", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<com.example.useaapp.guest.guest_scholarship.Response_model_guest_scholarship>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}