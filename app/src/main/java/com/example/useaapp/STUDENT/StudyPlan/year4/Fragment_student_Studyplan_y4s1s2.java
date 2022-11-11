package com.example.useaapp.STUDENT.StudyPlan.year4;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useaapp.Data_Progressing;
import com.example.useaapp.GUEST.ApiController_guest;
import com.example.useaapp.R;
import com.example.useaapp.STUDENT.ApiController_student;
import com.example.useaapp.STUDENT.StudyPlan.year1.Adapter_student_Studyplan_Semester;
import com.example.useaapp.STUDENT.StudyPlan.year1.Response_model_SemesterStudyPlan;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_student_Studyplan_y4s1s2 extends Fragment {

    public static final String text = "txt";
    private final static String SHARE_PREFNAME = "Student_Name";
    SharedPreferences sharedPreferences;
    String st_id;
    TextView student_study_plan_total_hour_y4s1, student_study_plan_total_hour_y4s2, student_study_plan_total_credit_y4s1, student_study_plan_total_credit_y4s2;
    RecyclerView student_study_plan_list_s1, student_study_plan_list_s2;
    List<Response_model_SemesterStudyPlan> responsemodels;
    String txt;

    LinearLayout layout_text_no_data_p4, layout_data_p4;

    int totalHour1 = 0;
    int totalCredit1 = 0;
    int sumHour1 = 0;
    int sumCredit1 = 0;
    int totalHour2 = 0;
    int totalCredit2 = 0;
    int sumHour2 = 0;
    int sumCredit2 = 0;

    Response_model_SemesterStudyPlan semester;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_study_plan__y4_s1_s2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        student_study_plan_list_s1 = view.findViewById(R.id.student_study_plan_list_y4s1);
        student_study_plan_list_s1.setLayoutManager(new LinearLayoutManager(getActivity()));

        student_study_plan_list_s2 = view.findViewById(R.id.student_study_plan_list_y4s2);
        student_study_plan_list_s2.setLayoutManager(new LinearLayoutManager(getActivity()));

        layout_text_no_data_p4 = view.findViewById(R.id.layout_text_no_data_p4);
        layout_data_p4 = view.findViewById(R.id.layout_data_p4);

        student_study_plan_total_hour_y4s1 = view.findViewById(R.id.student_study_plan_total_hour_y4s1);
        student_study_plan_total_hour_y4s2 = view.findViewById(R.id.student_study_plan_total_hour_y4s2);
        student_study_plan_total_credit_y4s1 = view.findViewById(R.id.student_study_plan_total_credit_y4s1);
        student_study_plan_total_credit_y4s2 = view.findViewById(R.id.student_study_plan_total_credit_y4s2);

        txt = requireActivity().getIntent().getStringExtra(text);
        sharedPreferences = requireActivity().getSharedPreferences(SHARE_PREFNAME, Context.MODE_PRIVATE);
        st_id = sharedPreferences.getString("Student_ID", "");

        if (txt.equals("12")) {
            processdata1();
        } else if (txt.equals("13")) {
            processdata2();
        } else if (txt.equals("14")) {
            processdata3();
        } else if (txt.equals("15")) {
            processdata4();
        } else if (txt.equals("16")) {
            processdata5();
        } else if (txt.equals("17")) {
            processdata6();
        } else if (txt.equals("txt")) {
            processdata8();
        }
    }

    public void processdata1() {
        Data_Progressing ShowDialog = new Data_Progressing(getContext());
        ShowDialog.showDialog();
        Call<List<Response_model_SemesterStudyPlan>> call1 = ApiController_guest
                .getInstance()
                .getapi_fac3_bach_major_id3_it_y4s1()
                .get_guest_pro_fac_bac3_it_y4s1();

        Call<List<Response_model_SemesterStudyPlan>> call2 = ApiController_guest
                .getInstance()
                .getapi_fac3_bach_major_id3_it_y4s2()
                .get_guest_pro_fac_bac3_it_y4s2();

        call1.enqueue(new Callback<List<Response_model_SemesterStudyPlan>>() {
            @Override
            public void onResponse(Call<List<Response_model_SemesterStudyPlan>> call, Response<List<Response_model_SemesterStudyPlan>> response) {
                responsemodels = response.body();

                for (int i = 0; i < responsemodels.size(); i++) {
                    semester = responsemodels.get(i);
                    sumHour1 = Integer.parseInt(semester.getHours());
                    totalHour1 += sumHour1;
                }
                for (int i = 0; i < responsemodels.size(); i++) {
                    semester = responsemodels.get(i);
                    sumCredit1 = Integer.parseInt(semester.getCredits());
                    totalCredit1 += sumCredit1;
                }
                student_study_plan_total_hour_y4s1.setText(String.valueOf(totalHour1));
                student_study_plan_total_credit_y4s1.setText(String.valueOf(totalCredit1));

                Adapter_student_Studyplan_Semester myadapter = new Adapter_student_Studyplan_Semester(responsemodels);
                if (responsemodels != null && !responsemodels.isEmpty()) {
                    ShowDialog.stopDialog();
                    student_study_plan_list_s1.setAdapter(myadapter);
                } else {
                    ShowDialog.stopDialog();
                    layout_data_p4.setVisibility(View.GONE);
                    layout_text_no_data_p4.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<List<Response_model_SemesterStudyPlan>> call, Throwable t) {
                ShowDialog.stopDialog();
                layout_data_p4.setVisibility(View.GONE);
                layout_text_no_data_p4.setVisibility(View.VISIBLE);
            }
        });
        call2.enqueue(new Callback<List<Response_model_SemesterStudyPlan>>() {
            @Override
            public void onResponse(Call<List<Response_model_SemesterStudyPlan>> call, Response<List<Response_model_SemesterStudyPlan>> response) {
                responsemodels = response.body();

                for (int i = 0; i < responsemodels.size(); i++) {
                    semester = responsemodels.get(i);
                    sumHour2 = Integer.parseInt(semester.getHours());
                    totalHour2 += sumHour2;
                }
                for (int i = 0; i < responsemodels.size(); i++) {
                    semester = responsemodels.get(i);
                    sumCredit2 = Integer.parseInt(semester.getCredits());
                    totalCredit2 += sumCredit2;
                }
                student_study_plan_total_hour_y4s2.setText(String.valueOf(totalHour2));
                student_study_plan_total_credit_y4s2.setText(String.valueOf(totalCredit2));

                Adapter_student_Studyplan_Semester myadapter = new Adapter_student_Studyplan_Semester(responsemodels);
                if (responsemodels != null && !responsemodels.isEmpty()) {
                    ShowDialog.stopDialog();
                    student_study_plan_list_s2.setAdapter(myadapter);
                } else {
                    ShowDialog.stopDialog();
                    layout_data_p4.setVisibility(View.GONE);
                    layout_text_no_data_p4.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<List<Response_model_SemesterStudyPlan>> call, Throwable t) {
                ShowDialog.stopDialog();
                layout_data_p4.setVisibility(View.GONE);
                layout_text_no_data_p4.setVisibility(View.VISIBLE);
            }
        });
    }

    public void processdata2() {
        Data_Progressing ShowDialog = new Data_Progressing(getContext());
        ShowDialog.showDialog();
        Call<List<Response_model_SemesterStudyPlan>> call1 = ApiController_guest
                .getInstance()
                .getapi_fac3_bach_major_id3_math_y4s1()
                .get_guest_pro_fac_bac3_math_y4s1();

        Call<List<Response_model_SemesterStudyPlan>> call2 = ApiController_guest
                .getInstance()
                .getapi_fac3_bach_major_id3_math_y4s2()
                .get_guest_pro_fac_bac3_math_y4s2();

        call1.enqueue(new Callback<List<Response_model_SemesterStudyPlan>>() {
            @Override
            public void onResponse(Call<List<Response_model_SemesterStudyPlan>> call, Response<List<Response_model_SemesterStudyPlan>> response) {
                responsemodels = response.body();

                for (int i = 0; i < responsemodels.size(); i++) {
                    semester = responsemodels.get(i);
                    sumHour1 = Integer.parseInt(semester.getHours());
                    totalHour1 += sumHour1;
                }
                for (int i = 0; i < responsemodels.size(); i++) {
                    semester = responsemodels.get(i);
                    sumCredit1 = Integer.parseInt(semester.getCredits());
                    totalCredit1 += sumCredit1;
                }
                student_study_plan_total_hour_y4s1.setText(String.valueOf(totalHour1));
                student_study_plan_total_credit_y4s1.setText(String.valueOf(totalCredit1));

                Adapter_student_Studyplan_Semester myadapter = new Adapter_student_Studyplan_Semester(responsemodels);
                if (responsemodels != null && !responsemodels.isEmpty()) {
                    ShowDialog.stopDialog();
                    student_study_plan_list_s1.setAdapter(myadapter);
                } else {
                    ShowDialog.stopDialog();
                    layout_data_p4.setVisibility(View.GONE);
                    layout_text_no_data_p4.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<List<Response_model_SemesterStudyPlan>> call, Throwable t) {
                ShowDialog.stopDialog();
                layout_data_p4.setVisibility(View.GONE);
                layout_text_no_data_p4.setVisibility(View.VISIBLE);
            }
        });
        call2.enqueue(new Callback<List<Response_model_SemesterStudyPlan>>() {
            @Override
            public void onResponse(Call<List<Response_model_SemesterStudyPlan>> call, Response<List<Response_model_SemesterStudyPlan>> response) {
                responsemodels = response.body();

                for (int i = 0; i < responsemodels.size(); i++) {
                    semester = responsemodels.get(i);
                    sumHour2 = Integer.parseInt(semester.getHours());
                    totalHour2 += sumHour2;
                }
                for (int i = 0; i < responsemodels.size(); i++) {
                    semester = responsemodels.get(i);
                    sumCredit2 = Integer.parseInt(semester.getCredits());
                    totalCredit2 += sumCredit2;
                }
                student_study_plan_total_hour_y4s2.setText(String.valueOf(totalHour2));
                student_study_plan_total_credit_y4s2.setText(String.valueOf(totalCredit2));

                Adapter_student_Studyplan_Semester myadapter = new Adapter_student_Studyplan_Semester(responsemodels);
                if (responsemodels != null && !responsemodels.isEmpty()) {
                    ShowDialog.stopDialog();
                    student_study_plan_list_s2.setAdapter(myadapter);
                } else {
                    ShowDialog.stopDialog();
                    layout_data_p4.setVisibility(View.GONE);
                    layout_text_no_data_p4.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<List<Response_model_SemesterStudyPlan>> call, Throwable t) {
                ShowDialog.stopDialog();
                layout_data_p4.setVisibility(View.GONE);
                layout_text_no_data_p4.setVisibility(View.VISIBLE);
            }
        });
    }

    public void processdata3() {
        Data_Progressing ShowDialog = new Data_Progressing(getContext());
        ShowDialog.showDialog();
        Call<List<Response_model_SemesterStudyPlan>> call1 = ApiController_guest
                .getInstance()
                .getapi_fac2_bach_major_id2_acc_y4s1()
                .get_guest_pro_fac_bac2_acc_y4s1();

        Call<List<Response_model_SemesterStudyPlan>> call2 = ApiController_guest
                .getInstance()
                .getapi_fac2_bach_major_id2_acc_y4s2()
                .get_guest_pro_fac_bac2_acc_y4s2();

        call1.enqueue(new Callback<List<Response_model_SemesterStudyPlan>>() {
            @Override
            public void onResponse(Call<List<Response_model_SemesterStudyPlan>> call, Response<List<Response_model_SemesterStudyPlan>> response) {
                responsemodels = response.body();

                for (int i = 0; i < responsemodels.size(); i++) {
                    semester = responsemodels.get(i);
                    sumHour1 = Integer.parseInt(semester.getHours());
                    totalHour1 += sumHour1;
                }
                for (int i = 0; i < responsemodels.size(); i++) {
                    semester = responsemodels.get(i);
                    sumCredit1 = Integer.parseInt(semester.getCredits());
                    totalCredit1 += sumCredit1;
                }
                student_study_plan_total_hour_y4s1.setText(String.valueOf(totalHour1));
                student_study_plan_total_credit_y4s1.setText(String.valueOf(totalCredit1));

                Adapter_student_Studyplan_Semester myadapter = new Adapter_student_Studyplan_Semester(responsemodels);
                if (responsemodels != null && !responsemodels.isEmpty()) {
                    ShowDialog.stopDialog();
                    student_study_plan_list_s1.setAdapter(myadapter);
                } else {
                    ShowDialog.stopDialog();
                    layout_data_p4.setVisibility(View.GONE);
                    layout_text_no_data_p4.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<List<Response_model_SemesterStudyPlan>> call, Throwable t) {
                ShowDialog.stopDialog();
                layout_data_p4.setVisibility(View.GONE);
                layout_text_no_data_p4.setVisibility(View.VISIBLE);
            }
        });
        call2.enqueue(new Callback<List<Response_model_SemesterStudyPlan>>() {
            @Override
            public void onResponse(Call<List<Response_model_SemesterStudyPlan>> call, Response<List<Response_model_SemesterStudyPlan>> response) {
                responsemodels = response.body();

                for (int i = 0; i < responsemodels.size(); i++) {
                    semester = responsemodels.get(i);
                    sumHour2 = Integer.parseInt(semester.getHours());
                    totalHour2 += sumHour2;
                }
                for (int i = 0; i < responsemodels.size(); i++) {
                    semester = responsemodels.get(i);
                    sumCredit2 = Integer.parseInt(semester.getCredits());
                    totalCredit2 += sumCredit2;
                }
                student_study_plan_total_hour_y4s2.setText(String.valueOf(totalHour2));
                student_study_plan_total_credit_y4s2.setText(String.valueOf(totalCredit2));

                Adapter_student_Studyplan_Semester myadapter = new Adapter_student_Studyplan_Semester(responsemodels);
                if (responsemodels != null && !responsemodels.isEmpty()) {
                    ShowDialog.stopDialog();
                    student_study_plan_list_s2.setAdapter(myadapter);
                } else {
                    ShowDialog.stopDialog();
                    layout_data_p4.setVisibility(View.GONE);
                    layout_text_no_data_p4.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<List<Response_model_SemesterStudyPlan>> call, Throwable t) {
                ShowDialog.stopDialog();
                layout_data_p4.setVisibility(View.GONE);
                layout_text_no_data_p4.setVisibility(View.VISIBLE);
            }
        });
    }

    public void processdata4() {
        Data_Progressing ShowDialog = new Data_Progressing(getContext());
        ShowDialog.showDialog();
        Call<List<Response_model_SemesterStudyPlan>> call1 = ApiController_guest
                .getInstance()
                .getapi_fac2_bach_major_id2_fin_y4s1()
                .get_guest_pro_fac_bac2_fin_y4s1();

        Call<List<Response_model_SemesterStudyPlan>> call2 = ApiController_guest
                .getInstance()
                .getapi_fac2_bach_major_id2_fin_y4s2()
                .get_guest_pro_fac_bac2_fin_y4s2();

        call1.enqueue(new Callback<List<Response_model_SemesterStudyPlan>>() {
            @Override
            public void onResponse(Call<List<Response_model_SemesterStudyPlan>> call, Response<List<Response_model_SemesterStudyPlan>> response) {
                responsemodels = response.body();

                for (int i = 0; i < responsemodels.size(); i++) {
                    semester = responsemodels.get(i);
                    sumHour1 = Integer.parseInt(semester.getHours());
                    totalHour1 += sumHour1;
                }
                for (int i = 0; i < responsemodels.size(); i++) {
                    semester = responsemodels.get(i);
                    sumCredit1 = Integer.parseInt(semester.getCredits());
                    totalCredit1 += sumCredit1;
                }
                student_study_plan_total_hour_y4s1.setText(String.valueOf(totalHour1));
                student_study_plan_total_credit_y4s1.setText(String.valueOf(totalCredit1));

                Adapter_student_Studyplan_Semester myadapter = new Adapter_student_Studyplan_Semester(responsemodels);
                if (responsemodels != null && !responsemodels.isEmpty()) {
                    ShowDialog.stopDialog();
                    student_study_plan_list_s1.setAdapter(myadapter);
                } else {
                    ShowDialog.stopDialog();
                    layout_data_p4.setVisibility(View.GONE);
                    layout_text_no_data_p4.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<List<Response_model_SemesterStudyPlan>> call, Throwable t) {
                ShowDialog.stopDialog();
                layout_data_p4.setVisibility(View.GONE);
                layout_text_no_data_p4.setVisibility(View.VISIBLE);
            }
        });
        call2.enqueue(new Callback<List<Response_model_SemesterStudyPlan>>() {
            @Override
            public void onResponse(Call<List<Response_model_SemesterStudyPlan>> call, Response<List<Response_model_SemesterStudyPlan>> response) {
                responsemodels = response.body();

                for (int i = 0; i < responsemodels.size(); i++) {
                    semester = responsemodels.get(i);
                    sumHour2 = Integer.parseInt(semester.getHours());
                    totalHour2 += sumHour2;
                }
                for (int i = 0; i < responsemodels.size(); i++) {
                    semester = responsemodels.get(i);
                    sumCredit2 = Integer.parseInt(semester.getCredits());
                    totalCredit2 += sumCredit2;
                }
                student_study_plan_total_hour_y4s2.setText(String.valueOf(totalHour2));
                student_study_plan_total_credit_y4s2.setText(String.valueOf(totalCredit2));

                Adapter_student_Studyplan_Semester myadapter = new Adapter_student_Studyplan_Semester(responsemodels);
                if (responsemodels != null && !responsemodels.isEmpty()) {
                    ShowDialog.stopDialog();
                    student_study_plan_list_s2.setAdapter(myadapter);
                } else {
                    ShowDialog.stopDialog();
                    layout_data_p4.setVisibility(View.GONE);
                    layout_text_no_data_p4.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<List<Response_model_SemesterStudyPlan>> call, Throwable t) {
                ShowDialog.stopDialog();
                layout_data_p4.setVisibility(View.GONE);
                layout_text_no_data_p4.setVisibility(View.VISIBLE);
            }
        });
    }

    public void processdata5() {
        Data_Progressing ShowDialog = new Data_Progressing(getContext());
        ShowDialog.showDialog();
        Call<List<Response_model_SemesterStudyPlan>> call1 = ApiController_guest
                .getInstance()
                .getapi_fac4_bach_major_id4_mnm_y4s1()
                .get_guest_pro_fac_bac4_mnm_y4s1();

        Call<List<Response_model_SemesterStudyPlan>> call2 = ApiController_guest
                .getInstance()
                .getapi_fac4_bach_major_id4_mnm_y4s2()
                .get_guest_pro_fac_bac4_mnm_y4s2();

        call1.enqueue(new Callback<List<Response_model_SemesterStudyPlan>>() {
            @Override
            public void onResponse(Call<List<Response_model_SemesterStudyPlan>> call, Response<List<Response_model_SemesterStudyPlan>> response) {
                responsemodels = response.body();

                for (int i = 0; i < responsemodels.size(); i++) {
                    semester = responsemodels.get(i);
                    sumHour1 = Integer.parseInt(semester.getHours());
                    totalHour1 += sumHour1;
                }
                for (int i = 0; i < responsemodels.size(); i++) {
                    semester = responsemodels.get(i);
                    sumCredit1 = Integer.parseInt(semester.getCredits());
                    totalCredit1 += sumCredit1;
                }
                student_study_plan_total_hour_y4s1.setText(String.valueOf(totalHour1));
                student_study_plan_total_credit_y4s1.setText(String.valueOf(totalCredit1));

                Adapter_student_Studyplan_Semester myadapter = new Adapter_student_Studyplan_Semester(responsemodels);
                if (responsemodels != null && !responsemodels.isEmpty()) {
                    ShowDialog.stopDialog();
                    student_study_plan_list_s1.setAdapter(myadapter);
                } else {
                    ShowDialog.stopDialog();
                    layout_data_p4.setVisibility(View.GONE);
                    layout_text_no_data_p4.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<List<Response_model_SemesterStudyPlan>> call, Throwable t) {
                ShowDialog.stopDialog();
                layout_data_p4.setVisibility(View.GONE);
                layout_text_no_data_p4.setVisibility(View.VISIBLE);
            }
        });
        call2.enqueue(new Callback<List<Response_model_SemesterStudyPlan>>() {
            @Override
            public void onResponse(Call<List<Response_model_SemesterStudyPlan>> call, Response<List<Response_model_SemesterStudyPlan>> response) {
                responsemodels = response.body();

                for (int i = 0; i < responsemodels.size(); i++) {
                    semester = responsemodels.get(i);
                    sumHour2 = Integer.parseInt(semester.getHours());
                    totalHour2 += sumHour2;
                }
                for (int i = 0; i < responsemodels.size(); i++) {
                    semester = responsemodels.get(i);
                    sumCredit2 = Integer.parseInt(semester.getCredits());
                    totalCredit2 += sumCredit2;
                }
                student_study_plan_total_hour_y4s2.setText(String.valueOf(totalHour2));
                student_study_plan_total_credit_y4s2.setText(String.valueOf(totalCredit2));

                Adapter_student_Studyplan_Semester myadapter = new Adapter_student_Studyplan_Semester(responsemodels);
                if (responsemodels != null && !responsemodels.isEmpty()) {
                    ShowDialog.stopDialog();
                    student_study_plan_list_s2.setAdapter(myadapter);
                } else {
                    ShowDialog.stopDialog();
                    layout_data_p4.setVisibility(View.GONE);
                    layout_text_no_data_p4.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<List<Response_model_SemesterStudyPlan>> call, Throwable t) {
                ShowDialog.stopDialog();
                layout_data_p4.setVisibility(View.GONE);
                layout_text_no_data_p4.setVisibility(View.VISIBLE);
            }
        });
    }

    public void processdata6() {
        Data_Progressing ShowDialog = new Data_Progressing(getContext());
        ShowDialog.showDialog();
        Call<List<Response_model_SemesterStudyPlan>> call1 = ApiController_guest
                .getInstance()
                .getapi_fac4_bach_major_id4_kh_y4s1()
                .get_guest_pro_fac_bac4_kh_y4s1();

        Call<List<Response_model_SemesterStudyPlan>> call2 = ApiController_guest
                .getInstance()
                .getapi_fac4_bach_major_id4_kh_y4s2()
                .get_guest_pro_fac_bac4_kh_y4s2();

        call1.enqueue(new Callback<List<Response_model_SemesterStudyPlan>>() {
            @Override
            public void onResponse(Call<List<Response_model_SemesterStudyPlan>> call, Response<List<Response_model_SemesterStudyPlan>> response) {
                responsemodels = response.body();

                for (int i = 0; i < responsemodels.size(); i++) {
                    semester = responsemodels.get(i);
                    sumHour1 = Integer.parseInt(semester.getHours());
                    totalHour1 += sumHour1;
                }
                for (int i = 0; i < responsemodels.size(); i++) {
                    semester = responsemodels.get(i);
                    sumCredit1 = Integer.parseInt(semester.getCredits());
                    totalCredit1 += sumCredit1;
                }
                student_study_plan_total_hour_y4s1.setText(String.valueOf(totalHour1));
                student_study_plan_total_credit_y4s1.setText(String.valueOf(totalCredit1));

                Adapter_student_Studyplan_Semester myadapter = new Adapter_student_Studyplan_Semester(responsemodels);
                if (responsemodels != null && !responsemodels.isEmpty()) {
                    ShowDialog.stopDialog();
                    student_study_plan_list_s1.setAdapter(myadapter);
                } else {
                    ShowDialog.stopDialog();
                    layout_data_p4.setVisibility(View.GONE);
                    layout_text_no_data_p4.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<List<Response_model_SemesterStudyPlan>> call, Throwable t) {
                ShowDialog.stopDialog();
                layout_data_p4.setVisibility(View.GONE);
                layout_text_no_data_p4.setVisibility(View.VISIBLE);
            }
        });
        call2.enqueue(new Callback<List<Response_model_SemesterStudyPlan>>() {
            @Override
            public void onResponse(Call<List<Response_model_SemesterStudyPlan>> call, Response<List<Response_model_SemesterStudyPlan>> response) {
                responsemodels = response.body();

                for (int i = 0; i < responsemodels.size(); i++) {
                    semester = responsemodels.get(i);
                    sumHour2 = Integer.parseInt(semester.getHours());
                    totalHour2 += sumHour2;
                }
                for (int i = 0; i < responsemodels.size(); i++) {
                    semester = responsemodels.get(i);
                    sumCredit2 = Integer.parseInt(semester.getCredits());
                    totalCredit2 += sumCredit2;
                }
                student_study_plan_total_hour_y4s2.setText(String.valueOf(totalHour2));
                student_study_plan_total_credit_y4s2.setText(String.valueOf(totalCredit2));

                Adapter_student_Studyplan_Semester myadapter = new Adapter_student_Studyplan_Semester(responsemodels);
                if (responsemodels != null && !responsemodels.isEmpty()) {
                    ShowDialog.stopDialog();
                    student_study_plan_list_s2.setAdapter(myadapter);
                } else {
                    ShowDialog.stopDialog();
                    layout_data_p4.setVisibility(View.GONE);
                    layout_text_no_data_p4.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<List<Response_model_SemesterStudyPlan>> call, Throwable t) {
                ShowDialog.stopDialog();
                layout_data_p4.setVisibility(View.GONE);
                layout_text_no_data_p4.setVisibility(View.VISIBLE);
                ;
            }
        });
    }

    public void processdata8() {
        Data_Progressing ShowDialog = new Data_Progressing(getContext());
        ShowDialog.showDialog();
        Call<List<Response_model_SemesterStudyPlan>> call1 = ApiController_student
                .getInstance()
                .getapi_stu_studyplan_y4s1()
                .get_stu_studyplan_y4s1(st_id);

        Call<List<Response_model_SemesterStudyPlan>> call2 = ApiController_student
                .getInstance()
                .getapi_stu_studyplan_y4s2()
                .get_stu_studyplan_y4s2(st_id);

        call1.enqueue(new Callback<List<Response_model_SemesterStudyPlan>>() {
            @Override
            public void onResponse(Call<List<Response_model_SemesterStudyPlan>> call, Response<List<Response_model_SemesterStudyPlan>> response) {
                responsemodels = response.body();

                for (int i = 0; i < responsemodels.size(); i++) {
                    semester = responsemodels.get(i);
                    sumHour1 = Integer.parseInt(semester.getHours());
                    totalHour1 += sumHour1;
                }
                for (int i = 0; i < responsemodels.size(); i++) {
                    semester = responsemodels.get(i);
                    sumCredit1 = Integer.parseInt(semester.getCredits());
                    totalCredit1 += sumCredit1;
                }
                student_study_plan_total_hour_y4s1.setText(String.valueOf(totalHour1));
                student_study_plan_total_credit_y4s1.setText(String.valueOf(totalCredit1));

                Adapter_student_Studyplan_Semester myadapter = new Adapter_student_Studyplan_Semester(responsemodels);
                if (responsemodels != null && !responsemodels.isEmpty()) {
                    ShowDialog.stopDialog();
                    student_study_plan_list_s1.setAdapter(myadapter);
                } else {
                    ShowDialog.stopDialog();
                    layout_data_p4.setVisibility(View.GONE);
                    layout_text_no_data_p4.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<List<Response_model_SemesterStudyPlan>> call, Throwable t) {
                ShowDialog.stopDialog();
                layout_data_p4.setVisibility(View.GONE);
                layout_text_no_data_p4.setVisibility(View.VISIBLE);
            }
        });
        call2.enqueue(new Callback<List<Response_model_SemesterStudyPlan>>() {
            @Override
            public void onResponse(Call<List<Response_model_SemesterStudyPlan>> call, Response<List<Response_model_SemesterStudyPlan>> response) {
                responsemodels = response.body();

                for (int i = 0; i < responsemodels.size(); i++) {
                    semester = responsemodels.get(i);
                    sumHour2 = Integer.parseInt(semester.getHours());
                    totalHour2 += sumHour2;
                }
                for (int i = 0; i < responsemodels.size(); i++) {
                    semester = responsemodels.get(i);
                    sumCredit2 = Integer.parseInt(semester.getCredits());
                    totalCredit2 += sumCredit2;
                }
                student_study_plan_total_hour_y4s2.setText(String.valueOf(totalHour2));
                student_study_plan_total_credit_y4s2.setText(String.valueOf(totalCredit2));

                Adapter_student_Studyplan_Semester myadapter = new Adapter_student_Studyplan_Semester(responsemodels);
                if (responsemodels != null && !responsemodels.isEmpty()) {
                    ShowDialog.stopDialog();
                    student_study_plan_list_s2.setAdapter(myadapter);
                } else {
                    ShowDialog.stopDialog();
                    layout_data_p4.setVisibility(View.GONE);
                    layout_text_no_data_p4.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<List<Response_model_SemesterStudyPlan>> call, Throwable t) {
                ShowDialog.stopDialog();
                layout_data_p4.setVisibility(View.GONE);
                layout_text_no_data_p4.setVisibility(View.VISIBLE);
            }
        });
    }
}