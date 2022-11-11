package com.example.useaapp.STUDENT.Profile;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.example.useaapp.MainActivity;
import com.example.useaapp.R;
import com.example.useaapp.STUDENT.Profile.ProfileSetting.About;
import com.example.useaapp.STUDENT.Profile.ProfileSetting.Legal;

public class StudentSetting extends AppCompatActivity {
    private final static String SHARE_PREFNAME = "Student_Name";
    SharedPreferences sharedPreferences;
    LinearLayout AboutProfile, LegalProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_setting);
        Toolbar toolbar = findViewById(R.id.CustomActionbarStudentSetting);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(R.string.Setting);
        toolbar.setNavigationOnClickListener(v -> finish());
        TextView studentLogOut = findViewById(R.id.student_log_out);
        toolbar.setNavigationOnClickListener(view -> finish());
        AboutProfile = findViewById(R.id.AboutProfile);
        LegalProfile = findViewById(R.id.LegalProfile);

        sharedPreferences = getSharedPreferences(SHARE_PREFNAME, MODE_PRIVATE);

        studentLogOut.setPaintFlags(studentLogOut.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        studentLogOut.setOnClickListener(v -> {
            View Layout = getLayoutInflater().inflate(R.layout.custom_dialog_log_out, null);
            CardView Logout = Layout.findViewById(R.id.Logout);
            CardView Cancel_logout = Layout.findViewById(R.id.CancelLogout);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(false);
            builder.setView(Layout);
            AlertDialog alertDialog = builder.create();
            Logout.setOnClickListener(v1 -> {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                Intent intent = new Intent(StudentSetting.this, MainActivity.class);
                startActivity(intent);
            });
            Cancel_logout.setOnClickListener(v1 -> alertDialog.dismiss());
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            alertDialog.show();
        });
        AboutProfile.setOnClickListener(l -> startActivity(new Intent(this, About.class)));
        LegalProfile.setOnClickListener(l -> startActivity(new Intent(this, Legal.class)));
    }
}