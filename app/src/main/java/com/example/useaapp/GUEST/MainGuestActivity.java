package com.example.useaapp.GUEST;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.useaapp.R;
import com.example.useaapp.GUEST.Home.FragmentGuestHome;
import com.example.useaapp.GUEST.More.FragmentGuestMore;
import com.google.android.material.navigation.NavigationBarView;

public class MainGuestActivity extends AppCompatActivity {

    View cancel, leave;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashobard_guest);
        NavigationBarView navigationBarView = findViewById(R.id.bottomNavigationBarGuest);
        getSupportFragmentManager().beginTransaction().replace(R.id.guestLayoutDashboard, new FragmentGuestHome()).commit();
        navigationBarView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home_guest_dashboard:
                    getSupportFragmentManager().beginTransaction().replace(R.id.guestLayoutDashboard, new FragmentGuestHome()).commit();
                    break;
                case R.id.more_guest_dashboard:
                    getSupportFragmentManager().beginTransaction().replace(R.id.guestLayoutDashboard, new FragmentGuestMore()).commit();
                    break;
            }
            return true;
        });
    }

    @Override
    public void onBackPressed() {
        View layout = getLayoutInflater().inflate(R.layout.custom_dialog_back, null);
        cancel = layout.findViewById(R.id.CancelBack);//from custom dialog back
        leave = layout.findViewById(R.id.LeaveApp);// from custom dialog back
        AlertDialog.Builder builder = new AlertDialog.Builder(MainGuestActivity.this);
        builder.setCancelable(false);
        builder.setView(layout);//set view from custom dialog to alertdialog
        AlertDialog dialog = builder.create();//create view
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        leave.setOnClickListener(v1 -> finishAffinity());
        cancel.setOnClickListener(v1 -> dialog.dismiss());
        dialog.show();
    }
}