package com.example.useaapp.guest.guest_events.current;

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

public class FragmentCurrentEvent extends Fragment {
    ListView lvCurrentEvent;
    ArrayList<GuestEventModel> currentValue;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_current, container, false);
        lvCurrentEvent =view.findViewById(R.id.lvCurrentEvent);
        currentValue = new ArrayList<>();
        currentValue.add(new GuestEventModel(R.drawable.graduatee, "ពិធីប្រគល់សញ្ញាប័ត្រដល់និស្សិតជំនាន់ទី១៣-១៤", "របស់ ឯកឧត្តម ឧបនាយករដ្ឋមន្ត្រី កែ គឹមយ៉ាន នៅសកលវិទ្យាល័យ សៅស៍អ៊ីសថ៍អេយសៀ ឆ្នាំសិក្សា ២០២១-២០២២ សម្រាប់ កំរិត បរិញ្ញាបត្រ និងបរិញ្ញាបត្ររងចំនួន២០កន្លែង។", "អង្គារ", "២១", "តុលា", "២០២២", "៨:០០ ព្រឹក"));
        currentValue.add(new GuestEventModel(R.drawable.sharing, "ពិធីប្រគល់សញ្ញាប័ត្រដល់និស្សិតជំនាន់ទី១៣-១៤", "របស់ ឯកឧត្តម ឧបនាយករដ្ឋមន្ត្រី កែ គឹមយ៉ាន នៅសកលវិទ្យាល័យ សៅស៍អ៊ីសថ៍អេយសៀ ឆ្នាំសិក្សា ២០២១-២០២២ សម្រាប់ កំរិត បរិញ្ញាបត្រ និងបរិញ្ញាបត្ររងចំនួន២០កន្លែង។", "អង្គារ", "២១", "តុលា", "២០២២", "៨:០០ ព្រឹក"));
        currentValue.add(new GuestEventModel(R.drawable.banner, "ពិធីប្រគល់សញ្ញាប័ត្រដល់និស្សិតជំនាន់ទី១៣-១៤", "របស់ ឯកឧត្តម ឧបនាយករដ្ឋមន្ត្រី កែ គឹមយ៉ាន នៅសកលវិទ្យាល័យ សៅស៍អ៊ីសថ៍អេយសៀ ឆ្នាំសិក្សា ២០២១-២០២២ សម្រាប់ កំរិត បរិញ្ញាបត្រ និងបរិញ្ញាបត្ររងចំនួន២០កន្លែង។", "អង្គារ", "២១", "តុលា", "២០២២", "៨:០០ ព្រឹក"));
        lvCurrentEvent.setAdapter(new Adapter_guest_event(getContext(),currentValue));
        return view;
    }
}