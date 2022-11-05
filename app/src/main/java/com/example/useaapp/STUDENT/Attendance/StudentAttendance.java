package com.example.useaapp.STUDENT.Attendance;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useaapp.Data_Progressing;
import com.example.useaapp.R;
import com.example.useaapp.STUDENT.Adapter.Adapter_attendance;
import com.example.useaapp.STUDENT.ApiController_student;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentAttendance extends AppCompatActivity {

    private final static String SHARE_PREFNAME = "Student_Name";
    SharedPreferences sharedPreferences;
    String St_id;

    Toolbar toolbar;
    List<Response_model_student_attendance> responsemodels;
    RecyclerView recview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_attendance);
        toolbar = findViewById(R.id.CustomActionbarStudentAttendance);
        setSupportActionBar(toolbar);
        setTitle(R.string.Attendance);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(view -> finish());
        responsemodels = new ArrayList<>();
        recview = findViewById(R.id.attendance_item_view);
        recview.setLayoutManager(new LinearLayoutManager(this));

        sharedPreferences = getSharedPreferences(SHARE_PREFNAME, Context.MODE_PRIVATE);
        St_id = sharedPreferences.getString("Student_ID", "");

        processdata();
    }

    public void processdata() {
        Data_Progressing loading = new Data_Progressing(this);
        loading.showDialog();
        Call<List<Response_model_student_attendance>> call = ApiController_student
                .getInstance()
                .getapi_stu_att()
                .get_stu_att(St_id);

        call.enqueue(new Callback<List<Response_model_student_attendance>>() {
            @Override
            public void onResponse(Call<List<Response_model_student_attendance>> call, Response<List<Response_model_student_attendance>> response) {
                responsemodels = response.body();
                Adapter_attendance myadapter = new Adapter_attendance(responsemodels);
                if (responsemodels != null && !responsemodels.isEmpty()) {
                    loading.stopDialog();
                    recview.setAdapter(myadapter);
                } else {
                    Toast.makeText(StudentAttendance.this, "No data found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Response_model_student_attendance>> call, Throwable t) {
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