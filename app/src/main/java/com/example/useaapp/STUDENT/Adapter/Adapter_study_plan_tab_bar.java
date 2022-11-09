package com.example.useaapp.STUDENT.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.useaapp.STUDENT.StudyPlan.year1.Fragment_student_Studyplan_y1s1s2;
import com.example.useaapp.STUDENT.StudyPlan.year2.Fragment_student_Studyplan_y2s1s2;
import com.example.useaapp.STUDENT.StudyPlan.year3.Fragment_student_Studyplan_y3s1s2;
import com.example.useaapp.STUDENT.StudyPlan.year4.Fragment_student_Studyplan_y4s1s2;

public class Adapter_study_plan_tab_bar extends FragmentStateAdapter {
    String[] Tab_title = {"", "", "", ""};

    public Adapter_study_plan_tab_bar(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new Fragment_student_Studyplan_y1s1s2();
            case 1:
                return new Fragment_student_Studyplan_y2s1s2();
            case 2:
                return new Fragment_student_Studyplan_y3s1s2();
            case 3:
                return new Fragment_student_Studyplan_y4s1s2();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return Tab_title.length;
    }
}
