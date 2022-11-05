package com.example.useaapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.useaapp.GUEST.Login.GuestLogin;
import com.example.useaapp.GUEST.MainGuestActivity;
import com.example.useaapp.STUDENT.Login.StudentLogin;
import com.example.useaapp.STUDENT.MainStudentActivity;
import com.example.useaapp.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private final static String SHARE_PREFNAME = "Student_Name";
    private final static String Student_Name = "name";
    private final static String TAG = "MainActivity";
    ActivityMainBinding binding;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser mUser = mAuth.getCurrentUser();

        sharedPreferences = getSharedPreferences(SHARE_PREFNAME, MODE_PRIVATE);
        String student = sharedPreferences.getString(Student_Name, "");

        if (mUser != null && !student.isEmpty()) {
            finish();
            startActivity(new Intent(this, MainStudentActivity.class));
        } else if (mUser != null && student.equals("")) {
            startActivity(new Intent(this, MainGuestActivity.class));
        } else if (mUser == null && !student.isEmpty()) {
            startActivity(new Intent(this, MainStudentActivity.class));
        } else {
            Log.d(TAG, "onCreate: " + "Haven't been log in!");
        }

        binding.guestAccount.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, GuestLogin.class)));
        binding.studentaccount.setOnClickListener(v -> startActivity(new Intent(this, StudentLogin.class)));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}