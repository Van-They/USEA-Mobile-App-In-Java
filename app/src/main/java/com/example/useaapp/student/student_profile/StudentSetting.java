package com.example.useaapp.student.student_profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.useaapp.MainActivity;
import com.example.useaapp.R;
import com.example.useaapp.student.student_login.StudentLogin;
import com.example.useaapp.student.student_profile.ProfileSetting.About;
import com.example.useaapp.student.student_profile.ProfileSetting.Legal;

public class StudentSetting extends AppCompatActivity {
    LinearLayout AboutProfile, LegalProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_setting);
        Toolbar toolbar = findViewById(R.id.CustomActionbarStudentSetting);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(R.string.Setting);
        TextView studentLogOut = findViewById(R.id.student_log_out);

        AboutProfile = findViewById(R.id.AboutProfile);
        LegalProfile = findViewById(R.id.LegalProfile);

        studentLogOut.setOnClickListener(v -> {
            LayoutInflater inflater = getLayoutInflater();
            View Layout = inflater.inflate(R.layout.custom_log_out, null);
            TextView Logout = Layout.findViewById(R.id.Logout);
            TextView Cancelogout = Layout.findViewById(R.id.CancelLogout);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(false);
            builder.setView(Layout);
            AlertDialog alertDialog = builder.create();
            Logout.setOnClickListener(v1 -> startActivity(new Intent(this,MainActivity.class)));
            Cancelogout.setOnClickListener(v1 -> alertDialog.dismiss());
            alertDialog.show();
        });


        AboutProfile.setOnClickListener(l -> startActivity(new Intent(this, About.class)));
        LegalProfile.setOnClickListener(l -> startActivity(new Intent(this, Legal.class)));
    }
}