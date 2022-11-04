package com.example.useaapp.GUEST.Program;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useaapp.Data_Progressing;
import com.example.useaapp.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GuestProgram extends AppCompatActivity {
    Toolbar toolbar;
    List<Response_model_guest_program_faculty> response_models;
    RecyclerView recycler_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_program);
        toolbar = findViewById(R.id.CustomActionbarGuestProgram);
        setSupportActionBar(toolbar);
        setTitle(R.string.Study_program);
        assert getSupportActionBar() !=null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> finish());
        toolbar.setNavigationOnClickListener(view -> finish());
        response_models = new ArrayList<>();
        recycler_view = findViewById(R.id.recview_guest_program_faculty);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));

        Process_data();

    }

    public void Process_data() {
        Data_Progressing dialog = new Data_Progressing(this);
        dialog.showDialog();
        Call<List<Response_model_guest_program_faculty>> call = ApiController_guest_program_faculty
                .getInstance()
                .getapi_fac()
                .get_guest_pro_fac();

        call.enqueue(new Callback<List<Response_model_guest_program_faculty>>() {
            @Override
            public void onResponse(Call<List<Response_model_guest_program_faculty>> call, Response<List<Response_model_guest_program_faculty>> response) {
                response_models = response.body();
                Adapter_guest_program_faculty adapter = new Adapter_guest_program_faculty(response_models, getApplicationContext());
                if (response_models != null && !response_models.isEmpty()) {
                    dialog.stopDialog();
                    recycler_view.setAdapter(adapter);
                } else {
                    Toast.makeText(GuestProgram.this, "No data found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Response_model_guest_program_faculty>> call, Throwable t) {
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