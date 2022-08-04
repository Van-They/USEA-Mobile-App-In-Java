package com.example.useaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.useaapp.student.MainStudentActivity;

public class SplashScreen extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    private static String SHARED_PREF_NAME = "mypref";
    private static String KEY_STUDENT_ID = "student_id";
    private static String KEY_PWD = "pwd";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
//        getSupportActionBar().hide();

        ImageView img = findViewById(R.id.logo);
        Animation top = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.top_logo);
        img.setAnimation(top);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                sharedPreferences = getSharedPreferences("SharedPref", MODE_PRIVATE);
                boolean isFirstTime = sharedPreferences.getBoolean("firstTime", true);

                if(isFirstTime){
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("firstTime", false);
                    editor.commit();

                }else{
                    CheckLogin();
                }
            }
        }, 1000);
    }
    private void CheckLogin() {
        if ((sharedPreferences==null))
            sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
            String UserID = sharedPreferences.getString(KEY_STUDENT_ID,"");
            String UserPass = sharedPreferences.getString(KEY_PWD,"");

            if (UserID !=null && !UserID.equals("") && UserPass !=null && !UserPass.equals("")){
                Toast.makeText(this, "Already Log In", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
                finish();
            }else {
                startActivity(new Intent(this,MainStudentActivity.class));
                finish();
            }
    }
}