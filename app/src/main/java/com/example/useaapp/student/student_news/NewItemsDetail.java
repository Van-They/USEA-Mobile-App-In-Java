package com.example.useaapp.student.student_news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.TextView;

import com.example.useaapp.R;

public class NewItemsDetail extends AppCompatActivity {
    TextView subject, label, room, date, due_date, creator, time;
    String subject_, label_, room_, date_, due_date_, creator_, time_;
    private final static String Subject ="Subject";
    private final static String Date ="Date";
    private final static String Due_Date ="Due_Date";
    private final static String Time ="Time";
    private final static String Room ="Room";
    private final static String Creator ="Creator";
    private final static String Label ="Label";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_items_detail);
        Toolbar toolbar = findViewById(R.id.CustomActionbarStudentNewsDetail);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        subject = findViewById(R.id.subject);
        label = findViewById(R.id.label);
        room = findViewById(R.id.room);
        date = findViewById(R.id.date);
        due_date = findViewById(R.id.due_date);
        creator = findViewById(R.id.creator);
        time = findViewById(R.id.time);

        subject_=getIntent().getStringExtra(Subject).toString();
        label_=getIntent().getStringExtra(Label).toString();
        room_=getIntent().getStringExtra(Room).toString();
        date_=getIntent().getStringExtra(Date).toString();
        due_date_=getIntent().getStringExtra(Due_Date).toString();
        creator_=getIntent().getStringExtra(Creator).toString();
        time_=getIntent().getStringExtra(Time).toString();

        subject.setText(subject_);
        label.setText(label_);
        room.setText(room_);
        date.setText(date_);
        due_date.setText(due_date_);
        creator.setText(creator_);
        time.setText(time_);

    }
}