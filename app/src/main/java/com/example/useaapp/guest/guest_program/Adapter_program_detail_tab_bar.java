package com.example.useaapp.guest.guest_program;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.useaapp.SampleFragment;
import com.example.useaapp.guest.guest_program.associative.Fragment_associative;
import com.example.useaapp.guest.guest_program.bachelor.Fragment_bachelor;
import com.example.useaapp.guest.guest_program.master.Fragment_master;

public class Adapter_program_detail_tab_bar extends FragmentStateAdapter {
    String [] Tab_menu = {"","",""};
    public Adapter_program_detail_tab_bar(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new Fragment_associative();
            case 1:
                return new Fragment_bachelor();
            case 2:
                return new Fragment_master();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return Tab_menu.length;
    }
}
