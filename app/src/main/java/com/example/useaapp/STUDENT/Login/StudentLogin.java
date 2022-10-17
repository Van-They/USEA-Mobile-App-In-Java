package com.example.useaapp.STUDENT.Login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.useaapp.R;
import com.example.useaapp.STUDENT.MainStudentActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentLogin extends AppCompatActivity {
    private static final String TAG = "Student Login";

    SharedPreferences sharedPreferences;
    private final static String SHARE_PREFNAME = "Student_Name";

    TextInputEditText Student_Id, Student_pwd;
    MaterialButton buttonLogin;
    ProgressBar progressLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        Student_Id = findViewById(R.id.usernameLogIn);
        Student_pwd = findViewById(R.id.passwordLogIn);

        buttonLogin = findViewById(R.id.buttonLogin);
        progressLogIn = findViewById(R.id.progressLogIn);

        sharedPreferences = getSharedPreferences(SHARE_PREFNAME,MODE_PRIVATE);
        String Student_name = sharedPreferences.getString("name","");

        if (Student_name !=null && !Student_name.equals("")){
            startActivity(new Intent(getApplicationContext(), MainStudentActivity.class));
        }
        buttonLogin.setOnClickListener(view -> {
            login();
        });


    }

    private void login() {

        String St_id = Student_Id.getText().toString();
        String St_pass = Student_pwd.getText().toString();

        Call<ModelResonse> call = ApiClient
                .getInstance()
                .getApi()
                .callUserLogin(St_id,St_pass);

        call.enqueue(new Callback<ModelResonse>() {
            @Override
            public void onResponse(Call<ModelResonse> call, Response<ModelResonse> response) {
                if (response.body().getResponse().equals("OK")){
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("name", response.body().getName());
                    editor.putString("Student_ID",St_id);
                    editor.apply();
                    startActivity(new Intent(getApplicationContext(), MainStudentActivity.class));
                }else{
                    Toast.makeText(StudentLogin.this, "Invalid Credential", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ModelResonse> call, Throwable t) {
                Toast.makeText(StudentLogin.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });

    }
}