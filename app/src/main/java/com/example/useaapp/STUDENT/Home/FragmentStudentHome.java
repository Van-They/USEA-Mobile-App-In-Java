package com.example.useaapp.STUDENT.Home;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.useaapp.Data_Progressing;
import com.example.useaapp.GUEST.MainGuestActivity;
import com.example.useaapp.R;
import com.example.useaapp.STUDENT.Adapter.Adapter_category;
import com.example.useaapp.STUDENT.Adapter.Adapter_rank_credit;
import com.example.useaapp.STUDENT.ApiController_student;
import com.example.useaapp.STUDENT.Attendance.StudentAttendance;
import com.example.useaapp.STUDENT.Feedback.StudentFeedback;
import com.example.useaapp.STUDENT.Profile.StudentProfile;
import com.example.useaapp.STUDENT.Schedule.StudentSchedule;
import com.example.useaapp.STUDENT.Score.Score.StudentScore;
import com.example.useaapp.STUDENT.StudyPlan.StudentStudyPlan;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentStudentHome extends Fragment {

    public static final String text = "txt";
    private final static String SHARE_PREFNAME = "Student_Name";
    private final static String pf = "pf";
    //category
    private final String[] title_category = {"កាលវិភាគ", "ផែនការសិក្សា", "វត្តមាន", "មតិកែលម្អ", "ពិន្ទុ", "គណនីភ្ញៀវ"};
    private final int[] image_category = {R.drawable.calendar_icon,
            R.drawable.studyplan_icon, R.drawable.attendance_icon,
            R.drawable.feedback_icon, R.drawable.score_icon, R.drawable.guest_icon};
    private final String[] label_rank_credit = {"Student Rank", "Total Credit"};
    private final int[] image_rank_credit = {R.drawable.rank_icon, R.drawable.credit_icon};
    GridView gridView_category, gridView_card_rank_credit;
    SharedPreferences sharedPreferences;
    CircleImageView profile_dashboard;
    LinearLayout layout_main_student;
    //for card view rank and credit on dashboard
    // String[] rank_credit = {"#1st Rank", "300"};
    List<String> list;
    String Pf;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student_home, container, false);

        //name student on dashboard
        TextView student_name_dashboard = view.findViewById(R.id.student_name_dashboard);
        sharedPreferences = requireActivity().getSharedPreferences(SHARE_PREFNAME, Context.MODE_PRIVATE);
        String st_name = sharedPreferences.getString("name", "");

        list = new ArrayList<>();
//        list.add("N/A");
//        list.add("N/A");
        Pf = sharedPreferences.getString(pf, "");
        student_name_dashboard.setText(st_name);
        layout_main_student = view.findViewById(R.id.layout_main_student);
        //profile image
        profile_dashboard = view.findViewById(R.id.profile_dashboard);
        profile_dashboard.setOnClickListener(v ->
                startActivity(new Intent(getContext(), StudentProfile.class))
        );


        gridView_card_rank_credit = view.findViewById(R.id.gridview_rank_credit);
        gridView_category = view.findViewById(R.id.grid_view_dashboard);
        gridView_category.setAdapter(new Adapter_category(this.getContext(), title_category, image_category));
        gridView_category.setOnItemClickListener((parent, view1, position, id) -> {
            switch (title_category[position]) {
                case "កាលវិភាគ":
                    startActivity(new Intent(getContext(), StudentSchedule.class));
                    break;
                case "ផែនការសិក្សា":
                    Intent intent = new Intent(getContext(), StudentStudyPlan.class);
                    intent.putExtra(text, "txt");
                    startActivity(intent);
                    break;
                case "វត្តមាន":
                    startActivity(new Intent(getContext(), StudentAttendance.class));
                    break;
                case "មតិកែលម្អ":
                    startActivity(new Intent(getContext(), StudentFeedback.class));
                    break;
                case "ពិន្ទុ":
                    startActivity(new Intent(getContext(), StudentScore.class));
                    break;
                case "គណនីភ្ញៀវ":
                    startActivity(new Intent(getContext(), MainGuestActivity.class));
                    break;

            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String st_id = sharedPreferences.getString("Student_ID", "");
        Data_Progressing loading = new Data_Progressing(getContext());
        Call<Response_rank_credit> call = ApiController_student.getInstance().getApiCredit().getCreditRank(st_id);
        loading.showDialog();
        call.enqueue(new Callback<Response_rank_credit>() {
            @Override
            public void onResponse(Call<Response_rank_credit> call, Response<Response_rank_credit> response) {
                String credit = response.body().getCredit();
                String rank = response.body().getRank();
                String msg = response.body().getResponse();
                if (response.isSuccessful()) {
                    if (msg.equals("Failed")) {
                        loading.stopDialog();
                        layout_main_student.setVisibility(View.VISIBLE);
                        list.clear();
                        list.add("N/A");//rank
                        list.add("N/A");//credit
                    } else {
                        if (credit.isEmpty() && rank.isEmpty()) {
                            layout_main_student.setVisibility(View.VISIBLE);
                            loading.stopDialog();
                            list.clear();
                            list.add("N/A");//rank
                            list.add("N/A");//credit
                        } else if (!credit.isEmpty() && rank.equals("")) {
                            layout_main_student.setVisibility(View.VISIBLE);
                            loading.stopDialog();
                            list.clear();
                            list.add("N/A");//rank
                            list.add(credit);//credit
                        } else if (!rank.isEmpty() && credit.equals("")) {
                            layout_main_student.setVisibility(View.VISIBLE);
                            loading.stopDialog();
                            list.clear();
                            list.add("# " + rank);
                            list.add("N/A");//credit
                        } else {
                            layout_main_student.setVisibility(View.VISIBLE);
                            loading.stopDialog();
                            list.clear();
                            list.add("#" + rank);//rank
                            list.add(credit);//credit
                        }
                    }

                    Glide.with(requireContext()).
                            load("http://10.10.10.81/USEA/Student/profile_pic/" + Pf).
                            into(profile_dashboard);  //set profile image
                    gridView_card_rank_credit.setAdapter(new Adapter_rank_credit(getContext(), list, label_rank_credit, image_rank_credit));
                }
            }

            @Override
            public void onFailure(Call<Response_rank_credit> call, Throwable t) {
                loading.stopDialog();
                Log.d(TAG, "onFailure: " + t);
            }
        });
    }
}