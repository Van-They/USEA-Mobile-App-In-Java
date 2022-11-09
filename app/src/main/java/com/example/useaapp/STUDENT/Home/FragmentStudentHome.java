package com.example.useaapp.STUDENT.Home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.useaapp.GUEST.Login.GuestLogin;
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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentStudentHome extends Fragment {

    public static final String text = "txt";
    private final static String SHARE_PREFNAME = "Student_Name";
    private final static String PROFILE_NAME = "Profile_Picture";
    private final static String major_name = "major_name";
    private final static String stage = "stage";
    private final static String academic = "academic";
    private final static String shift = "shift";
    private final static String dob = "dob";
    private final static String ph = "ph";
    private final static String pf = "pf";
    //category
    private final String[] title_category = {"កាលវិភាគ", "ផែនការសិក្សា", "វត្តមាន", "មតិកែលម្អ", "ពិន្ទុ", "គណនីភ្ញៀវ"};
    private final int[] image_category = {R.drawable.calendar_icon,
            R.drawable.studyplan_icon, R.drawable.attendance_icon,
            R.drawable.feedback_icon, R.drawable.score_icon, R.drawable.guest_icon};
    private final String[] label_rank_credit = {"Student Rank", "Total Credit"};
    private final int[] image_rank_credit = {R.drawable.rank_icon, R.drawable.credit_icon};
    SharedPreferences sharedPreferences;
    CircleImageView profile_dashboard;
    //for card view rank and credit on dashboard
    // String[] rank_credit = {"#1st Rank", "300"};
    List<String> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student_home, container, false);
        GridView gridView_category, gridView_card_rank_credit;
        //name student on dashboard
        TextView student_name_dashboard = view.findViewById(R.id.student_name_dashboard);
        sharedPreferences = requireActivity().getSharedPreferences(SHARE_PREFNAME, Context.MODE_PRIVATE);
        String st_name = sharedPreferences.getString("name", "");

        list = new ArrayList<String>();
        list.add("N/A");
        list.add("N/A");
        String Maj = sharedPreferences.getString(major_name, "");
        String Sta = sharedPreferences.getString(stage, "");
        String Aca = sharedPreferences.getString(academic, "");
        String Shi = sharedPreferences.getString(shift, "");
        String Dob = sharedPreferences.getString(dob, "");
        String Pho = sharedPreferences.getString(ph, "");
        String Pf = sharedPreferences.getString(pf, "");
        student_name_dashboard.setText(st_name);

        //profile image
        profile_dashboard = view.findViewById(R.id.profile_dashboard);
        profile_dashboard.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(major_name, Maj);
            editor.putString(stage, Sta);
            editor.putString(academic, Aca);
            editor.putString(shift, Shi);
            editor.putString(dob, Dob);
            editor.putString(ph, Pho);
            editor.putString(pf, Pf);
            editor.apply();
            Intent intent = new Intent(getContext(), StudentProfile.class);
            startActivity(intent);
//            startActivity(new Intent(getContext(), StudentProfile.class));
        });

        //set profile image
        Glide.with(requireContext()).
                load("http://192.168.0.170/USEA/Student/profile_pic/" + Pf).
                into(profile_dashboard);

        gridView_card_rank_credit = view.findViewById(R.id.gridview_rank_credit);
        gridView_card_rank_credit.setAdapter(new Adapter_rank_credit(this.getContext(), list, label_rank_credit, image_rank_credit));
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
                    FirebaseUser mUser = FirebaseAuth.getInstance().getCurrentUser();
                    if (mUser != null) {
                        startActivity(new Intent(getContext(), MainGuestActivity.class));
                    } else {
                        startActivity(new Intent(getContext(), GuestLogin.class));
                    }
                    break;

            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String st_id = sharedPreferences.getString("Student_ID", "");
        Call<Response_rank_credit> call = ApiController_student.getInstance().getApiCredit().getCredit(st_id);
        call.enqueue(new Callback<Response_rank_credit>() {
            @Override
            public void onResponse(Call<Response_rank_credit> call, Response<Response_rank_credit> response) {
                if (response.isSuccessful()) {
                    list.add("N/A");
                    list.add("N/A");
                    String credit = response.body().getCredit();
                    list.add(credit);
                }
            }

            @Override
            public void onFailure(Call<Response_rank_credit> call, Throwable t) {
                Toast.makeText(requireContext(), "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        sharedPreferences = requireActivity().getSharedPreferences(PROFILE_NAME, Context.MODE_PRIVATE);
        String image = sharedPreferences.getString("My_Profile", null);
        if (image != null) {
            profile_dashboard.setImageURI(Uri.parse(image));
        }
    }
}