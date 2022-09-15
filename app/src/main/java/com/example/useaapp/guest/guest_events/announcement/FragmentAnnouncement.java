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
    ArrayList<GuestEventModel> Data_announcement_event;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_announcement, container, false);
        list_announcement = view.findViewById(R.id.list_announcement);
        Data_announcement_event = new ArrayList<>();
        Data_announcement_event.add(new GuestEventModel(R.drawable.graduatee, "ពិធីប្រគល់សញ្ញាប័ត្រដល់និស្សិតជំនាន់ទី១៣-១៤", "របស់ ឯកឧត្តម ឧបនាយករដ្ឋមន្ត្រី កែ គឹមយ៉ាន នៅសកលវិទ្យាល័យ សៅស៍អ៊ីសថ៍អេយសៀ ឆ្នាំសិក្សា ២០២១-២០២២ សម្រាប់ កំរិត បរិញ្ញាបត្រ និងបរិញ្ញាបត្ររងចំនួន២០កន្លែង។", "អង្គារ", "២១", "តុលា", "២០២២", "៨:០០ ព្រឹក"));
        Data_announcement_event.add(new GuestEventModel(R.drawable.sharing, "ពិធីប្រចែករំលែកបទពិសោធន៍របស់និស្សិតច្បាប់", "សកលវិទ្យាល័យ សៅស៍អ៊ីសថ៍អេយសៀ បានរៀបកម្មវិធីចែករំលែគបទពិសោធន៍សិក្សាដល់សិស្សជំនាន់ថ្មី។", "ពុធ", "៣០", "វិច្ចឹកា", "២០២២", "១១:០០ ព្រឹក"));
        Data_announcement_event.add(new GuestEventModel(R.drawable.banner, "ពិធីប្រចែករំលែកបទពិសោធន៍របស់និស្សិតច្បាប់", "សកលវិទ្យាល័យ សៅស៍អ៊ីសថ៍អេយសៀ បានរៀបកម្មវិធីចែករំលែគបទពិសោធន៍សិក្សាដល់សិស្សជំនាន់ថ្មី។", "ពុធ", "៣០", "វិច្ចឹកា", "២០២២", "១១:០០ ព្រឹក"));
        list_announcement.setAdapter(new Adapter_guest_event(view.getContext(), Data_announcement_event));
        return view;
    }
}