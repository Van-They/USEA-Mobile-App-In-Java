package com.example.useaapp.GUEST.Registration;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useaapp.Data_Progressing;
import com.example.useaapp.R;

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
        response_models = new ArrayList<>();
        recycler_view = findViewById(R.id.registration_expandableListView);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));


        Process_data();

    }
    public void Process_data()
    {
        Data_Progressing dialog = new Data_Progressing(this);
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
                    dialog.stopDialog();
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