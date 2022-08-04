package com.example.useaapp.guest.guest_home;

import android.content.Intent;
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
import com.example.useaapp.guest.guest_events.GuestEvent;
import com.example.useaapp.guest.guest_registration.GuestRegistration;
import com.example.useaapp.student.MainStudentActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FragmentGuestHome extends Fragment {

    private final String[] tittleCategory = {"ព្រឹត្តិការណ៍", "ការចុះឈ្មោះ", "កម្មវិធីសិក្សា", "អាហាររូបករណ៍", "ព័ត៌មានការងារ", "គណនីសិស្ស"};
    private final int[] imageCategory = {R.drawable.news_icon, R.drawable.registration_icon, R.drawable.program_icon, R.drawable.scholarship_icon, R.drawable.career_icon, R.drawable.student_icon};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_guest_home, container, false);
        ImageSlider slide_image = view.findViewById(R.id.SlideImageDashboard);

        List<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.sale, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.store, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.students, ScaleTypes.FIT));
        slide_image.setImageList(slideModels, ScaleTypes.FIT);

        GridView categoryDashboard = view.findViewById(R.id.categoryDashboard);
        categoryDashboard.setAdapter(new GuestCategoryAdapter(this.getContext(), tittleCategory, imageCategory));

        categoryDashboard.setOnItemClickListener((parent, view1, position, id) -> {
            if (Objects.equals(tittleCategory[position], "ព្រឹត្តិការណ៍")) {
                Toast.makeText(getContext(), tittleCategory[position], Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), GuestEvent.class));
            } else if (Objects.equals(tittleCategory[position], "ការចុះឈ្មោះ")) {
                Intent intent = new Intent(getActivity(), GuestRegistration.class);
                startActivity(intent);
                Toast.makeText(getContext(), tittleCategory[position], Toast.LENGTH_SHORT).show();
            } else if (Objects.equals(tittleCategory[position], "កម្មវិធីសិក្សា")) {
                Toast.makeText(getContext(), tittleCategory[position], Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), GuestEvent.class));
            } else if (Objects.equals(tittleCategory[position], "អាហាររូបករណ៍")) {
                Toast.makeText(getContext(), tittleCategory[position], Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), GuestEvent.class));
            } else if (Objects.equals(tittleCategory[position], "ព័ត៌មានការងារ")) {
                Toast.makeText(getContext(), tittleCategory[position], Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), GuestEvent.class));
            } else if (Objects.equals(tittleCategory[position], "គណនីសិស្ស")) {
                Toast.makeText(getContext(), tittleCategory[position], Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), MainStudentActivity.class));
            }
        });

        return view;
    }
}