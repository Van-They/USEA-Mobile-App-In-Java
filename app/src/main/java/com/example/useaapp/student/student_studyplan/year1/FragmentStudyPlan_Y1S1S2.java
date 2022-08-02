package com.example.useaapp.student.student_studyplan.year1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.useaapp.R;
import com.example.useaapp.student.student_adapter.ListviewHelper;

import java.util.ArrayList;

public class FragmentStudyPlan_Y1S1S2 extends Fragment {

    ListView listView_s1,listView_s2;
    ArrayList<Semester> semester1,semester2;
    Semester semester;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_study_plan__y1s1s2, container, false);
        listView_s1 = view.findViewById(R.id.student_study_plan_list_s1);
        listView_s2 = view.findViewById(R.id.student_study_plan_list_s2);

        //semester 1,2 listview with array list
        addDataToListS1();
        addDataToListS2();

        //calculate total hour
        //setAdapter
        listView_s1.setAdapter(new Adapter_semester1(getContext(),semester1));
        ListviewHelper.getLisViewSize(listView_s1);
        listView_s2.setAdapter(new Adapter_semester2(getContext(),semester2));
        ListviewHelper.getLisViewSize(listView_s2);
        return view;
    }

    private void addDataToListS2() {
        semester2 = new ArrayList<>();
       semester2.add(new Semester("1.","សេដ្ឋកិច្ចវិទ្យា","45","3"));
       semester2.add(new Semester("2.","ប្រវត្តិ និងវប្បធម៍អាស៊ីអាគ្នេយ៍","45","3"));
       semester2.add(new Semester("3.","រដ្ឋបាយសាធារណៈ","45","3"));
       semester2.add(new Semester("4.","កុំព្យូទ័រសម្រាប់រដ្ខបាល","45","3"));
       semester2.add(new Semester("5.","ភាសាអង់គ្លេស","45","3"));
       semester2.add(new Semester("6.","ភាសាចិន","45","0"));
    }

    private void addDataToListS1() {
        semester1 = new ArrayList<>();
        semester1.add(new Semester("1.","សេដ្ឋកិច្ចវិទ្យា","45","3"));
        semester1.add(new Semester("2.","ប្រវត្តិ និងវប្បធម៍អាស៊ីអាគ្នេយ៍","45","3"));
        semester1.add(new Semester("3.","រដ្ឋបាយសាធារណៈ","45","3"));
        semester1.add(new Semester("4.","កុំព្យូទ័រសម្រាប់រដ្ខបាល","45","3"));
        semester1.add(new Semester("5.","ភាសាអង់គ្លេស","45","3"));
        semester1.add(new Semester("6.","ភាសាចិន","45","0"));
    }
}