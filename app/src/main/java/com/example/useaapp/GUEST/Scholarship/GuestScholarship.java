package com.example.useaapp.GUEST.Scholarship;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.useaapp.Data_Progressing;
import com.example.useaapp.GUEST.ApiController_guest;
import com.example.useaapp.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GuestScholarship extends AppCompatActivity {
    Toolbar toolbar;
    List<com.example.useaapp.GUEST.Scholarship.Response_model_guest_scholarship> responsemodels;
    RecyclerView recview;
    ImageSlider slide_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_scholarship);
        toolbar = findViewById(R.id.CustomActionbarGuestScholarship);
        setSupportActionBar(toolbar);
        setTitle(R.string.Scholarship);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(view -> finish());

        slide_image = findViewById(R.id.SlideImageScholarship);
        slide_image.setVisibility(View.GONE);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.d, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.c, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.i, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.h, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.j, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.k, ScaleTypes.FIT));
        slide_image.setImageList(slideModels, ScaleTypes.FIT);
        responsemodels = new ArrayList<>();

        recview = findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        processdata();
    }

    public void processdata() {
        Data_Progressing loading = new Data_Progressing(this);
        loading.showDialog();
        Call<List<Response_model_guest_scholarship>> call = ApiController_guest
                .getInstance()
                .getapi_scholarship()
                .getdata_scholarship();

        call.enqueue(new Callback<List<Response_model_guest_scholarship>>() {
            @Override
            public void onResponse(Call<List<Response_model_guest_scholarship>> call, Response<List<Response_model_guest_scholarship>> response) {
                responsemodels = response.body();
                Adapter_guest_scholarship myadapter = new Adapter_guest_scholarship(responsemodels, getApplicationContext());
                if (responsemodels != null && !responsemodels.isEmpty()) {
                    loading.stopDialog();
                    slide_image.setVisibility(View.VISIBLE);
                    recview.setAdapter(myadapter);
                } else {
                    slide_image.setVisibility(View.VISIBLE);
                    loading.stopDialog();
                }
            }

            @Override
            public void onFailure(Call<List<Response_model_guest_scholarship>> call, Throwable t) {
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}