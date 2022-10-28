package com.example.useaapp.STUDENT.StudyPlan.year1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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

public class Fragment_student_Studyplan_y1s1s2_Thesis extends Fragment {

    RecyclerView student_study_plan_list_s1, student_study_plan_list_s2;
    TextView student_study_plan_total_credit_s1,student_study_plan_total_credit_s2;
    List<Response_model_SemesterStudyPlan_Thesis> responsemodels;
    public static final String text = "txt";
    String txt;
    int totalCredit1 = 0;
    int sumCredit1 = 0;
    int totalCredit2 = 0;
    int sumCredit2 = 0;

    Response_model_SemesterStudyPlan_Thesis semester;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_study_plan__y1s1s2_thesis, container, false);
        return v;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        student_study_plan_list_s1 = view.findViewById(R.id.student_study_plan_list_s1_th);
        student_study_plan_list_s1.setLayoutManager(new LinearLayoutManager(getActivity()));

        student_study_plan_list_s2 = view.findViewById(R.id.student_study_plan_list_s2_th);
        student_study_plan_list_s2.setLayoutManager(new LinearLayoutManager(getActivity()));

        student_study_plan_total_credit_s1 = view.findViewById(R.id.student_study_plan_total_credit_s1_th);
        student_study_plan_total_credit_s2 = view.findViewById(R.id.student_study_plan_total_credit_s2_th);

        txt = getActivity().getIntent().getStringExtra(text);
        if(txt.equals("19")){
            processdata1();
        }
    }

    public void processdata1() {
        Data_Progressing ShowDialog = new Data_Progressing(getContext());
        ShowDialog.showDialog();
        Call<List<Response_model_SemesterStudyPlan_Thesis>> call1 = ApiController_guest_program_faculty
                .getInstance()
                .getapi_fac2_mast_major_id2_mnm_y1s1()
                .get_guest_pro_fac_mast2_mnm_y1s1();

        Call<List<Response_model_SemesterStudyPlan_Thesis>> call2 = ApiController_guest_program_faculty
                .getInstance()
                .getapi_fac2_mast_major_id2_mnm_y1s2()
                .get_guest_pro_fac_mast2_mnm_y1s2();

        call1.enqueue(new Callback<List<Response_model_SemesterStudyPlan_Thesis>>() {
            @Override
            public void onResponse(Call<List<Response_model_SemesterStudyPlan_Thesis>> call, Response<List<Response_model_SemesterStudyPlan_Thesis>> response) {
                responsemodels = response.body();

                for (int i=0; i<responsemodels.size(); i++){
                    semester = responsemodels.get(i);
                    sumCredit1 = Integer.parseInt(semester.getCredits());
                    totalCredit1 += sumCredit1;
                }
                student_study_plan_total_credit_s1.setText(String.valueOf(totalCredit1));

                Adapter_student_Studyplan_Semester_Thesis myadapter = new Adapter_student_Studyplan_Semester_Thesis(responsemodels);
                if (responsemodels != null && !responsemodels.isEmpty()) {
                    ShowDialog.stopDialog();
                    student_study_plan_list_s1.setVisibility(View.VISIBLE);
                    student_study_plan_list_s1.setAdapter(myadapter);

                } else {
                    Toast.makeText(getActivity(), "No data found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Response_model_SemesterStudyPlan_Thesis>> call, Throwable t) {
                Toast.makeText(getActivity(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
        call2.enqueue(new Callback<List<Response_model_SemesterStudyPlan_Thesis>>() {
            @Override
            public void onResponse(Call<List<Response_model_SemesterStudyPlan_Thesis>> call, Response<List<Response_model_SemesterStudyPlan_Thesis>> response) {
                responsemodels = response.body();

                for (int i=0; i<responsemodels.size(); i++){
                    semester = responsemodels.get(i);
                    sumCredit2 = Integer.parseInt(semester.getCredits());
                    totalCredit2 += sumCredit2;
                }
                student_study_plan_total_credit_s2.setText(String.valueOf(totalCredit2));

                Adapter_student_Studyplan_Semester_Thesis myadapter = new Adapter_student_Studyplan_Semester_Thesis(responsemodels);
                if (responsemodels != null && !responsemodels.isEmpty()) {
                    ShowDialog.stopDialog();
                    student_study_plan_list_s2.setVisibility(View.VISIBLE);
                    student_study_plan_list_s2.setAdapter(myadapter);
                } else {
                    Toast.makeText(getActivity(), "No data found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Response_model_SemesterStudyPlan_Thesis>> call, Throwable t) {
                Toast.makeText(getActivity(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}