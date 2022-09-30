package com.example.useaapp.guest.guest_events;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.useaapp.R;
import com.example.useaapp.guest.guest_adapter.Adapter_guest_event_tabbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GuestEvent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_event);
        Toolbar toolbar = findViewById(R.id.CustomActionbarGuestEvent);
        setSupportActionBar(toolbar);
        setTitle(R.string.GuestEvent);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(view -> finish());
        TabLayout tablayout = findViewById(R.id.tab_menu_guest_event);
        ViewPager2 pager2 = findViewById(R.id.view_pager_menu_guest_event);

        ImageSlider slide_image = findViewById(R.id.SlideImageEvent);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.sale, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.students, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.store, ScaleTypes.FIT));
        slide_image.setImageList(slideModels, ScaleTypes.FIT);

        String[] event_tab = {"សេចក្ដីប្រកាស", "ព្រឹត្តិការណ៍នាពេលខាងមុខ", "ព្រិត្តិការណ៍បច្ចុប្បន្ន", "ព្រិត្តិការណ៍ខាងមុនៗ"};
        pager2.setAdapter(new Adapter_guest_event_tabbar(this));
        new TabLayoutMediator(tablayout, pager2, (tab, position) -> tab.setText(event_tab[position])).attach();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}