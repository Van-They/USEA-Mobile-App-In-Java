package com.example.useaapp.STUDENT.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.useaapp.STUDENT.Score.Detail_score_s1s2.Fragment_score_s1;
import com.example.useaapp.STUDENT.Score.Detail_score_s1s2.Fragment_score_s2;

public class Adapter_score_detail_tab_bar extends FragmentStateAdapter {
    String[] score_detail_tab = {"", ""};

    public Adapter_score_detail_tab_bar(@NonNull FragmentActivity fragmentActivity) {
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
