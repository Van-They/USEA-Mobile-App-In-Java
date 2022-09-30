package com.example.useaapp.guest.guest_home;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.useaapp.R;
import com.example.useaapp.guest.guest_adapter.GuestCategoryAdapter;
import com.example.useaapp.guest.guest_career.GuestCareer;
import com.example.useaapp.guest.guest_events.GuestEvent;
import com.example.useaapp.guest.guest_program.GuestProgram;
import com.example.useaapp.guest.guest_registration.GuestRegistration;
import com.example.useaapp.guest.guest_scholarship.GuestScholarship;
import com.example.useaapp.student.MainStudentActivity;
import com.example.useaapp.student.student_login.StudentLogin;

import java.util.ArrayList;
import java.util.List;

public class FragmentGuestHome extends Fragment {
    SharedPreferences sharedPreferences;
    private final static String SHARED_PREF_NAME = "mypref";
    private final static String KEY_STUDENT_ID = "student_id";
    private final static String KEY_PWD = "pwd";
    private final String[] tittleCategory = {"ព្រឹត្តិការណ៍", "ការចុះឈ្មោះ", "កម្មវិធីសិក្សា", "អាហាររូបករណ៍", "ព័ត៌មានការងារ", "គណនីសិស្ស"};
    private final int[] imageCategory = {R.drawable.news_icon, R.drawable.registration_icon, R.drawable.program_icon, R.drawable.scholarship_icon, R.drawable.career_icon, R.drawable.student_icon};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_guest_home, container, false);

        ImageSlider slide_image = view.findViewById(R.id.SlideImageHome);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.sale, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.students, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.store, ScaleTypes.FIT));
        slide_image.setImageList(slideModels, ScaleTypes.FIT);

        GridView categoryDashboard = view.findViewById(R.id.categoryDashboard);
        categoryDashboard.setAdapter(new GuestCategoryAdapter(this.getContext(), tittleCategory, imageCategory));
        categoryDashboard.setOnItemClickListener((parent, view1, position, id) -> {
            switch (tittleCategory[position]){
                case "ព្រឹត្តិការណ៍":
                    startActivity(new Intent(getContext(), GuestEvent.class));
                    break;
                case "ការចុះឈ្មោះ":
                    startActivity(new Intent(getContext(),GuestRegistration.class));
                    break;
                case "កម្មវិធីសិក្សា":
                    Toast.makeText(getContext(), tittleCategory[position], Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getContext(), GuestProgram.class));
                    break;
                case "អាហាររូបករណ៍":
                    Toast.makeText(getContext(), tittleCategory[position], Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getContext(), GuestScholarship.class));
                    break;
                case "ព័ត៌មានការងារ":
                    Toast.makeText(getContext(), tittleCategory[position], Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getContext(), GuestCareer.class));
                    break;
                case "គណនីសិស្ស":
                    sharedPreferences = getActivity().getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
                    String st_id = sharedPreferences.getString(KEY_STUDENT_ID, "");
                    if (st_id != null && !st_id.equals("")){
                        startActivity(new Intent(getContext(),MainStudentActivity.class));
                    }else{
                        startActivity(new Intent(getContext(), StudentLogin.class));
                    }
                    break;
            }
       });
        return view;
    }
}