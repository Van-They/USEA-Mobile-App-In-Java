package com.example.useaapp.student.student_news;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.useaapp.R;

public class NewItemsDetail extends AppCompatActivity {
    TextView subject;
    String sub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_items_detail);

        subject = findViewById(R.id.txtsubject);
        sub = getIntent().getStringExtra("Subject");

        subject.setText(sub);

    }
}