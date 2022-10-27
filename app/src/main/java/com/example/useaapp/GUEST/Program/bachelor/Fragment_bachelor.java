package com.example.useaapp.GUEST.Program.bachelor;

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
import com.example.useaapp.GUEST.Program.ApiController_guest_program_faculty;
import com.example.useaapp.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_bachelor extends Fragment {

    RecyclerView list_announcement;
    List<Response_model_guest_program_faculty_bachelor> responsemodels;
    public static final String text = "txt";
    String txt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_bachelor, container, false);
        return v;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        list_announcement = view.findViewById(R.id.Listview_guest_program_bachelor);
        list_announcement.setLayoutManager(new LinearLayoutManager(getActivity()));

        txt = getActivity().getIntent().getStringExtra(text);

        if(txt.equals("1")){
            processdata1();
        }else if(txt.equals("2")){
            processdata2();
        }
        if(txt.equals("3")){
            processdata3();
        }else if(txt.equals("4")){
            processdata4();
        }

    }

    public void processdata1() {
        Data_Progressing ShowDialog = new Data_Progressing(getContext());
        ShowDialog.showDialog();
        Call<List<Response_model_guest_program_faculty_bachelor>> call = ApiController_guest_program_faculty
                .getInstance()
                .getapi_fac1_bach_major_id1()
                .get_guest_pro_fac_bac1();

        call.enqueue(new Callback<List<Response_model_guest_program_faculty_bachelor>>() {
            @Override
            public void onResponse(Call<List<Response_model_guest_program_faculty_bachelor>> call, Response<List<Response_model_guest_program_faculty_bachelor>> response) {
                responsemodels = response.body();
                Adapter_guest_program_faculty_bachelor myadapter = new Adapter_guest_program_faculty_bachelor(responsemodels);
                if (responsemodels != null && !responsemodels.isEmpty()) {
                    ShowDialog.stopDialog();
                    list_announcement.setVisibility(View.VISIBLE);
                    list_announcement.setAdapter(myadapter);
                } else {
                    Toast.makeText(getActivity(), "No data found", Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onFailure(Call<List<Response_model_guest_program_faculty_bachelor>> call, Throwable t) {
                Toast.makeText(getActivity(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void processdata2() {
        Data_Progressing ShowDialog = new Data_Progressing(getContext());
        ShowDialog.showDialog();
        Call<List<Response_model_guest_program_faculty_bachelor>> call = ApiController_guest_program_faculty
                .getInstance()
                .getapi_fac2_bach_major_id2()
                .get_guest_pro_fac_bac2();

        call.enqueue(new Callback<List<Response_model_guest_program_faculty_bachelor>>() {
            @Override
            public void onResponse(Call<List<Response_model_guest_program_faculty_bachelor>> call, Response<List<Response_model_guest_program_faculty_bachelor>> response) {
                responsemodels = response.body();
                Adapter_guest_program_faculty_bachelor myadapter = new Adapter_guest_program_faculty_bachelor(responsemodels);
                if (responsemodels != null && !responsemodels.isEmpty()) {
                    ShowDialog.stopDialog();
                    list_announcement.setVisibility(View.VISIBLE);
                    list_announcement.setAdapter(myadapter);
                } else {
                    Toast.makeText(getActivity(), "No data found", Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onFailure(Call<List<Response_model_guest_program_faculty_bachelor>> call, Throwable t) {
                Toast.makeText(getActivity(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void processdata3() {
        Data_Progressing ShowDialog = new Data_Progressing(getContext());
        ShowDialog.showDialog();
        Call<List<Response_model_guest_program_faculty_bachelor>> call = ApiController_guest_program_faculty
                .getInstance()
                .getapi_fac3_bach_major_id3()
                .get_guest_pro_fac_bac3();

        call.enqueue(new Callback<List<Response_model_guest_program_faculty_bachelor>>() {
            @Override
            public void onResponse(Call<List<Response_model_guest_program_faculty_bachelor>> call, Response<List<Response_model_guest_program_faculty_bachelor>> response) {
                responsemodels = response.body();
                Adapter_guest_program_faculty_bachelor myadapter = new Adapter_guest_program_faculty_bachelor(responsemodels);
                if (responsemodels != null && !responsemodels.isEmpty()) {
                    ShowDialog.stopDialog();
                    list_announcement.setVisibility(View.VISIBLE);
                    list_announcement.setAdapter(myadapter);
                } else {
                    Toast.makeText(getActivity(), "No data found", Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onFailure(Call<List<Response_model_guest_program_faculty_bachelor>> call, Throwable t) {
                Toast.makeText(getActivity(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void processdata4() {
        Data_Progressing ShowDialog = new Data_Progressing(getContext());
        ShowDialog.showDialog();
        Call<List<Response_model_guest_program_faculty_bachelor>> call = ApiController_guest_program_faculty
                .getInstance()
                .getapi_fac4_bach_major_id4()
                .get_guest_pro_fac_bac4();

        call.enqueue(new Callback<List<Response_model_guest_program_faculty_bachelor>>() {
            @Override
            public void onResponse(Call<List<Response_model_guest_program_faculty_bachelor>> call, Response<List<Response_model_guest_program_faculty_bachelor>> response) {
                responsemodels = response.body();
                Adapter_guest_program_faculty_bachelor myadapter = new Adapter_guest_program_faculty_bachelor(responsemodels);
                if (responsemodels != null && !responsemodels.isEmpty()) {
                    ShowDialog.stopDialog();
                    list_announcement.setVisibility(View.VISIBLE);
                    list_announcement.setAdapter(myadapter);
                } else {
                    Toast.makeText(getActivity(), "No data found", Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onFailure(Call<List<Response_model_guest_program_faculty_bachelor>> call, Throwable t) {
                Toast.makeText(getActivity(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}