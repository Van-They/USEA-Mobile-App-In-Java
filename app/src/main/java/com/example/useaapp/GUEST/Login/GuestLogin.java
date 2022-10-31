package com.example.useaapp.GUEST.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.useaapp.GUEST.MainGuestActivity;
import com.example.useaapp.databinding.ActivityGuestLoginBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class GuestLogin extends AppCompatActivity {
    ActivityGuestLoginBinding binding;
    private final static String TAG = "GuestLoginActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGuestLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
//        setContentView(R.layout.activity_guest_login);
        setContentView(view);

        //sign in With Phone Number
        binding.PhoneAuth.setOnClickListener(v -> startActivity(new Intent(GuestLogin.this, PhoneAuthActivity.class)));

        //sign in With Gmail
        binding.GoogleSignIn.setOnClickListener(v -> startActivity(new Intent(GuestLogin.this, GoogleAuthActivity.class)));

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser mUser = mAuth.getCurrentUser();
        if (mUser != null){
            finish();
            startActivity(new Intent(GuestLogin.this, MainGuestActivity.class));
        }
    }
}