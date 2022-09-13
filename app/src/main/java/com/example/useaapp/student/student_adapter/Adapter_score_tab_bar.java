package com.example.useaapp.student.student_adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.useaapp.student.student_score.year1.FragmentStudentScore_Y1S1S2;
import com.example.useaapp.student.student_score.year2.FragmentStudentScore_Y2S1S2;
import com.example.useaapp.student.student_score.year3.FragmentStudentScore_Y3S1S2;
import com.example.useaapp.student.student_score.year4.FragmentStudentScore_Y4S1S2;

public class Adapter_score_tab_bar extends FragmentStateAdapter {
    String[] Tab_title = {"ឆ្នាំទី១", "ឆ្នាំទី២", "ឆ្នាំទី៣", "ឆ្នាំទី៤"};
    public Adapter_score_tab_bar(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new FragmentStudentScore_Y1S1S2();
            case 1:
                return new FragmentStudentScore_Y2S1S2();
            case 2:
                return new FragmentStudentScore_Y3S1S2();
            case 3:
                return new FragmentStudentScore_Y4S1S2();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return Tab_title.length;
    }
}
