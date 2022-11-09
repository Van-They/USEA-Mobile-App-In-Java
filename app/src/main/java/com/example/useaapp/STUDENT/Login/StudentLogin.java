package com.example.useaapp.STUDENT.Login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.useaapp.Custom_toast;
import com.example.useaapp.Data_Progressing;
import com.example.useaapp.R;
import com.example.useaapp.STUDENT.ApiController_student;
import com.example.useaapp.STUDENT.MainStudentActivity;
import com.google.android.material.button.MaterialButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentLogin extends AppCompatActivity {

    private final static String SHARE_PREFNAME = "Student_Name";
    private final static String Student_Name = "name";
    private final static String major_name = "major_name";
    private final static String stage = "stage";
    private final static String academic = "academic";
    private final static String shift = "shift";
    private final static String dob = "dob";
    private final static String ph = "ph";
    SharedPreferences sharedPreferences;
    EditText Student_Id, Student_pwd;
    MaterialButton buttonLogin;

    TextView St_id_txt_error, St_pwd_txt_error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        Student_Id = findViewById(R.id.usernameLogIn);//Edit text student ID
        Student_pwd = findViewById(R.id.passwordLogIn);//Edit text student password
        buttonLogin = findViewById(R.id.buttonLogin);//button student login


        St_id_txt_error = findViewById(R.id.St_id_txt_error);//Error message when not input any data
        St_pwd_txt_error = findViewById(R.id.St_pwd_txt_error);//Error message when not input any data

        sharedPreferences = getSharedPreferences(SHARE_PREFNAME, MODE_PRIVATE);//method shared preference
        String Student_name = sharedPreferences.getString(Student_Name, "");//get name of student from sharedPreferences

        Student_Id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Student_Id.setBackgroundResource(R.drawable.edit_text_state);
                St_id_txt_error.setVisibility(View.GONE);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        Student_pwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Student_pwd.setBackgroundResource(R.drawable.edit_text_state);
                St_pwd_txt_error.setVisibility(View.GONE);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        buttonLogin.setOnClickListener(this::login);

    }

    private void login(View view) {

        String St_id = Student_Id.getText().toString();//get text from edit text student id
        String St_pass = Student_pwd.getText().toString();//get text from edit text student password

        if (Student_Id.getText().toString().isEmpty() && Student_pwd.getText().toString().isEmpty()) {
            Student_Id.setBackgroundResource(R.drawable.edit_txt_error_st_login);
            St_id_txt_error.setVisibility(View.VISIBLE);
            Student_pwd.setBackgroundResource(R.drawable.edit_txt_error_st_login);
            St_pwd_txt_error.setVisibility(View.VISIBLE);
        } else if (Student_Id.getText().toString().isEmpty()) {
            Student_Id.setBackgroundResource(R.drawable.edit_txt_error_st_login);
            St_id_txt_error.setVisibility(View.VISIBLE);
        } else if (Student_pwd.getText().toString().isEmpty()) {
            Student_pwd.setBackgroundResource(R.drawable.edit_txt_error_st_login);
            St_pwd_txt_error.setVisibility(View.VISIBLE);
        }
        Call<ModelResponse> call = ApiController_student
                .getInstance()
                .login()
                .callUserLogin(St_id, St_pass);

        Custom_toast toast = new Custom_toast(this);
        Data_Progressing loading = new Data_Progressing(this);//load loading effect data
        loading.showDialog();
        call.enqueue(new Callback<ModelResponse>() {
            @Override
            public void onResponse(Call<ModelResponse> call, Response<ModelResponse> response) {
                String msg = response.body().getResponse();
                if (msg.equals("OK")) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("name", response.body().getName());
                    editor.putString("Student_ID", St_id);
                    editor.putString(major_name, response.body().getMajor_name());
                    editor.putString(stage, response.body().getStage_name());
                    editor.putString(academic, response.body().getAcademic_year());
                    editor.putString(shift, response.body().getShift_name());
                    editor.putString(dob, response.body().getDate_of_birth());
                    editor.putString(ph, response.body().getPhone_number());
                    editor.apply();
                    loading.stopDialog();
                    Intent intent = new Intent(getApplicationContext(), MainStudentActivity.class);
                    startActivity(intent);
                } else {
                    loading.stopDialog();
                    toast.showToast("ការចូលមិនត្រឹមត្រូវ");
                }
            }

            @Override
            public void onFailure(Call<ModelResponse> call, Throwable t) {
                toast.showToast("ការចូលមានបញ្ហាចូលព្យាយាមម្តងនៅពេលក្រោយ");
                new Handler().postDelayed(() -> finishAffinity(), 1500);
            }
        });
    }
}