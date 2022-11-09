//package com.example.useaapp.STUDENT.StudyPlan.year1;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ListView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.fragment.app.Fragment;
//
//import com.example.useaapp.Data_Progressing;
//import com.example.useaapp.GUEST.Program.ApiController_guest_program_faculty;
//import com.example.useaapp.R;
//import com.example.useaapp.STUDENT.Adapter.ListviewHelper;
//
//import java.util.List;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class FragmentStudyPlan_Y1S1S2 extends Fragment {
//
//    TextView Total_hour_s1, Total_credit_s1, Total_hour_s2, Total_credit_s2;
//    ListView listView_s1, listView_s2;
////    ArrayList<SemesterStudyPlan> semester1, semester2;
////    SemesterStudyPlan semester;
//    Response_model_SemesterStudyPlan semester;
//    List<Response_model_SemesterStudyPlan> responsemodels;
//    Adapter_Studyplan_Semester myadapter;
//    int totalHour1 = 0;
//    int totalCredit1 = 0;
//    int sumHour1 = 0;
//    int sumCredit1 = 0;
//    int totalHour2 = 0;
//    int totalCredit2 = 0;
//    int sumHour2 = 0;
//    int sumCredit2 = 0;
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_study_plan__y1s1s2, container, false);
//        listView_s1 = view.findViewById(R.id.student_study_plan_list_s1);
//        listView_s2 = view.findViewById(R.id.student_study_plan_list_s2);
//
//        //semester 1,2 listview with array list
////        addDataToListS1();
////        addDataToListS2();
//
//        //calculate total hour
//        //setAdapter
//
//
//        Toast.makeText(getContext(), "This is Vanthey", Toast.LENGTH_SHORT).show();
//
//
//        Total_hour_s1 = view.findViewById(R.id.student_study_plan_total_hour_s1);
//        Total_credit_s1 = view.findViewById(R.id.student_study_plan_total_credit_s1);
//        Total_hour_s2 = view.findViewById(R.id.student_study_plan_total_hour_s2);
//        Total_credit_s2 = view.findViewById(R.id.student_study_plan_total_credit_s2);
//
////        totalHour_Credit_S1();
////        totalHour_Credit_S2();
//
//        processdata1();
//        return view;
//    }
//    public void processdata1() {
//        Data_Progressing ShowDialog = new Data_Progressing(getContext());
//        ShowDialog.showDialog();
//        Call<List<Response_model_SemesterStudyPlan>> call1 = ApiController_guest_program_faculty
//                .getInstance()
//                .getapi_fac3_bach_major_id3_it_y1s1()
//                .get_guest_pro_fac_bac3_it_y1s1();
//
//        call1.enqueue(new Callback<List<Response_model_SemesterStudyPlan>>() {
//            @Override
//            public void onResponse(Call<List<Response_model_SemesterStudyPlan>> call, Response<List<Response_model_SemesterStudyPlan>> response) {
//                responsemodels = response.body();
//
//                for (int i = 0; i < responsemodels.size(); i++) {
//                    semester = responsemodels.get(i);
//                    sumHour1 = Integer.parseInt(semester.getHours());
//                    totalHour1 += sumHour1;
//                }
//                for (int i = 0; i < responsemodels.size(); i++) {
//                    semester = responsemodels.get(i);
//                    sumCredit1 = Integer.parseInt(semester.getCredits());
//                    totalCredit1 += sumCredit1;
//                }
//                Total_hour_s1.setText(String.valueOf(totalHour1));
//                Total_credit_s1.setText(String.valueOf(totalCredit1));
//
//                myadapter = new Adapter_Studyplan_Semester(requireContext(),responsemodels);
//                if (responsemodels != null && !responsemodels.isEmpty()) {
//                    ShowDialog.stopDialog();
//                    listView_s1.setAdapter(myadapter);
//                    ListviewHelper.getLisViewSize(listView_s1);
//
//                } else {
//                    Toast.makeText(getActivity(), "No data found", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Response_model_SemesterStudyPlan>> call, Throwable t) {
//                Toast.makeText(getActivity(), "Failed", Toast.LENGTH_LONG).show();
//            }
//        });
//        Call<List<Response_model_SemesterStudyPlan>> call2 = ApiController_guest_program_faculty
//                .getInstance()
//                .getapi_fac3_bach_major_id3_it_y1s2()
//                .get_guest_pro_fac_bac3_it_y1s2();
//        call2.enqueue(new Callback<List<Response_model_SemesterStudyPlan>>() {
//            @Override
//            public void onResponse(Call<List<Response_model_SemesterStudyPlan>> call, Response<List<Response_model_SemesterStudyPlan>> response) {
//                responsemodels = response.body();
//                for (int i = 0; i < responsemodels.size(); i++) {
//                    semester = responsemodels.get(i);
//                    sumHour2 = Integer.parseInt(semester.getHours());
//                    totalHour2 += sumHour2;
//                }
//                for (int i = 0; i < responsemodels.size(); i++) {
//                    semester = responsemodels.get(i);
//                    sumCredit2 = Integer.parseInt(semester.getCredits());
//                    totalCredit2 += sumCredit2;
//                }
//                Total_hour_s2.setText(String.valueOf(totalHour2));
//                Total_credit_s2.setText(String.valueOf(totalCredit2));
//
//                myadapter = new Adapter_Studyplan_Semester(requireContext(),responsemodels);
//                if (responsemodels != null && !responsemodels.isEmpty()) {
//                    ShowDialog.stopDialog();
//                    listView_s2.setAdapter(myadapter);
//                    ListviewHelper.getLisViewSize(listView_s2);
//
//                } else {
//                    Toast.makeText(getActivity(), "No data found", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Response_model_SemesterStudyPlan>> call, Throwable t) {
//                Toast.makeText(getActivity(), "Failed", Toast.LENGTH_LONG).show();
//            }
//        });
//    }
//
////    private void addDataToListS1() {
////        semester1 = new ArrayList<>();
////        semester1.add(new SemesterStudyPlan("1.", "Java Programing I", "45", "3"));
////        semester1.add(new SemesterStudyPlan("2.", "ប្រវត្តិ និងវប្បធម៍អាស៊ីអាគ្នេយ៍", "45", "3"));
////        semester1.add(new SemesterStudyPlan("3.", "រដ្ឋបាយសាធារណៈ", "45", "3"));
////        semester1.add(new SemesterStudyPlan("4.", "កុំព្យូទ័រសម្រាប់រដ្ខបាល", "45", "3"));
////        semester1.add(new SemesterStudyPlan("5.", "ភាសាអង់គ្លេស", "45", "3"));
////        semester1.add(new SemesterStudyPlan("6.", "ភាសាចិន", "45", "0"));
////    }
////
////    private void addDataToListS2() {
////
////        semester2 = new ArrayList<>();
////        semester2.add(new SemesterStudyPlan("1.", "Java Programing II", "45", "3"));
////        semester2.add(new SemesterStudyPlan("2.", "ប្រវត្តិ និងវប្បធម៍អាស៊ីអាគ្នេយ៍", "45", "3"));
////        semester2.add(new SemesterStudyPlan("3.", "រដ្ឋបាយសាធារណៈ", "45", "3"));
////        semester2.add(new SemesterStudyPlan("4.", "កុំព្យូទ័រសម្រាប់រដ្ខបាល", "45", "3"));
////        semester2.add(new SemesterStudyPlan("5.", "ភាសាអង់គ្លេស", "45", "3"));
////        semester2.add(new SemesterStudyPlan("6.", "ភាសាចិន", "45", "0"));
////
////    }
//
////    void totalHour_Credit_S1() {
////        int totalHour = 0;
////        int totalCredit = 0;
////        int sumHour;
////        int sumCredit;
////        for (int i = 0; i < semester1.size(); i++) {
////            semester = semester1.get(i);
////            sumHour = Integer.parseInt(semester.getHour());
////            totalHour += sumHour;
////        }
////        for (int i = 0; i < semester1.size(); i++) {
////            semester = semester1.get(i);
////            sumCredit = Integer.parseInt(semester.getCredit());
////            totalCredit += sumCredit;
////        }
////        Total_hour_s1.setText(String.valueOf(totalHour));
////        Total_credit_s1.setText(String.valueOf(totalCredit));
////    }
//
////    void totalHour_Credit_S2() {
////        int totalHour = 0;
////        int totalCredit = 0;
////        int sumHour;
////        int sumCredit;
////        for (int i = 0; i < semester2.size(); i++) {
////            semester = semester2.get(i);
////            sumHour = Integer.parseInt(semester.getHour());
////            totalHour += sumHour;
////        }
////        for (int i = 0; i < semester2.size(); i++) {
////            semester = semester2.get(i);
////            sumCredit = Integer.parseInt(semester.getCredit());
////            totalCredit += sumCredit;
////        }
////        Total_hour_s2.setText(String.valueOf(totalHour));
////        Total_credit_s2.setText(String.valueOf(totalCredit));
////    }
//
//}