package com.example.useaapp.GUEST.Login;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.useaapp.GUEST.MainGuestActivity;
import com.example.useaapp.R;
import com.example.useaapp.databinding.ActivityGuestLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class PhoneAuthActivity extends AppCompatActivity {
    private final static String TAG = "Completed Phone verify";
    String getPhoneNumber, getOTP, VerifyID,VerifyOTP;
    CountDownTimer count;
    FirebaseAuth mAuth;
    private ActivityGuestLoginBinding bindView;
//    String OTP1, OTP2, OTP3, OTP4, OTP5, OTP6, Total;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindView = ActivityGuestLoginBinding.inflate(getLayoutInflater());
        View view = bindView.getRoot();
        setContentView(view);
        bindView.SignInMethod.setVisibility(View.GONE);
        bindView.SignInWithPhone.setVisibility(View.VISIBLE);
        bindView.SendCodeOTP.setOnClickListener(v -> {
            bindView.SignInWithPhone.setVisibility(View.GONE);
            bindView.verifyCodeWithPhone.setVisibility(View.VISIBLE);
            startTimeCount();
            if (TextUtils.isEmpty(bindView.PhoneNumber.getText().toString())) {
                bindView.PhoneNumber.setError("សូមបញ្ចូលលេខទូរស័ព្ទ");
            } else {
                bindView.SignInText.setText(R.string.Verify_code);
                getPhoneNumber = bindView.PhoneNumber.getText().toString();
                sendVerificationCode(getPhoneNumber);
            }
        });


        bindView.verifyCode.setOnClickListener(v -> {

            VerifyOTP = bindView.verifyOTP.getText().toString();

            if (TextUtils.isEmpty(VerifyOTP)) {
                Toast.makeText(this, "សូមបញ្ចូលលេខ OTP", Toast.LENGTH_SHORT).show();
            } else {
                verifyCode(getOTP = VerifyOTP);
            }
        });
    }

    private void startTimeCount() {
        count = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                i = (int) millisUntilFinished / 1000;
                String time = i + " វិនាទី";
                bindView.ResendVerifyCode.setText(time);
            }

            @Override
            public void onFinish() {
                bindView.ResendVerifyCode.setText("ផ្ញើរលេខកូដម្តងទៀត");
            }
        }.start();
    }

    //Phone Authentication
    private void sendVerificationCode(String PhoneNumber) {
        PhoneAuthOptions options = PhoneAuthOptions
                .newBuilder()
                .setPhoneNumber("+855" + PhoneNumber)       // Phone number to verify
                .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                .setActivity(PhoneAuthActivity.this) // Activity (for callback binding)
                .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }


    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
            Log.e(TAG, "onVerificationCompleted: " + phoneAuthCredential);
            SignInWithPhoneAuthCredential(phoneAuthCredential);
        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {
            Log.w(TAG, "onVerificationFailed", e);

            if (e instanceof FirebaseAuthInvalidCredentialsException) {
                // Invalid request
                Toast.makeText(PhoneAuthActivity.this, "Invalid Request" + e, Toast.LENGTH_SHORT).show();
            } else if (e instanceof FirebaseTooManyRequestsException) {
                // The SMS quota for the project has been exceeded
                Toast.makeText(PhoneAuthActivity.this, "" + e, Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            VerifyID = s;
        }
    };

    private void verifyCode(String getOTP) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(VerifyID, getOTP);
        SignInWithPhoneAuthCredential(credential);
    }

    private void SignInWithPhoneAuthCredential(PhoneAuthCredential phoneAuthCredential) {
        mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithCredential(phoneAuthCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    finish();
                    startActivity(new Intent(PhoneAuthActivity.this, MainGuestActivity.class));
                } else {
                    Toast.makeText(PhoneAuthActivity.this, "ការចូលមិនជោគជ័យ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth = FirebaseAuth.getInstance();
    }

}
