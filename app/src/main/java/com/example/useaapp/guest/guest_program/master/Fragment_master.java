package com.example.useaapp.guest.guest_program.master;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.useaapp.R;
import com.example.useaapp.guest.guest_program.Adapter_program_detail;

import java.util.ArrayList;

public class Fragment_master extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_master, container, false);
        ListView listView = v.findViewById(R.id.Listview_guest_program_master);
        ArrayList<String> title = new ArrayList<>();
        title.add("ទេសចរណ៍");
        title.add("ព៌ត័មានវិទ្យា");
        listView.setAdapter(new Adapter_program_detail(v.getContext(), title));
        return v;
    }
}