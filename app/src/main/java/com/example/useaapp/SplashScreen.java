package com.example.useaapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("CustomSplashScreen")
public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        ImageView img = findViewById(R.id.logo_splashscreen);
        Animation top = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.top_logo);
        img.setAnimation(top);
        new Handler().postDelayed(() ->
                startActivity(new Intent(SplashScreen.this,MainActivity.class)),1500);
        finish();
    }
}