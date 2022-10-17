package com.example.useaapp.STUDENT.Home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.useaapp.R;
import com.example.useaapp.GUEST.MainGuestActivity;
import com.example.useaapp.STUDENT.Adapter.Adapter_category;
import com.example.useaapp.STUDENT.Adapter.Adapter_rank_credit;
import com.example.useaapp.STUDENT.Attendance.StudentAttendance;
import com.example.useaapp.STUDENT.Feedback.StudentFeedback;
import com.example.useaapp.STUDENT.Profile.StudentProfile;
import com.example.useaapp.STUDENT.Schedule.StudentSchedule;
import com.example.useaapp.STUDENT.Score.Score.StudentScore;
import com.example.useaapp.STUDENT.StudyPlan.StudentStudyPlan;

import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

public class FragmentStudentHome extends Fragment {

    SharedPreferences sharedPreferences;
    private final static String SHARE_PREFNAME = "Student_Name";

    //category
    private final String[] title_category = {"កាលវិភាគ", "ផែនការសិក្សា", "វត្តមាន", "មតិកែលម្អ", "ពិន្ទុ", "គណនីភ្ញៀវ"};
    private final int[] image_category = {R.drawable.calendar_icon,
            R.drawable.studyplan_icon, R.drawable.attendance_icon,
            R.drawable.feedback_icon, R.drawable.score_icon, R.drawable.guest_icon};
    //for card view rank and credit on dashboard
    String[] rank_credit = {"#1st Rank", "300"};
    private final String[] label_rank_credit = {"Student Rank", "Total Credit"};
    private final int[] image_rank_credit = {R.drawable.rank_icon, R.drawable.credit_icon};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student_home, container, false);
        GridView gridView_category, gridView_card_rank_credit;
        //name student on dashboard
        TextView student_name_dashboard = view.findViewById(R.id.student_name_dashboard);
        sharedPreferences = getActivity().getSharedPreferences(SHARE_PREFNAME, Context.MODE_PRIVATE);
        String st_id = sharedPreferences.getString("name", "");
        if (st_id != null) {
            student_name_dashboard.setText(st_id);
        }
        //profile image
        CircleImageView profile_dashboard = view.findViewById(R.id.profile_dashboard);
        profile_dashboard.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), StudentProfile.class);
            startActivity(intent);
//            startActivity(new Intent(getContext(), StudentProfile.class));
        });
        gridView_card_rank_credit = view.findViewById(R.id.gridview_rank_credit);
        gridView_card_rank_credit.setAdapter(new Adapter_rank_credit(this.getContext(), rank_credit, label_rank_credit, image_rank_credit));

        gridView_category = view.findViewById(R.id.grid_view_dashboard);
        gridView_category.setAdapter(new Adapter_category(this.getContext(), title_category, image_category));
        gridView_category.setOnItemClickListener((parent, view1, position, id) -> {
            if (Objects.equals(title_category[position], "កាលវិភាគ")) {
                Toast.makeText(getContext(), title_category[position], Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(), StudentSchedule.class));
            } else if (Objects.equals(title_category[position], "ផែនការសិក្សា")) {
                Toast.makeText(getContext(), title_category[position], Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(), StudentStudyPlan.class));
            } else if (Objects.equals(title_category[position], "វត្តមាន")) {
                Toast.makeText(getContext(), title_category[position], Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(), StudentAttendance.class));
            } else if (Objects.equals(title_category[position], "មតិកែលម្អ")) {
                Toast.makeText(getContext(), title_category[position], Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(), StudentFeedback.class));
            } else if (Objects.equals(title_category[position], "ពិន្ទុ")) {
                Toast.makeText(getContext(), title_category[position], Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(), StudentScore.class));
            } else if (Objects.equals(title_category[position], "គណនីភ្ញៀវ")) {
                Toast.makeText(getContext(), title_category[position], Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(), MainGuestActivity.class));
            }
        });
        return view;
    }
}