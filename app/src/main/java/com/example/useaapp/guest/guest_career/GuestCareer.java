package com.example.useaapp.guest.guest_career;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useaapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GuestCareer extends AppCompatActivity {
    Toolbar toolbar;
    List<com.example.useaapp.guest.guest_career.Response_model_guest_career> responsemodels;
    RecyclerView recview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_career);
        toolbar = findViewById(R.id.CustomActionbarGuestCareer);
        setSupportActionBar(toolbar);
        setTitle(R.string.Career);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(view -> finish());
        responsemodels = new ArrayList<com.example.useaapp.guest.guest_career.Response_model_guest_career>();

        recview = findViewById(R.id.recview_guest_career);
        recview.setLayoutManager(new LinearLayoutManager(this));

        processdata();
    }

    public void processdata()
    {
        Call<List<com.example.useaapp.guest.guest_career.Response_model_guest_career>> call = com.example.useaapp.guest.guest_career.ApiController_guest_career
                .getInstance()
                .getapi()
                .getdata();

        call.enqueue(new Callback<List<com.example.useaapp.guest.guest_career.Response_model_guest_career>>() {
            @Override
            public void onResponse(Call<List<com.example.useaapp.guest.guest_career.Response_model_guest_career>> call, Response<List<com.example.useaapp.guest.guest_career.Response_model_guest_career>> response) {
                responsemodels = response.body();
                com.example.useaapp.guest.guest_career.Adapter_guest_career myadapter = new com.example.useaapp.guest.guest_career.Adapter_guest_career(responsemodels, getApplicationContext());
                if (responsemodels !=null && !responsemodels.isEmpty()){
                    recview.setAdapter(myadapter);
                }else {
                    Toast.makeText(GuestCareer.this, "No data found", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<com.example.useaapp.guest.guest_career.Response_model_guest_career>> call, Throwable t) {
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