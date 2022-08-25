package com.example.useaapp.guest;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.useaapp.R;
import com.example.useaapp.guest.guest_home.FragmentGuestHome;
import com.example.useaapp.guest.guest_more.FragmentGuestMore;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;

public class MainGuestActivity extends AppCompatActivity {

    TextView cancel,leave;
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
        LayoutInflater layoutInflater = getLayoutInflater();
        View layout = layoutInflater.inflate(R.layout.custom_dialog_back,null);
        cancel = layout.findViewById(R.id.CancelBack);//from custom dialog back
        leave = layout.findViewById(R.id.LeaveApp);// from custom dialog back
        AlertDialog.Builder builder = new AlertDialog.Builder(MainGuestActivity.this);
        builder.setCancelable(false);
        builder.setView(layout);//set view from custom dialog to alertdialog
        AlertDialog dialog = builder.create();//create view
        leave.setOnClickListener(v1-> finishAffinity());
        cancel.setOnClickListener(v1-> dialog.dismiss());
        dialog.show();
    }
}