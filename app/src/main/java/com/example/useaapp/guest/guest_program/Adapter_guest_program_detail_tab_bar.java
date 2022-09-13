package com.example.useaapp.guest.guest_program;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class Adapter_guest_program_detail_tab_bar extends FragmentStateAdapter {
    String [] Tab_menu = {""};
    public Adapter_guest_program_detail_tab_bar(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        return null;
    }

    @Override
    public int getItemCount() {
        return Tab_menu.length;
    }
}
