package com.example.useaapp.STUDENT.Schedule;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.useaapp.R;
import com.example.useaapp.STUDENT.ApiController_student;
import com.example.useaapp.STUDENT.Home.Response_rank_credit;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentSchedule extends AppCompatActivity {
    private final static String SHARE_PREFNAME = "Student_Name";
    SharedPreferences sharedPreferences;
    Toolbar toolbar;
    List<ScheduleModel> ListSchedule;
    ListView Listview_student_schedule;
    Adpter_student_schedule adapter;
    String st_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_schedule);
        toolbar = findViewById(R.id.CustomActionbarStudentSchedule);
        setSupportActionBar(toolbar);
        setTitle(R.string.Schedule);
        toolbar.setNavigationOnClickListener(v -> finish());
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        sharedPreferences = getSharedPreferences(SHARE_PREFNAME, Context.MODE_PRIVATE);
        st_id = sharedPreferences.getString("Student_ID","");

        Listview_student_schedule = findViewById(R.id.Listview_student_schedule);
        ListSchedule = new ArrayList<>();


        getData();
    }

    private void getData() {
        Call<List<ScheduleModel>> call = ApiController_student.getInstance().getApiSchedule().getSchedule(st_id);
        call.enqueue(new Callback<List<ScheduleModel>>() {
            @Override
            public void onResponse(Call<List<ScheduleModel>> call, Response<List<ScheduleModel>> response) {
                if (response.isSuccessful()){
                    ListSchedule = response.body();
                    adapter = new Adpter_student_schedule(getApplicationContext(), ListSchedule);
                    Listview_student_schedule.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<ScheduleModel>> call, Throwable t) {

            }
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}