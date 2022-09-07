package com.example.useaapp.student.student_score.year1;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.useaapp.student.student_score.Fragment_score_s1;
import com.example.useaapp.student.student_score.Fragment_score_s2;

public class Adapter_student_score_detail_tabbar extends FragmentStateAdapter {
    String[] score_detail_tab = {"", ""};

    public Adapter_student_score_detail_tabbar(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
    switch (position){
        case 0:
            return new Fragment_score_s1();
        case 1:
            return new Fragment_score_s2();
    }
    return null;
    }

    @Override
    public int getItemCount() {
        return score_detail_tab.length;
    }
}
