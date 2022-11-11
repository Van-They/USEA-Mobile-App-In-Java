package com.example.useaapp;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Loading extends AppCompatActivity {

    TextView no_internet;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        no_internet = findViewById(R.id.no_internet);
        progressBar = findViewById(R.id.splash_progress);

        ImageView img = findViewById(R.id.logo_splashscreen);
        Animation top = AnimationUtils.loadAnimation(this, R.anim.top_logo);
        img.setAnimation(top);
        new Handler().postDelayed(() -> {
            if (activeNetwork != null) {
                // connected to the internet
                if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI ) {
                    // connected to wifi
                    finish();
                    startActivity(new Intent(Loading.this, MainActivity.class));
                } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE ) {
                    // connected to mobile data
                    finish();
                    startActivity(new Intent(Loading.this, MainActivity.class));
                }
            } else {
                // not connected to the internet
                progressBar.setVisibility(View.GONE);
                no_internet.setVisibility(View.VISIBLE);
            }
        }, 1500);
    }
}