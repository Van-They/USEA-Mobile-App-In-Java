package com.example.useaapp.student.student_news;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.useaapp.R;
import com.example.useaapp.student.student_adapter.Adapter_news;

import java.util.ArrayList;
import java.util.List;

public class FragmentStudentNews extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student_news, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_news);
        List<Model> models = new ArrayList<>();

        //viewType  1=assignment, 2=homework, 3=midterm

        models.add(new Model(1, new Assignment("Java Programing I", "20-June-2022", "Sa Sok Ngim")));
        models.add(new Model(2, new Homework("Java Programing II", "25-June-2022", "Sa Sok Ngim")));
        models.add(new Model(3, new Midterm("Data Structure", "25-June-2022", "6:00pm to 8:00pm", "Preah Khan")));

        models.add(new Model(1, new Assignment("Java Programing I", "20-June-2022", "Sa Sok Ngim")));
        models.add(new Model(2, new Homework("Java Programing II", "25-June-2022", "Sa Sok Ngim")));
        models.add(new Model(3, new Midterm("Data Structure", "25-June-2022", "6:00pm to 8:00pm", "Preah Khan")));
        models.add(new Model(1, new Assignment("Java Programing I", "20-June-2022", "Sa Sok Ngim")));
        models.add(new Model(2, new Homework("Java Programing II", "25-June-2022", "Sa Sok Ngim")));
        models.add(new Model(3, new Midterm("Data Structure", "25-June-2022", "6:00pm to 8:00pm", "Preah Khan")));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new Adapter_news(models));
        return view;
    }
}