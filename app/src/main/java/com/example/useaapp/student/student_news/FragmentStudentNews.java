package com.example.useaapp.student.student_news;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.useaapp.R;
import com.example.useaapp.student.student_adapter.ListAdapterNews;

import java.util.ArrayList;

public class FragmentStudentNews extends Fragment {
    ListView listView;
    ArrayList<ModelNews> modelNews;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student_news, container, false);

        listView = view.findViewById(R.id.Listview_news);
        addItem();
        listView.setAdapter(new ListAdapterNews(getContext(),modelNews));
        return view;
    }
    private void addItem() {
        modelNews = new ArrayList<>();
        modelNews.add(new ModelNews("Java programing I","20-08-2022","01-09-2022","6:00","Preahkan","Sa Sokngim","Homework"));
        modelNews.add(new ModelNews("Java programing II","20-08-2022","01-09-2022","6:00","Preahkan","Sa Sokngim","Assignment"));
        modelNews.add(new ModelNews("Web Development","20-08-2022","01-09-2022","6:00","Preahkan","Sa Sokngim","Midterm"));
        modelNews.add(new ModelNews("C Programing","20-08-2022","01-09-2022","6:00","Preahkan","Sa Sokngim","Homework"));
        modelNews.add(new ModelNews("C++ Prorgraming","20-08-2022","01-09-2022","6:00","Preahkan","Sa Sokngim","Assignment"));

    }
}