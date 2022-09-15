package com.example.useaapp.student.student_news;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.useaapp.R;

import java.util.Objects;

public class NewsItemsDetail extends AppCompatActivity {
    TextView subject, label, room, date, due_date, creator, time, download_file_label_news, label_date_item_news,label_time_news,text_instruction;
    String subject_, label_, room_, date_, due_date_, creator_, time_,instruction_;
    LinearLayout download_layout,label_layout_room_news;
    private final static String Subject = "Subject";
    private final static String Date = "Date";
    private final static String Due_Date = "Due_Date";
    private final static String Time = "Time";
    private final static String Room = "Room";
    private final static String Creator = "Creator";
    private final static String Label = "Label";
    private final static String Instruction = "Instruction";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_items_detail);
        Toolbar toolbar = findViewById(R.id.CustomActionbarStudentNewsDetail);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(v-> finish());

        subject = findViewById(R.id.subject);
        label = findViewById(R.id.label);
        room = findViewById(R.id.room);
        date = findViewById(R.id.date);
        due_date = findViewById(R.id.due_date);
        creator = findViewById(R.id.creator);
        time = findViewById(R.id.time);
        download_layout = findViewById(R.id.download_file_layout_news);
        download_file_label_news = findViewById(R.id.download_file_label_news);
        label_date_item_news = findViewById(R.id.label_date_item_news);
        label_layout_room_news = findViewById(R.id.label_layout_room_news);
        label_time_news = findViewById(R.id.label_time_news);
        text_instruction = findViewById(R.id.text_instruction);
        getString();
        setTitle(label_);
        setString();

        switch (label_) {
            case "កិច្ចការផ្ទះ":
                label.setBackgroundResource(R.color.blue_sky_40);
                download_file_label_news.setText(label_);
                label_date_item_news.setText(R.string.Due_Date);
                date.setVisibility(View.GONE);
                label_layout_room_news.setVisibility(View.GONE);
                break;
            case "ការងារក្រុម":
                label.setBackgroundResource(R.color.yellow_40);
                download_file_label_news.setText(label_);
                label_date_item_news.setText(R.string.Due_Date);
                date.setVisibility(View.GONE);
                label_layout_room_news.setVisibility(View.GONE);
                break;
            case "ប្រឡងពាក់កណ្តាលឆមាស":
                label.setBackgroundResource(R.color.pink_40);
                label_date_item_news.setText(R.string.Exam_date);
                label_time_news.setText(R.string.Start_time);
                download_layout.setVisibility(View.GONE);
                break;
        }
    }

    private void getString() {
        subject_ = getIntent().getStringExtra(Subject);
        label_ = getIntent().getStringExtra(Label);
        room_ = getIntent().getStringExtra(Room);
        date_ = getIntent().getStringExtra(Date);
        due_date_ = getIntent().getStringExtra(Due_Date);
        creator_ = getIntent().getStringExtra(Creator);
        time_ = getIntent().getStringExtra(Time);
        instruction_ = getIntent().getStringExtra(Instruction);
    }

    private void setString() {
        subject.setText(subject_);
        label.setText(label_);
        room.setText(room_);
        date.setText(date_);
        due_date.setText(due_date_);
        creator.setText(creator_);
        time.setText(time_);
        text_instruction.setText(instruction_);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}