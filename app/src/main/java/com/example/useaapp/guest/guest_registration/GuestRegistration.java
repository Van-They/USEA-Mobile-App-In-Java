package com.example.useaapp.guest.guest_registration;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.useaapp.R;

public class GuestRegistration extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_registration);
        Toolbar toolbar = findViewById(R.id.CustomActionbarGuestRegistration);
        setSupportActionBar(toolbar);
        setTitle(R.string.GuestRegistration);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
