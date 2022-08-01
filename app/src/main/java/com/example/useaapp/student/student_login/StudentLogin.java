package com.example.useaapp.student.student_login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.useaapp.MainActivity;
import com.example.useaapp.R;
import com.example.useaapp.student.MainStudentActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class StudentLogin extends AppCompatActivity {

    TextInputEditText textInputLayoutUsername, textInputLayoutPassword;
    MaterialButton buttonLogin;
    ProgressBar progressLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        textInputLayoutUsername = findViewById(R.id.usernameLogIn);
        textInputLayoutPassword = findViewById(R.id.passwordLogIn);
        buttonLogin = findViewById(R.id.buttonLogin);
        progressLogIn = findViewById(R.id.progressLogIn);

    }
    public void letTheUserLoggedIn(View view) {

        if (!isConnected(StudentLogin.this)) {
            showCustomDialog();
        }

        final String student_id, pwd;
        student_id = String.valueOf(textInputLayoutUsername.getText());
        pwd = String.valueOf(textInputLayoutPassword.getText());

        if (!student_id.equals("") && !pwd.equals("")) {
            progressLogIn.setVisibility(View.VISIBLE);
            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(new Runnable() {
                @Override
                public void run() {
                    String[] field = new String[2];
                    field[0] = "student_id";
                    field[1] = "pwd";
                    //Creating array for data
                    String[] data = new String[2];
                    data[0] = student_id;
                    data[1] = pwd;
                    PutData putData = new PutData("http://192.168.2.84//LoginRegister/login.php", "POST", field, data);
                    if (putData.startPut()) {
                        if (putData.onComplete()) {
                            progressLogIn.setVisibility(View.GONE);
                            String result = putData.getResult();
                            if (result.equals("Login Success")) {
                                Toast.makeText(StudentLogin.this, result, Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(StudentLogin.this, MainStudentActivity.class);
                                intent.putExtra("student_id", data[0]);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(StudentLogin.this, result, Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
            });
        } else {
            Toast.makeText(StudentLogin.this, "All fields required!!!", Toast.LENGTH_SHORT).show();
        }
    }

    //    Connect to the Internet
    private boolean isConnected(StudentLogin log){
        ConnectivityManager connectivityManager = (ConnectivityManager) log.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo conWifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo conMobile = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if((conWifi != null && conWifi.isConnected()) || (conMobile != null && conMobile.isConnected())){
            return true;
        }else{
            return false;
        }
    }

    private void showCustomDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(StudentLogin.this);
        builder.setMessage("Please Connect to the internet to proceed!!")
                .setCancelable(false)
                .setPositiveButton("Connect", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                    }
                });
        builder.show();
    }
}