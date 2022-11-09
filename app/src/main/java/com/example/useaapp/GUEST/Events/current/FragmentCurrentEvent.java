package com.example.useaapp.GUEST.Events.current;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useaapp.Data_Progressing;
import com.example.useaapp.GUEST.ApiController_guest;
import com.example.useaapp.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentCurrentEvent extends Fragment {
    RecyclerView lvCurrentEvent;
    List<Response_model_guest_event_current> responsemodels;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_current, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lvCurrentEvent = view.findViewById(R.id.lvCurrentEvent);
        lvCurrentEvent.setLayoutManager(new LinearLayoutManager(getActivity()));
        processdata();

    }

    public void processdata() {
        Data_Progressing dialog = new Data_Progressing(getContext());
        dialog.showDialog();
        Call<List<Response_model_guest_event_current>> call = ApiController_guest
                .getInstance()
                .getapi_event_current()
                .getdata_event_current();

        call.enqueue(new Callback<List<Response_model_guest_event_current>>() {
            @Override
            public void onResponse(Call<List<Response_model_guest_event_current>> call, Response<List<Response_model_guest_event_current>> response) {
                responsemodels = response.body();
                Adapter_guest_event_current myadapter = new Adapter_guest_event_current(responsemodels);
                if (responsemodels != null && !responsemodels.isEmpty()) {
                    dialog.stopDialog();
                    lvCurrentEvent.setAdapter(myadapter);
                } else {

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