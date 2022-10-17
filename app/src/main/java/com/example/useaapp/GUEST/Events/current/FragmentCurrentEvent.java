package com.example.useaapp.GUEST.Events.current;

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
import com.example.useaapp.GUEST.Events.GuestEventModel;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentCurrentEvent extends Fragment {
    RecyclerView lvCurrentEvent;
    List<Response_model_guest_event_current> responsemodels;
    ArrayList<GuestEventModel> Data_current_event;
    ShimmerFrameLayout Shimmer;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_current, container, false);
        Shimmer = view.findViewById(R.id.custom_guest_shimmer_current);
        Shimmer.startShimmer();
       return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lvCurrentEvent = view.findViewById(R.id.lvCurrentEvent);
        lvCurrentEvent.setLayoutManager(new LinearLayoutManager(getActivity()));
        processdata();

    }

    public void processdata()
    {
        Call<List<Response_model_guest_event_current>> call = com.example.useaapp.GUEST.Events.current.ApiController_guest_event_current
                .getInstance()
                .getapi()
                .getdata();

        call.enqueue(new Callback<List<Response_model_guest_event_current>>() {
            @Override
            public void onResponse(Call<List<Response_model_guest_event_current>> call, Response<List<Response_model_guest_event_current>> response) {
                responsemodels = response.body();
                com.example.useaapp.GUEST.Events.current.Adapter_guest_event_current myadapter = new com.example.useaapp.GUEST.Events.current.Adapter_guest_event_current(responsemodels);
                if (responsemodels !=null && !responsemodels.isEmpty()){
                    Shimmer.stopShimmer();
                    Shimmer.setVisibility(View.GONE);
                    lvCurrentEvent.setVisibility(View.VISIBLE);
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