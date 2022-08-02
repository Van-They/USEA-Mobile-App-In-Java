package com.example.useaapp.student.student_adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.useaapp.SampleFragment;
import com.example.useaapp.student.student_home.FragmentStudentHome;
import com.example.useaapp.student.student_studyplan.year1.FragmentStudyPlan_Y1S1S2;

public class Adapter_studyplan extends FragmentStateAdapter {
    String[] Tab_title = {"", "", "", ""};
    public Adapter_studyplan(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new FragmentStudyPlan_Y1S1S2();
    }

    @Override
    public int getItemCount() {
        return Tab_title.length;
    }
}
