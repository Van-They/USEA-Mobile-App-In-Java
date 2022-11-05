package com.example.useaapp.STUDENT.Profile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.useaapp.Custom_toast;
import com.example.useaapp.R;
import com.github.drjacky.imagepicker.ImagePicker;

import de.hdodenhof.circleimageview.CircleImageView;

public class StudentProfile extends AppCompatActivity {

    private final static String SHARE_PREFNAME = "Student_Name";
    private final static String PROFILE_NAME = "Profile_Picture";
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Custom_toast toast;
    Uri uri;
    TextView student_name_profile, student_ID, major_name, stage_name, academic, shift, dob, phone;
    ImageView change_image_in_profile;
    CircleImageView profile_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);
        Toolbar actionbar = findViewById(R.id.CustomActionbarStudentProfile);
        setSupportActionBar(actionbar);
        setTitle(R.string.StudentInformation);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionbar.setNavigationOnClickListener(view -> finish());

        student_name_profile = findViewById(R.id.student_name_profile);
        student_ID = findViewById(R.id.student_ID);
        student_name_profile = findViewById(R.id.student_name_profile);
        student_ID = findViewById(R.id.student_ID);
        student_name_profile = findViewById(R.id.student_name_profile);
        student_ID = findViewById(R.id.student_ID);
        major_name = findViewById(R.id.major_in_profile);
        stage_name = findViewById(R.id.promotion_in_profile);
        academic = findViewById(R.id.academic_year_profile);
        shift = findViewById(R.id.shift_in_profile);
        dob = findViewById(R.id.date_of_birth_profile);
        phone = findViewById(R.id.phone_number_profile);

        sharedPreferences = getSharedPreferences(SHARE_PREFNAME, Context.MODE_PRIVATE);
        String Student_name = sharedPreferences.getString("name", "");
        String Student_ID = sharedPreferences.getString("Student_ID", "");
        String Maj = sharedPreferences.getString("major_name", "");
        String Sta = sharedPreferences.getString("stage", "");
        String Aca = sharedPreferences.getString("academic", "");
        String Shi = sharedPreferences.getString("shift", "");
        String Dob = sharedPreferences.getString("dob", "");
        String Pho = sharedPreferences.getString("ph", "");

        if (!Student_name.isEmpty() && !Student_ID.isEmpty()) {
            student_name_profile.setText(Student_name);
            student_ID.setText(Student_ID.toUpperCase());
        }

        //image picker n change profile
        change_image_in_profile = findViewById(R.id.change_image_in_profile);
        profile_image = findViewById(R.id.profile_image);

        major_name.setText(Maj);
        stage_name.setText(Sta);
        academic.setText(Aca);
        shift.setText(Shi);
        dob.setText(Dob);
        phone.setText(Pho);
//        //Major, promotion, academic year
//        TextView major_in_profile = findViewById(R.id.major_in_profile);
//        TextView promotion_in_profile = findViewById(R.id.promotion_in_profile);
//        TextView academic_year_profile = findViewById(R.id.academic_year_profile);
//        //set text
//        major_in_profile.setText("IT");
//        promotion_in_profile.setText("13");
//        academic_year_profile.setText("2018-2022");
//
//        //shift, date of birth, phone number
//        TextView shift_in_profile = findViewById(R.id.shift_in_profile);
//        TextView date_of_birth_profile = findViewById(R.id.date_of_birth_profile);
//        TextView phone_number_profile = findViewById(R.id.phone_number_profile);
//        //set text
//        shift_in_profile.setText("ល្ងាច");
//        date_of_birth_profile.setText("11-07-2000");
//        phone_number_profile.setText("093794815");

        //change password btn

        change_image_in_profile.setOnClickListener(v -> ImagePicker.Companion.with(StudentProfile.this)
                .maxResultSize(1080, 1080)
                .crop().cropOval().compress(1024)
                .start(20));

    }

    @Override
    protected void onStart() {
        super.onStart();
        sharedPreferences = getSharedPreferences(PROFILE_NAME, MODE_PRIVATE);
        String image = sharedPreferences.getString("My_Profile", null);
        if (image != null) {
            profile_image.setImageURI(Uri.parse(image));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        assert data != null;
        uri = data.getData();
        profile_image.setImageURI(uri);
        sharedPreferences = getSharedPreferences(PROFILE_NAME, MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString("My_Profile", String.valueOf(uri));
        editor.apply();
        toast = new Custom_toast(getApplicationContext());
        toast.showToast("ជោគជ័យ");
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.profile_setting) {
            startActivity(new Intent(StudentProfile.this, StudentSetting.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.profile_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}