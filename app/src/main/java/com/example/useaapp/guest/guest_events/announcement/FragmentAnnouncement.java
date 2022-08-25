package com.example.useaapp.guest.guest_events.announcement;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.useaapp.R;
import com.example.useaapp.guest.guest_events.Adapter_guest_event;
import com.example.useaapp.guest.guest_events.GuestEventModel;

import java.util.ArrayList;

public class FragmentAnnouncement extends Fragment {
    ListView list_announcement;
    private ArrayList<GuestEventModel> value;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_announcement, container, false);
        list_announcement = view.findViewById(R.id.list_announcement);
        value = new ArrayList<>();
        value.add(new GuestEventModel(R.drawable.logo_usea, "ពិធីប្រគល់សញ្ញាប័ត្រដល់និស្សិតជំនាន់ទី១៣-១៤", "របស់ ឯកឧត្តម ឧបនាយករដ្ឋមន្ត្រី កែ គឹមយ៉ាន នៅសកលវិទ្យាល័យ សៅស៍អ៊ីសថ៍អេយសៀ ឆ្នាំសិក្សា ២០២១-២០២២ សម្រាប់ កំរិត បរិញ្ញាបត្រ និងបរិញ្ញាបត្ររងចំនួន២០កន្លែង។", "អង្គារ", "21", "តុលា", "២០២២", "៨:០០ ព្រឹក"));
        value.add(new GuestEventModel(R.drawable.logo_usea, "ពិធីប្រគល់សញ្ញាប័ត្រដល់និស្សិតជំនាន់ទី១៣-១៤", "របស់ ឯកឧត្តម ឧបនាយករដ្ឋមន្ត្រី កែ គឹមយ៉ាន នៅសកលវិទ្យាល័យ សៅស៍អ៊ីសថ៍អេយសៀ ឆ្នាំសិក្សា ២០២១-២០២២ សម្រាប់ កំរិត បរិញ្ញាបត្រ និងបរិញ្ញាបត្ររងចំនួន២០កន្លែង។", "អង្គារ", "21", "តុលា", "២០២២", "៨:០០ ព្រឹក"));
        list_announcement.setAdapter(new Adapter_guest_event(getContext(),value));
        return view;
    }
}