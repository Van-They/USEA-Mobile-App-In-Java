package com.example.useaapp.GUEST.More.about_us;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useaapp.Data_Progressing;
import com.example.useaapp.R;

import java.util.List;

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
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(view -> finish());

        recycler_view = findViewById(R.id.about_us_recview);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));

        processdata();
    }

    public void processdata() {
        Data_Progressing loading = new Data_Progressing(this);
        loading.showDialog();
        Call<List<Response_model_guest_about_us_more>> call = ApiController_guest_about_us_more.getInstance().getApi().getData();
        call.enqueue(new Callback<List<Response_model_guest_about_us_more>>() {
            @Override
            public void onResponse(Call<List<Response_model_guest_about_us_more>> call, Response<List<Response_model_guest_about_us_more>> response) {
                responsemodels = response.body();
                Adapter_guest_about_us_more adapter = new Adapter_guest_about_us_more(responsemodels);
                if (responsemodels != null && !responsemodels.isEmpty()) {
                    loading.stopDialog();
                    recycler_view.setAdapter(adapter);
                } else {
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