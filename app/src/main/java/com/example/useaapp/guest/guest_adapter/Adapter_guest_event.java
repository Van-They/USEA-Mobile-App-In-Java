package com.example.useaapp.guest.guest_adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.useaapp.SampleFragment;

public class Adapter_guest_event extends FragmentStateAdapter {
    String[] event_tab = {"", "", "", ""};

    public Adapter_guest_event(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        return new SampleFragment();
    }

    @Override
    public int getItemCount() {
        return event_tab.length;
    }
}
