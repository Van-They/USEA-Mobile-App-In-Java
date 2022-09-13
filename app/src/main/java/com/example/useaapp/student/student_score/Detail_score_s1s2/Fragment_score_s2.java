package com.example.useaapp.student.student_score.Detail_score_s1s2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.useaapp.R;

import java.util.ArrayList;

public class Fragment_score_s2 extends Fragment {
    ArrayList<ModelDetail> model;
    ListView Listview_student_score_detail_s2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_score_s2, container, false);
        Listview_student_score_detail_s2 = v.findViewById(R.id.Listview_student_score_detail_s2);
        addData();
        Listview_student_score_detail_s2.setAdapter(new Adapter_score_detail(v.getContext(),model));
        return v;
    }
    void addData(){
        model = new ArrayList<>();
        model.add(new ModelDetail(
                "Java Programing II",
                "10",
                "100",
                "500",
                "200",
                "50",
                "70",
                "600",
                "A",
                "50.0",
                "1")
        );
        model.add(new ModelDetail(
                "Data Structure",
                "10",
                "100",
                "500",
                "200",
                "50",
                "70",
                "600",
                "A",
                "50.0",
                "1")
        );
        model.add(new ModelDetail(
                "Research Methodology",
                "10",
                "100",
                "500",
                "200",
                "50",
                "70",
                "600",
                "A",
                "50.0",
                "1")
        );
    }
}