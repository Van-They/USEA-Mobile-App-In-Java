package com.example.useaapp.guest.guest_events.past;

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
import com.example.useaapp.guest.guest_events.Adapter_guest_event;
import com.example.useaapp.guest.guest_events.GuestEventModel;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentPastEvent extends Fragment {
    RecyclerView pastEvent;
    List<Response_model_guest_event_past> responsemodels;
    ArrayList<GuestEventModel> Data_past_event;
    ShimmerFrameLayout Shimmer;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_past_event, container, false);
        Shimmer = view.findViewById(R.id.custom_guest_shimmer_past_event);
        Shimmer.startShimmer();
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pastEvent = view.findViewById(R.id.pastEvent);
        pastEvent.setLayoutManager(new LinearLayoutManager(getActivity()));

        processdata();

    }

    public void processdata()
    {
        Call<List<com.example.useaapp.guest.guest_events.past.Response_model_guest_event_past>> call = com.example.useaapp.guest.guest_events.past.ApiController_guest_event_past
                .getInstance()
                .getapi()
                .getdata();

        call.enqueue(new Callback<List<com.example.useaapp.guest.guest_events.past.Response_model_guest_event_past>>() {
            @Override
            public void onResponse(Call<List<com.example.useaapp.guest.guest_events.past.Response_model_guest_event_past>> call, Response<List<com.example.useaapp.guest.guest_events.past.Response_model_guest_event_past>> response) {
                responsemodels = response.body();
                com.example.useaapp.guest.guest_events.past.Adapter_guest_event_past myadapter = new com.example.useaapp.guest.guest_events.past.Adapter_guest_event_past(responsemodels);
                if (responsemodels !=null && !responsemodels.isEmpty()){
                    Shimmer.stopShimmer();
                    Shimmer.setVisibility(View.GONE);
                    pastEvent.setVisibility(View.VISIBLE);
                    pastEvent.setAdapter(myadapter);
                }else {

                    Toast.makeText(getActivity(), "No data found", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<Response_model_guest_event_past>> call, Throwable t) {
                Toast.makeText(getActivity(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}