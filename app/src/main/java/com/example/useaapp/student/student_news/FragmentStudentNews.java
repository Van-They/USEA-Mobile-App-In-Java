package com.example.useaapp.student.student_news;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.useaapp.R;
import com.example.useaapp.student.student_adapter.ListAdapterNews;

import java.util.ArrayList;

public class FragmentStudentNews extends Fragment {
    ListView listView;
    ArrayList<ModelNews> listNews;
    ListAdapterNews adapterNews;
    ModelNews modelNews;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student_news, container, false);
        listView = view.findViewById(R.id.Listview_news);
        addItem();


        listView.setAdapter(new ListAdapterNews(view.getContext(), listNews));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "បានចុច -> " + listNews.get(position).getLabel(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private void addItem() {
        listNews = new ArrayList<>();
        listNews.add(new ModelNews("Java programing I", "20-08-2022", "01-09-2022", "6:00", "Preahkan", "Sa Sokngim", "Homework"));
        listNews.add(new ModelNews("Java programing II", "20-08-2022", "01-09-2022", "6:00", "Preahkan", "Sa Sokngim", "Assignment"));
        listNews.add(new ModelNews("Web Development", "20-08-2022", "01-09-2022", "6:00", "Preahkan", "Sa Sokngim", "Midterm"));
        listNews.add(new ModelNews("C Programing", "20-08-2022", "01-09-2022", "6:00", "Preahkan", "Sa Sokngim", "Homework"));
        listNews.add(new ModelNews("C++ Programing", "20-08-2022", "01-09-2022", "6:00", "Preahkan", "Sa Sokngim", "Assignment"));

    }
}