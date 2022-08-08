package com.example.useaapp.student.student_score.year1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.useaapp.R;
import com.example.useaapp.student.student_adapter.ListviewHelper;
import com.example.useaapp.student.student_score.ModelScore;
import com.example.useaapp.student.student_score.ScoreDetail;

import java.util.ArrayList;

public class FragmentStudentScore_Y1S1S2 extends Fragment {

    ListView List_Score_Y1S1,List_Score_Y1S2;
    View Show_Detail_Y1S1,Show_Detail_Y1S2;
    ArrayList<ModelScore> Semester1,Semester2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student_score__y1_s1_s2, container, false);

        List_Score_Y1S1 = view.findViewById(R.id.student_score_list_y1s1);
        List_Score_Y1S2 = view.findViewById(R.id.student_score_list_y1s2);

        Show_Detail_Y1S1 = view.findViewById(R.id.student_score_show_detail_y1s1);
        Show_Detail_Y1S2 = view.findViewById(R.id.student_score_show_detail_y1s2);
        Show_Detail_Y1S1.setOnClickListener(v-> startActivity(new Intent(getContext(),ScoreDetail.class)));

        addDataList1();
        addDataList2();
        List_Score_Y1S1.setAdapter(new Adapter_Score_Semester(view.getContext(), Semester1));
        ListviewHelper.getLisViewSize(List_Score_Y1S1);
        List_Score_Y1S2.setAdapter(new Adapter_Score_Semester(view.getContext(), Semester2));
        ListviewHelper.getLisViewSize(List_Score_Y1S2);
        return view;
    }

    private void addDataList1() {
        Semester1 = new ArrayList<>();
        Semester1.add(new ModelScore("Java Programing I","#1","A","600"));
        Semester1.add(new ModelScore("Java Programing","#2","B","500"));
        Semester1.add(new ModelScore("Java Programing","#3","C","400"));
        Semester1.add(new ModelScore("Java Programing","#4","D","300"));
        Semester1.add(new ModelScore("Java Programing","#5","E","200"));
    }
    private void addDataList2() {
        Semester2 = new ArrayList<>();
        Semester2.add(new ModelScore("Java Programing II","#1","A","600"));
        Semester2.add(new ModelScore("Java Programing","#2","B","500"));
        Semester2.add(new ModelScore("Java Programing","#3","C","400"));
        Semester2.add(new ModelScore("Java Programing","#4","D","300"));
        Semester2.add(new ModelScore("Java Programing","#5","E","200"));
    }


}