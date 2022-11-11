package com.example.useaapp.STUDENT.Score.Detail_score_s1s2;

import android.content.Context;
import android.content.SharedPreferences;
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
import com.example.useaapp.R;
import com.example.useaapp.STUDENT.ApiController_student;
import com.example.useaapp.STUDENT.Score.Score.ModelScore;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_score_s2 extends Fragment {
    private final static String SHARE_PREFNAME = "Student_Name";
    private final static String text2 = "txt2";
    SharedPreferences sharedPreferences;
    String St_id;
    RecyclerView Listview_student_score_detail_s2;
    String txt;
    private List<ModelScore> responsemodels;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_score_s2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Listview_student_score_detail_s2 = view.findViewById(R.id.Listview_student_score_detail_s2);
        Listview_student_score_detail_s2.setLayoutManager(new LinearLayoutManager(getActivity()));

        sharedPreferences = requireActivity().getSharedPreferences(SHARE_PREFNAME, Context.MODE_PRIVATE);
        St_id = sharedPreferences.getString("Student_ID", "");

        txt = sharedPreferences.getString(text2,"");

        if (txt.equals("y1s2")) {
            processdata1();
        } else if (txt.equals("y2s2")) {
            processdata2();
        } else if (txt.equals("y3s2")) {
            processdata3();
        } else if (txt.equals("y4s2")) {
            processdata4();
        }

    }

    public void processdata1() {
        Data_Progressing ShowDialog = new Data_Progressing(getContext());
        ShowDialog.showDialog();
        Call<List<ModelScore>> call1 = ApiController_student
                .getInstance()
                .getapi_stu_score_y1s2()
                .get_stu_score_y1s2(St_id);


        call1.enqueue(new Callback<List<ModelScore>>() {
            @Override
            public void onResponse(Call<List<ModelScore>> call, Response<List<ModelScore>> response) {
                responsemodels = response.body();

                Adapter_score_detail myadapter = new Adapter_score_detail(responsemodels);
                if (responsemodels != null && !responsemodels.isEmpty()) {
                    ShowDialog.stopDialog();
                    Listview_student_score_detail_s2.setVisibility(View.VISIBLE);
                    Listview_student_score_detail_s2.setAdapter(myadapter);

                } else {
                    Toast.makeText(getActivity(), "No data found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ModelScore>> call, Throwable t) {
                Toast.makeText(getActivity(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void processdata2() {
        Data_Progressing ShowDialog = new Data_Progressing(getContext());
        ShowDialog.showDialog();
        Call<List<ModelScore>> call1 = ApiController_student
                .getInstance()
                .getapi_stu_score_y2s2()
                .get_stu_score_y2s2(St_id);


        call1.enqueue(new Callback<List<ModelScore>>() {
            @Override
            public void onResponse(Call<List<ModelScore>> call, Response<List<ModelScore>> response) {
                responsemodels = response.body();

                Adapter_score_detail myadapter = new Adapter_score_detail(responsemodels);
                if (responsemodels != null && !responsemodels.isEmpty()) {
                    ShowDialog.stopDialog();
                    Listview_student_score_detail_s2.setVisibility(View.VISIBLE);
                    Listview_student_score_detail_s2.setAdapter(myadapter);

                } else {
                    Toast.makeText(getActivity(), "No data found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ModelScore>> call, Throwable t) {
                Toast.makeText(getActivity(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void processdata3() {
        Data_Progressing ShowDialog = new Data_Progressing(getContext());
        ShowDialog.showDialog();
        Call<List<ModelScore>> call1 = ApiController_student
                .getInstance()
                .getapi_stu_score_y3s2()
                .get_stu_score_y3s2(St_id);


        call1.enqueue(new Callback<List<ModelScore>>() {
            @Override
            public void onResponse(Call<List<ModelScore>> call, Response<List<ModelScore>> response) {
                responsemodels = response.body();

                Adapter_score_detail myadapter = new Adapter_score_detail(responsemodels);
                if (responsemodels != null && !responsemodels.isEmpty()) {
                    ShowDialog.stopDialog();
                    Listview_student_score_detail_s2.setVisibility(View.VISIBLE);
                    Listview_student_score_detail_s2.setAdapter(myadapter);

                } else {
                    Toast.makeText(getActivity(), "No data found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ModelScore>> call, Throwable t) {
                Toast.makeText(getActivity(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void processdata4() {
        Data_Progressing ShowDialog = new Data_Progressing(getContext());
        ShowDialog.showDialog();
        Call<List<ModelScore>> call1 = ApiController_student
                .getInstance()
                .getapi_stu_score_y4s2()
                .get_stu_score_y4s2(St_id);


        call1.enqueue(new Callback<List<ModelScore>>() {
            @Override
            public void onResponse(Call<List<ModelScore>> call, Response<List<ModelScore>> response) {
                responsemodels = response.body();

                Adapter_score_detail myadapter = new Adapter_score_detail(responsemodels);
                if (responsemodels != null && !responsemodels.isEmpty()) {
                    ShowDialog.stopDialog();
                    Listview_student_score_detail_s2.setVisibility(View.VISIBLE);
                    Listview_student_score_detail_s2.setAdapter(myadapter);

                } else {
                    Toast.makeText(getActivity(), "No data found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ModelScore>> call, Throwable t) {
                Toast.makeText(getActivity(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}