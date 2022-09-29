package com.example.useaapp.guest.guest_events.current;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.useaapp.R;
import com.example.useaapp.guest.guest_events.GuestEventModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentCurrentEvent extends Fragment {
    RecyclerView lvCurrentEvent;
    List<Response_model_guest_event_current> responsemodels;
    ArrayList<GuestEventModel> Data_current_event;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_current, container, false);
       return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lvCurrentEvent = view.findViewById(R.id.lvCurrentEvent);
        lvCurrentEvent.setHasFixedSize(true);
        lvCurrentEvent.setLayoutManager(new LinearLayoutManager(getActivity()));

        processdata();

    }

    public void processdata()
    {
        Call<List<Response_model_guest_event_current>> call = com.example.useaapp.guest.guest_events.current.ApiController_guest_event_current
                .getInstance()
                .getapi()
                .getdata();

        call.enqueue(new Callback<List<Response_model_guest_event_current>>() {
            @Override
            public void onResponse(Call<List<Response_model_guest_event_current>> call, Response<List<Response_model_guest_event_current>> response) {
                responsemodels = response.body();
                com.example.useaapp.guest.guest_events.current.Adapter_guest_event_current myadapter = new com.example.useaapp.guest.guest_events.current.Adapter_guest_event_current(responsemodels);
                if (responsemodels !=null && !responsemodels.isEmpty()){
                    lvCurrentEvent.setAdapter(myadapter);
                }else {

                    Toast.makeText(getActivity(), "No data found", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<Response_model_guest_event_current>> call, Throwable t) {
                Toast.makeText(getActivity(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}