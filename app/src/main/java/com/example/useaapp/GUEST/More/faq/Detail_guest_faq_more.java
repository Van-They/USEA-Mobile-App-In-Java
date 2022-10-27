package com.example.useaapp.GUEST.More.faq;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useaapp.Data_Progressing;
import com.example.useaapp.R;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Detail_guest_faq_more extends AppCompatActivity {
    Toolbar toolbar;
    List<Response_model_guest_faq_more> response_models;
    RecyclerView recycler_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_guest_faq_more);
        toolbar = findViewById(R.id.CustomActionbarGuestMoreDetail);
        setSupportActionBar(toolbar);
        setTitle(R.string.FAQ);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(view -> finish());
        recycler_view = findViewById(R.id.faq_expandableListView);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));

        Process_data();
    }

    public void Process_data()
    {
        Data_Progressing loading = new Data_Progressing(this);
        loading.showDialog();
        Call<List<Response_model_guest_faq_more>> call = ApiController_guest_faq_more
                .getInstance()
                .getApi()
                .getData();

        call.enqueue(new Callback<List<Response_model_guest_faq_more>>() {
            @Override
            public void onResponse(Call<List<Response_model_guest_faq_more>> call, Response<List<Response_model_guest_faq_more>> response) {
                response_models = response.body();
                Adapter_guest_faq_more adapter = new Adapter_guest_faq_more(response_models);
                if (response_models !=null && !response_models.isEmpty()){
                    loading.stopDialog();
                    recycler_view.setAdapter(adapter);
                }else {
                    Toast.makeText(Detail_guest_faq_more.this, "No data found", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<Response_model_guest_faq_more>> call, Throwable t) {
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