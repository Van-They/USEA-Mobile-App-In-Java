package com.example.useaapp.guest.guest_login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.useaapp.R;
import com.example.useaapp.guest.MainGuestActivity;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class GuestLogin extends AppCompatActivity {
    Button GoogleSignInMethod, PhoneAuth, SendCodeOTP, verifyCode;
    LinearLayout SignInMethod, SignInWithPhone, verifyCodeWithPhone;
    EditText PhoneNumber, InputOtpCode;
    String getPhoneNumber, getOTP, VerifyID;
    TextView SignInText;
    ProgressBar progressBar;
    FirebaseUser mUser;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_login);
        Initialize_var();//function initialize all component
        PhoneAuth.setOnClickListener(v -> {
            progressBar.setVisibility(View.VISIBLE);
            SignInMethod.setVisibility(View.GONE);
            new Handler().postDelayed(() -> {
                SignInText.setText(R.string.Input_phone_number);
                progressBar.setVisibility(View.GONE);
                SignInWithPhone.setVisibility(View.VISIBLE);
            }, 500);
        });
        SendCodeOTP.setOnClickListener(v -> {
            if (TextUtils.isEmpty(PhoneNumber.getText().toString())) {
                PhoneNumber.setError("សូមបញ្ចូលលេខទូរស័ព្ទ");
            } else {
                SignInText.setText(R.string.Verify_code);
                SignInWithPhone.setVisibility(View.GONE);
                verifyCodeWithPhone.setVisibility(View.VISIBLE);
                getPhoneNumber = PhoneNumber.getText().toString();
                sendCodeTo(getPhoneNumber);
            }
        });

        verifyCode.setOnClickListener(v -> {
            if (TextUtils.isEmpty(InputOtpCode.getText().toString())) {
                Toast.makeText(this, "សូមបញ្ចូលលេខ OTP", Toast.LENGTH_SHORT).show();
            } else {
                getOTP = InputOtpCode.getText().toString();
                VerifyUser(getOTP);
            }
        });
        GoogleSignInMethod.setOnClickListener(v -> startActivity(new Intent(this,GoogleAuthenticationClass.class)));
    }

    private void Initialize_var() {
        progressBar = findViewById(R.id.progressBarLogin);
        GoogleSignInMethod = findViewById(R.id.GoogleSignIn);//Btn SignInWithGoogle
        PhoneAuth = findViewById(R.id.PhoneAuth);//Btn SignInWithPhone Number
        verifyCode = findViewById(R.id.verifyCode);//Btn Verify Code OTP
        SendCodeOTP = findViewById(R.id.SendCodeOTP);//Btn send SMS code
        SignInText = findViewById(R.id.SignInText);

        SignInMethod = findViewById(R.id.SignInMethod);//Layout SignInMethod
        SignInWithPhone = findViewById(R.id.SignInWithPhone);//Layout input phone number
        verifyCodeWithPhone = findViewById(R.id.verifyCodeWithPhone);//Layout Verify Code

        SignInWithPhone.setVisibility(View.GONE);
        verifyCodeWithPhone.setVisibility(View.GONE);

        PhoneNumber = findViewById(R.id.PhoneNumber);//Input Phone Number
        InputOtpCode = findViewById(R.id.InputOtpCode);//Input OTP from SMS

    }
    //Phone Authentication
    private void sendCodeTo(String getPhoneNumber) {
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder()
                        .setPhoneNumber("+855" + getPhoneNumber)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

    private final PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
            SignInWithPhoneAuthCredential(phoneAuthCredential);
        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {
        }

        @Override
        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            VerifyID = s;
        }
    };

    private void SignInWithPhoneAuthCredential(PhoneAuthCredential phoneAuthCredential) {
        FirebaseAuth.getInstance();
        mAuth.signInWithCredential(phoneAuthCredential).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                startActivity(new Intent(GuestLogin.this, MainGuestActivity.class));
            }
        });
    }

    private void VerifyUser(String getOTP) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(VerifyID, getOTP);
        SignInWithPhoneAuthCredential(credential);
    }

    //google
    @Override
    protected void onStart() {
        super.onStart();
        mUser = FirebaseAuth.getInstance().getCurrentUser();
        if (mUser != null) {
            startActivity(new Intent(GuestLogin.this, MainGuestActivity.class));
        }
    }
}