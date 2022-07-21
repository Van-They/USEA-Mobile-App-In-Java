package com.example.useaapp.guest.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.useaapp.R;
import com.example.useaapp.guest.adapter.GuestCategoryAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentGuestHome extends Fragment {

    private final String[] tittleCategory = {"ព្រឹត្តិការណ៍","ការចុះឈ្មោះ","កម្មវិធីសិក្សា","អាហាររូបករណ៍","ព័ត៌មានការងារ","គណីសិស្ស"};
    private final int[] imageCategory = {R.drawable.news_icon,R.drawable.registration_icon,R.drawable.program_icon,R.drawable.scholarship_icon,R.drawable.career_icon,R.drawable.student_icon};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_guest_home, container, false);
        ImageSlider slide_image = view.findViewById(R.id.slide_image);

        List<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.sale, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.store, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.students, ScaleTypes.FIT));
        slide_image.setImageList(slideModels, ScaleTypes.FIT);

        GridView categoryDashboard = view.findViewById(R.id.categoryDashboard);
        categoryDashboard.setAdapter(new GuestCategoryAdapter(this.getContext(),tittleCategory,imageCategory));

        return view;
    }
}