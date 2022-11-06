package com.example.useaapp.GUEST.Program.master;

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
import com.example.useaapp.GUEST.ApiController_guest;
import com.example.useaapp.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_master extends Fragment {

    RecyclerView list_announcement;
    List<Response_model_guest_program_faculty_master> responsemodels;
    public static final String text = "txt";
    String txt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_master, container, false);
        return v;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        list_announcement = view.findViewById(R.id.Listview_guest_program_master);
        list_announcement.setLayoutManager(new LinearLayoutManager(getActivity()));

        txt = getActivity().getIntent().getStringExtra(text);

        if(txt.equals("2")){
            processdata1();
        }

    }

    public void processdata1() {
        Data_Progressing ShowDialog = new Data_Progressing(getContext());
        ShowDialog.showDialog();
        Call<List<Response_model_guest_program_faculty_master>> call = ApiController_guest
                .getInstance()
                .getapi_fac2_mast_major_id2()
                .get_guest_pro_fac_mast2();

        call.enqueue(new Callback<List<Response_model_guest_program_faculty_master>>() {
            @Override
            public void onResponse(Call<List<Response_model_guest_program_faculty_master>> call, Response<List<Response_model_guest_program_faculty_master>> response) {
                responsemodels = response.body();
                Adapter_guest_program_faculty_master myadapter = new Adapter_guest_program_faculty_master(responsemodels, getContext());
                if (responsemodels != null && !responsemodels.isEmpty()) {
                    ShowDialog.stopDialog();
                    list_announcement.setVisibility(View.VISIBLE);
                    list_announcement.setAdapter(myadapter);
                } else {
                    Toast.makeText(getActivity(), "No data found", Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onFailure(Call<List<Response_model_guest_program_faculty_master>> call, Throwable t) {
                Toast.makeText(getActivity(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}