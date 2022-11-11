package com.example.useaapp.GUEST.Home;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.useaapp.GUEST.Adapter.GuestCategoryAdapter;
import com.example.useaapp.GUEST.Career.GuestCareer;
import com.example.useaapp.GUEST.Events.GuestEvent;
import com.example.useaapp.GUEST.Program.GuestProgram;
import com.example.useaapp.GUEST.Registration.GuestRegistration;
import com.example.useaapp.GUEST.Scholarship.GuestScholarship;
import com.example.useaapp.R;
import com.example.useaapp.STUDENT.Login.StudentLogin;
import com.example.useaapp.STUDENT.MainStudentActivity;

import java.util.ArrayList;
import java.util.List;

public class FragmentGuestHome extends Fragment {
    private final static String SHARE_PREFNAME = "Student_Name";
    private final String[] tittleCategory = {"ព្រឹត្តិការណ៍", "ការចុះឈ្មោះ", "កម្មវិធីសិក្សា", "អាហាររូបករណ៍", "ព័ត៌មានការងារ", "គណនីសិស្ស"};
    private final int[] imageCategory = {R.drawable.news_icon, R.drawable.registration_icon, R.drawable.program_icon, R.drawable.scholarship_icon, R.drawable.career_icon, R.drawable.student_icon};
    SharedPreferences sharedPreferences;

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
        sharedPreferences = requireActivity().getSharedPreferences(SHARE_PREFNAME, MODE_PRIVATE);//method shared preference
        String Student_name = sharedPreferences.getString("name", "");//get name of student from sharedPreferenc

        categoryDashboard.setAdapter(new GuestCategoryAdapter(this.getContext(), tittleCategory, imageCategory));
        categoryDashboard.setOnItemClickListener((parent, view1, position, id) -> {
            switch (tittleCategory[position]) {
                case "ព្រឹត្តិការណ៍":
                    startActivity(new Intent(getContext(), GuestEvent.class));
                    break;
                case "ការចុះឈ្មោះ":
                    startActivity(new Intent(getContext(), GuestRegistration.class));
                    break;
                case "កម្មវិធីសិក្សា":
                    startActivity(new Intent(getContext(), GuestProgram.class));
                    break;
                case "អាហាររូបករណ៍":
                    startActivity(new Intent(getContext(), GuestScholarship.class));
                    break;
                case "ព័ត៌មានការងារ":
                    startActivity(new Intent(getContext(), GuestCareer.class));
                    break;
                case "គណនីសិស្ស":
                    //check if student already login
                    if (!Student_name.equals("")) {
                        requireActivity().finish();
                        startActivity(new Intent(requireContext(), MainStudentActivity.class));
                    } else {
                        requireActivity().finish();
                        startActivity(new Intent(requireContext(), StudentLogin.class));
                    }
                    break;
            }
        });
        return view;
    }
}