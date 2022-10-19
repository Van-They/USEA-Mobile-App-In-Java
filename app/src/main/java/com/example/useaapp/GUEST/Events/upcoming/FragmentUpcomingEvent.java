package com.example.useaapp.GUEST.Events.upcoming;

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

import com.example.useaapp.Data_Progressing;
import com.example.useaapp.R;
import com.example.useaapp.GUEST.Events.GuestEventModel;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentUpcomingEvent extends Fragment {
    RecyclerView upcomingEvent;
    List<Response_model_guest_event_upcoming> responsemodels;
    ArrayList<GuestEventModel> upcomingValue;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_upcoming, container, false);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        upcomingEvent = view.findViewById(R.id.upcomingEvent);
        upcomingEvent.setLayoutManager(new LinearLayoutManager(getActivity()));

        processdata();

    }

    public void processdata()
    {
        Data_Progressing dialog = new Data_Progressing(getContext());
        Call<List<Response_model_guest_event_upcoming>> call = com.example.useaapp.GUEST.Events.upcoming.ApiController_guest_event_upcoming
                .getInstance()
                .getapi()
                .getdata();

        call.enqueue(new Callback<List<Response_model_guest_event_upcoming>>() {
            @Override
            public void onResponse(Call<List<com.example.useaapp.GUEST.Events.upcoming.Response_model_guest_event_upcoming>> call, Response<List<Response_model_guest_event_upcoming>> response) {
                responsemodels = response.body();
                com.example.useaapp.GUEST.Events.upcoming.Adapter_guest_event_upcoming myadapter = new com.example.useaapp.GUEST.Events.upcoming.Adapter_guest_event_upcoming(responsemodels);
                if (responsemodels !=null && !responsemodels.isEmpty()){
                    dialog.stopDialog();
                    upcomingEvent.setAdapter(myadapter);
                }else {

                    Toast.makeText(getActivity(), "No data found", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<Response_model_guest_event_upcoming>> call, Throwable t) {
                Toast.makeText(getActivity(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}