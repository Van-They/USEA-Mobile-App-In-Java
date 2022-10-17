package com.example.useaapp.STUDENT.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.useaapp.STUDENT.StudyPlan.year1.FragmentStudyPlan_Y1S1S2;
import com.example.useaapp.STUDENT.StudyPlan.year2.FragmentStudyPlan_Y2S1S2;
import com.example.useaapp.STUDENT.StudyPlan.year3.FragmentStudyPlan_Y3S1S2;
import com.example.useaapp.STUDENT.StudyPlan.year4.FragmentStudyPlan_Y4S1S2;

public class Adapter_study_plan_tab_bar extends FragmentStateAdapter {
    String[] Tab_title = {"", "", "", ""};

    public Adapter_study_plan_tab_bar(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new FragmentStudyPlan_Y1S1S2();
            case 1:
                return new FragmentStudyPlan_Y2S1S2();
            case 2:
                return new FragmentStudyPlan_Y3S1S2();
            case 3:
                return new FragmentStudyPlan_Y4S1S2();
        }
        return new FragmentStudyPlan_Y1S1S2();
    }

    @Override
    public int getItemCount() {
        return Tab_title.length;
    }
}
