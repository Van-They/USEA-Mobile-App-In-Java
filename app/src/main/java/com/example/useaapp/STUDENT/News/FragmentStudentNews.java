package com.example.useaapp.STUDENT.News;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.useaapp.R;
import com.example.useaapp.STUDENT.Adapter.Adapter_news;

import java.util.ArrayList;

public class FragmentStudentNews extends Fragment {
    private final static String Subject = "Subject";
    private final static String Date = "Date";
    private final static String Due_Date = "Due_Date";
    private final static String Time = "Time";
    private final static String Room = "Room";
    private final static String Creator = "Creator";
    private final static String Label = "Label";
    private final static String Instruction = "Instruction";
    private final static String Score = "Score";
    ListView listView;
    ArrayList<ModelNews> listNews;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student_news, container, false);
        listView = view.findViewById(R.id.Listview_news);
        addItem();


        listView.setAdapter(new Adapter_news(view.getContext(), listNews));
        listView.setOnItemClickListener((parent, view1, position, id) -> {
            Toast.makeText(getContext(), "បានចុច -> " + listNews.get(position).getLabel(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getContext(), NewsItemsDetail.class);
            intent.putExtra(Subject, listNews.get(position).getSubject());
            intent.putExtra(Date, listNews.get(position).getDate());
            intent.putExtra(Due_Date, listNews.get(position).getDue_date());
            intent.putExtra(Time, listNews.get(position).getTime());
            intent.putExtra(Room, listNews.get(position).getRoom());
            intent.putExtra(Creator, listNews.get(position).getCreator());
            intent.putExtra(Label, listNews.get(position).getLabel());
            intent.putExtra(Instruction, listNews.get(position).getInstruction());
            intent.putExtra(Score, listNews.get(position).getScore());
            startActivity(intent);
        });

        return view;
    }

    private void addItem() {
        listNews = new ArrayList<>();
        listNews.add(new ModelNews("Java programing I", "", "២០-សីហា-២០២២", "៦:០០", "", "Sa Sokngim", "កិច្ចការផ្ទះ", "instruction", "50"));
        listNews.add(new ModelNews("Java programing II", "", "១០-សីហា-២០២២", "៦:០០", "", "Sa Sokngim", "ការងារក្រុម", "instruction", "50"));
        listNews.add(new ModelNews("Web Development", "២០-សីហា-២០២២", "", "៦:០០", "ប្រាសាទព្រះខ័ន", "Sa Sokngim", "ប្រឡងពាក់កណ្តាលឆមាស", "instruction", "50"));
        listNews.add(new ModelNews("C Programing", "", "១០-សីហា-២០២២", "៦:០០", "", "Sa Sokngim", "កិច្ចការផ្ទះ", "instruction", "50"));
        listNews.add(new ModelNews("C++ Programing", "", "១០-សីហា-២០២២", "៦:០០", "", "Sa Sokngim", "ការងារក្រុម", "instruction", "50"));

    }
}