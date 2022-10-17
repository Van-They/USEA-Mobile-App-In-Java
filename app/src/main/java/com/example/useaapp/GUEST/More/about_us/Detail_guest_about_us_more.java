package com.example.useaapp.GUEST.More.about_us;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.useaapp.R;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Detail_guest_about_us_more extends AppCompatActivity {
    Toolbar toolbar;
    List<Response_model_guest_about_us_more> responsemodels;
    RecyclerView recycler_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_guest_about_us_more);

        toolbar = findViewById(R.id.CustomActionbarGuestAboutUsDetail);
        setSupportActionBar(toolbar);
        setTitle(R.string.About_Us);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(view -> finish());

        recycler_view = findViewById(R.id.about_us_recview);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));

        processdata();
    }
    public void processdata()
    {
        Call<List<Response_model_guest_about_us_more>> call = ApiController_guest_about_us_more
                .getInstance()
                .getApi()
                .getData();

        call.enqueue(new Callback<List<Response_model_guest_about_us_more>>() {
            @Override
            public void onResponse(Call<List<com.example.useaapp.GUEST.More.about_us.Response_model_guest_about_us_more>> call, Response<List<Response_model_guest_about_us_more>> response) {
                responsemodels = response.body();
                com.example.useaapp.GUEST.More.about_us.Adapter_guest_about_us_more adapter = new com.example.useaapp.GUEST.More.about_us.Adapter_guest_about_us_more(responsemodels);
                if (responsemodels !=null && !responsemodels.isEmpty()){
                    recycler_view.setAdapter(adapter);
                }else {
                    Toast.makeText(Detail_guest_about_us_more.this, "No data found", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<com.example.useaapp.GUEST.More.about_us.Response_model_guest_about_us_more>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}