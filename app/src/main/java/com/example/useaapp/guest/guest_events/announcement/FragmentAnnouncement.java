package com.example.useaapp.guest.guest_events.announcement;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.useaapp.R;
import com.example.useaapp.guest.guest_career.GuestCareer;
import com.example.useaapp.guest.guest_career.Response_model_guest_career;
import com.example.useaapp.guest.guest_events.Adapter_guest_event;
import com.example.useaapp.guest.guest_events.GuestEventModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentAnnouncement extends Fragment {
    RecyclerView list_announcement;
    List<Response_model_guest_event_announcement> responsemodels;
    ArrayList<GuestEventModel> Data_announcement_event;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_announcement, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        list_announcement = view.findViewById(R.id.list_announcement);
        list_announcement.setHasFixedSize(true);
        list_announcement.setLayoutManager(new LinearLayoutManager(getActivity()));

        processdata();

    }

    public void processdata()
    {
        Call<List<Response_model_guest_event_announcement>> call = com.example.useaapp.guest.guest_events.announcement.ApiController_guest_event_announcement
                .getInstance()
                .getapi()
                .getdata();

        call.enqueue(new Callback<List<Response_model_guest_event_announcement>>() {
            @Override
            public void onResponse(Call<List<com.example.useaapp.guest.guest_events.announcement.Response_model_guest_event_announcement>> call, Response<List<Response_model_guest_event_announcement>> response) {
                responsemodels = response.body();
                com.example.useaapp.guest.guest_events.announcement.Adapter_guest_event_announcement myadapter = new com.example.useaapp.guest.guest_events.announcement.Adapter_guest_event_announcement(responsemodels);
                if (responsemodels !=null && !responsemodels.isEmpty()){
                    list_announcement.setAdapter(myadapter);
                }else {
                    Toast.makeText(getActivity(), "No data found", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<com.example.useaapp.guest.guest_events.announcement.Response_model_guest_event_announcement>> call, Throwable t) {
                Toast.makeText(getActivity(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}