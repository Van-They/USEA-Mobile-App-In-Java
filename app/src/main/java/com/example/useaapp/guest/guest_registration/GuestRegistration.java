package com.example.useaapp.guest.guest_registration;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useaapp.R;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GuestRegistration extends AppCompatActivity {
    Toolbar toolbar;
    List<Response_model_guest_registration> response_models;
    RecyclerView recycler_view;
    ShimmerFrameLayout Shimmer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //       Start Action Bar
        setContentView(R.layout.activity_guest_registration);
        toolbar = findViewById(R.id.CustomActionbarGuestRegistration);
        setSupportActionBar(toolbar);
        setTitle(R.string.GuestRegistration);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v->finish());
        Shimmer = findViewById(R.id.custom_guest_shimmer_registration);
        Shimmer.startShimmer();
        response_models = new ArrayList<>();
        recycler_view = findViewById(R.id.registration_expandableListView);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));

        Process_data();

    }
    public void Process_data()
    {
        Call<List<Response_model_guest_registration>> call = ApiController_guest_registration
                .getInstance()
                .getapi()
                .getdata();

        call.enqueue(new Callback<List<Response_model_guest_registration>>() {
            @Override
            public void onResponse(Call<List<Response_model_guest_registration>> call, Response<List<Response_model_guest_registration>> response) {
                response_models = response.body();
                Adapter_guest_registration adapter = new Adapter_guest_registration(response_models);
                if (response_models !=null && !response_models.isEmpty()){
                    Shimmer.stopShimmer();
                    Shimmer.setVisibility(View.GONE);
                    recycler_view.setVisibility(View.VISIBLE);
                    recycler_view.setAdapter(adapter);
                }else {
                    Toast.makeText(GuestRegistration.this, "No data found", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<Response_model_guest_registration>> call, Throwable t) {
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