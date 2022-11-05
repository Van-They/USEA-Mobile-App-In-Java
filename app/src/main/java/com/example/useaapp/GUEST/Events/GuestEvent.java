package com.example.useaapp.GUEST.Events;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.example.useaapp.GUEST.Adapter.Adapter_guest_event_tabbar;
import com.example.useaapp.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class GuestEvent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_event);
        Toolbar toolbar = findViewById(R.id.CustomActionbarGuestEvent);
        setSupportActionBar(toolbar);
        setTitle(R.string.GuestEvent);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(view -> finish());
        TabLayout tablayout = findViewById(R.id.tab_menu_guest_event);
        ViewPager2 pager2 = findViewById(R.id.view_pager_menu_guest_event);

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