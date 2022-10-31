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
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class PhoneAuthActivity extends AppCompatActivity {
    private final static String TAG = "Completed Phone verify";
    String getPhoneNumber, getOTP, VerifyID;
    CountDownTimer count;
    FirebaseAuth mAuth;
    private ActivityGuestLoginBinding bindView;
    String OTP1, OTP2, OTP3, OTP4, OTP5, OTP6, Total;
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


        requestFocus();

        bindView.verifyCode.setOnClickListener(v -> {
            OTP1 = bindView.OTP1.getText().toString();
            OTP2 = bindView.OTP2.getText().toString();
            OTP3 = bindView.OTP3.getText().toString();
            OTP4 = bindView.OTP4.getText().toString();
            OTP5 = bindView.OTP5.getText().toString();
            OTP6 = bindView.OTP6.getText().toString();
            Total = OTP1 + OTP4 + OTP3 + OTP2 + OTP6 + OTP5;
            if (Total.isEmpty()) {
                Toast.makeText(this, "សូមបញ្ចូលលេខ OTP", Toast.LENGTH_SHORT).show();
            } else {
                verifyCode(getOTP = Total);
            }
        });
    }

    private void requestFocus() {
        bindView.OTP1.addTextChangedListener(new android.text.TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                bindView.OTP2.requestFocus();
            }
        });
        bindView.OTP2.addTextChangedListener(new android.text.TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                bindView.OTP3.requestFocus();
            }
        });
        bindView.OTP3.addTextChangedListener(new android.text.TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                bindView.OTP4.requestFocus();
            }
        });
        bindView.OTP4.addTextChangedListener(new android.text.TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                bindView.OTP5.requestFocus();
            }
        });
        bindView.OTP5.addTextChangedListener(new android.text.TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                bindView.OTP6.requestFocus();
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
        mAuth.signInWithCredential(phoneAuthCredential).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                startActivity(new Intent(PhoneAuthActivity.this, MainGuestActivity.class));
            }else {
                Toast.makeText(this, "ការចូលមិនជោគជ័យ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth = FirebaseAuth.getInstance();
//        mAuth.getFirebaseAuthSettings().setAppVerificationDisabledForTesting(true);
    }

}
