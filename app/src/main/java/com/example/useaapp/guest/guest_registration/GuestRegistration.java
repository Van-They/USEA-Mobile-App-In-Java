package com.example.useaapp.guest.guest_registration;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;
import com.example.useaapp.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GuestRegistration extends AppCompatActivity {
    Toolbar toolbar;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String,List<String>> expandableListDetail;
    List<Response_model_guest_registration> responsemodels;
    RecyclerView recview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //       Start Action Bar
        setContentView(R.layout.activity_guest_registration);
        toolbar = findViewById(R.id.CustomActionbarGuestRegistration);
        setSupportActionBar(toolbar);
        setTitle(R.string.GuestRegistration);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        responsemodels = new ArrayList<Response_model_guest_registration>();
        recview = findViewById(R.id.expandableListView);
        recview.setLayoutManager(new LinearLayoutManager(this));

        processdata();

    }
    public void processdata()
    {
        Call<List<Response_model_guest_registration>> call = ApiController_guest_registration
                .getInstance()
                .getapi()
                .getdata();

        call.enqueue(new Callback<List<Response_model_guest_registration>>() {
            @Override
            public void onResponse(Call<List<Response_model_guest_registration>> call, Response<List<Response_model_guest_registration>> response) {
                responsemodels = response.body();
                Myadapter_guest_registration myadapter = new Myadapter_guest_registration(responsemodels);
                if (responsemodels !=null && !responsemodels.isEmpty()){
                    recview.setAdapter(myadapter);
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
}