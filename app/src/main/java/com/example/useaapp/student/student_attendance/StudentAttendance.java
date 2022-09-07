package com.example.useaapp.student.student_attendance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.useaapp.R;
import com.example.useaapp.student.student_adapter.Adapter_attendance;

import java.util.ArrayList;

public class StudentAttendance extends AppCompatActivity {
    RecyclerView recyclerView;
    Adapter_attendance adapter_attendance;
    ArrayList<String> subject,hour,permission,absent,come;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_attendance);
        Toolbar toolbar = findViewById(R.id.CustomActionbarStudentAttendance);
        setSupportActionBar(toolbar);
        setTitle(R.string.Attendance);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(view -> finish());
        addData();
        setView();
    }
    private void addData() {
        //add subject, hour, permission, absent
        subject = new ArrayList<>();
        hour = new ArrayList<>();
        permission = new ArrayList<>();
        absent = new ArrayList<>();
        come = new ArrayList<>();
        subject.add("Microeconomic");
        hour.add("45");
        permission.add("5");
        absent.add("1");
        come.add("10");

        subject.add("History and Culture of South-East Asia");
        hour.add("45");
        permission.add("0");
        absent.add("2");
        come.add("9");

        subject.add("Public Administrator");
        hour.add("45");
        permission.add("5");
        absent.add("1");
        come.add("5");
    }
    private void setView() {
        recyclerView = findViewById(R.id.attendance_item_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter_attendance = new Adapter_attendance(subject, hour, permission, absent,come);
        recyclerView.setAdapter(adapter_attendance);
    }
}