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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGuestLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void onSignOut() {
        FirebaseAuth.getInstance().signOut();
    }


    public void GoogleSignIn(View view) {
        finish();
        startActivity(new Intent(GuestLogin.this, GoogleAuthActivity.class));
    }

    public void PhoneAuth(View view) {
        finish();
        startActivity(new Intent(GuestLogin.this, PhoneAuthActivity.class));
    }
}