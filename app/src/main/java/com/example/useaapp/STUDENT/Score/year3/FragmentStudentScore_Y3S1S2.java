package com.example.useaapp.STUDENT.Score.year3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useaapp.Data_Progressing;
import com.example.useaapp.R;
import com.example.useaapp.STUDENT.Adapter.Adapter_score_semester;
import com.example.useaapp.STUDENT.ApiController_student;
import com.example.useaapp.STUDENT.Score.Detail_score_s1s2.ScoreDetail;
import com.example.useaapp.STUDENT.Score.Score.ModelScore;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentStudentScore_Y3S1S2 extends Fragment {
    private final static String SHARE_PREFNAME = "Student_Name";
    private final static String text = "txt";
    private final static String txt1 = "y3s1";
    private final static String txt2 = "y3s2";
    SharedPreferences sharedPreferences;
    String St_id;
    RecyclerView student_study_plan_list_s1, student_study_plan_list_s2;
    View student_score_show_detail_y3s1, student_score_show_detail_y3s2;
    NestedScrollView nestedScrollView;
    LinearLayout layout_no_data;
    TextView text_no_data;
    private List<ModelScore> responsemodels;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_score__y3_s1_s2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        student_study_plan_list_s1 = view.findViewById(R.id.student_score_list_y3s1);
        student_study_plan_list_s1.setLayoutManager(new LinearLayoutManager(getActivity()));

        student_study_plan_list_s2 = view.findViewById(R.id.student_score_list_y3s2);
        student_study_plan_list_s2.setLayoutManager(new LinearLayoutManager(getActivity()));

        student_score_show_detail_y3s1 = view.findViewById(R.id.student_score_show_detail_y3s1);
        student_score_show_detail_y3s2 = view.findViewById(R.id.student_score_show_detail_y3s2);

        nestedScrollView = view.findViewById(R.id.layout_nested_scroll);
        layout_no_data = view.findViewById(R.id.layout_text_no_data);
        text_no_data = view.findViewById(R.id.text_no_data);

        student_score_show_detail_y3s1.setOnClickListener(view1 -> {
            Intent intent = new Intent(getContext(), ScoreDetail.class);
            intent.putExtra(text, txt1);
            startActivity(intent);
        });

        student_score_show_detail_y3s2.setOnClickListener(view12 -> {
            Intent intent = new Intent(getContext(), ScoreDetail.class);
            intent.putExtra(text, txt2);
            startActivity(intent);
        });

        sharedPreferences = requireActivity().getSharedPreferences(SHARE_PREFNAME, Context.MODE_PRIVATE);
        St_id = sharedPreferences.getString("Student_ID", "");

        processdata1();

    }

    public void processdata1() {
        Data_Progressing ShowDialog = new Data_Progressing(getContext());
        ShowDialog.showDialog();
        Call<List<ModelScore>> call1 = ApiController_student
                .getInstance()
                .getapi_stu_score_y3s1()
                .get_stu_score_y3s1(St_id);

        Call<List<ModelScore>> call2 = ApiController_student
                .getInstance()
                .getapi_stu_score_y3s2()
                .get_stu_score_y3s2(St_id);

        call1.enqueue(new Callback<List<ModelScore>>() {
            @Override
            public void onResponse(Call<List<ModelScore>> call, Response<List<ModelScore>> response) {
                responsemodels = response.body();

                Adapter_score_semester myadapter = new Adapter_score_semester(responsemodels);
                if (responsemodels != null && !responsemodels.isEmpty()) {
                    ShowDialog.stopDialog();
                    student_study_plan_list_s1.setVisibility(View.VISIBLE);
                    student_study_plan_list_s1.setAdapter(myadapter);

                } else {
                    Toast.makeText(getActivity(), "No data found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ModelScore>> call, Throwable t) {
                Toast.makeText(getActivity(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
        call2.enqueue(new Callback<List<ModelScore>>() {
            @Override
            public void onResponse(Call<List<ModelScore>> call, Response<List<ModelScore>> response) {
                responsemodels = response.body();

                Adapter_score_semester myadapter = new Adapter_score_semester(responsemodels);
                if (responsemodels != null && !responsemodels.isEmpty()) {
                    ShowDialog.stopDialog();
                    student_study_plan_list_s2.setVisibility(View.VISIBLE);
                    student_study_plan_list_s2.setAdapter(myadapter);
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