package com.example.useaapp.GUEST.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.useaapp.GUEST.Events.announcement.FragmentAnnouncement;
import com.example.useaapp.GUEST.Events.current.FragmentCurrentEvent;
import com.example.useaapp.GUEST.Events.past.FragmentPastEvent;
import com.example.useaapp.GUEST.Events.upcoming.FragmentUpcomingEvent;

public class Adapter_guest_event_tabbar extends FragmentStateAdapter {
    String[] event_tab = {"", "", "", ""};

    public Adapter_guest_event_tabbar(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
    switch (position){
        case 0:
            return new FragmentAnnouncement();
        case 1:
            return new FragmentUpcomingEvent();
        case 2:
            return new FragmentCurrentEvent();
        case 3:
            return new FragmentPastEvent();
    }
        return null;
    }

    @Override
    public int getItemCount() {
        return event_tab.length;
    }
}
