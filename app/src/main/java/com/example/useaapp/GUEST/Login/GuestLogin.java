package com.example.useaapp.GUEST.Login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.useaapp.GUEST.MainGuestActivity;
import com.example.useaapp.databinding.ActivityGuestLoginBinding;
import com.google.firebase.auth.FirebaseAuth;

public class GuestLogin extends AppCompatActivity implements FirebaseAuth.AuthStateListener {
    ActivityGuestLoginBinding binding;
    private final static String TAG = "GuestLoginActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGuestLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
//        setContentView(R.layout.activity_guest_login);
        setContentView(view);


    }

    public void onSignOut(){
        FirebaseAuth.getInstance().signOut();
    }

    @Override
    protected void onStop() {
        super.onStop();
        FirebaseAuth.getInstance().removeAuthStateListener(this);
        onSignOut();
    }

    @Override
    protected void onStart() {
        super.onStart();
       FirebaseAuth.getInstance().addAuthStateListener(this);
    }

    @Override
    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
        if (firebaseAuth.getCurrentUser() == null){
            return;
        }else {
            finish();
            startActivity(new Intent(this,MainGuestActivity.class));
        }
        firebaseAuth.getCurrentUser().getIdToken(true).addOnSuccessListener(
                getTokenResult -> Log.d(TAG, "onSuccess: " + getTokenResult.getToken()));
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