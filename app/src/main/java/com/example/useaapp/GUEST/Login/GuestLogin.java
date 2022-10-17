package com.example.useaapp.GUEST.Login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.useaapp.MainActivity;
import com.example.useaapp.R;
import com.example.useaapp.GUEST.MainGuestActivity;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class GuestLogin extends AppCompatActivity {
    Button btnSendCode, btnVerify;
    CardView GoogleSignInMethod,PhoneAuth;
    LinearLayout SignInMethod, SignInWithPhone, verifyCodeWithPhone;
    EditText InputPhoneNumber, InputOtpCode;
    String getPhoneNumber, getOTP, VerifyID;
    TextView SignInText;
    ProgressBar progressBar;
    ImageView back_arrow_login;
    private FirebaseAuth mAuth;

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
        btnSendCode.setOnClickListener(v -> {
            if (TextUtils.isEmpty(InputPhoneNumber.getText().toString())) {
                InputPhoneNumber.setError("សូមបញ្ចូលលេខទូរស័ព្ទ");
            } else {
                SignInText.setText(R.string.Verify_code);
                SignInWithPhone.setVisibility(View.GONE);
                verifyCodeWithPhone.setVisibility(View.VISIBLE);
                getPhoneNumber = InputPhoneNumber.getText().toString();
                sendVerificationCode(getPhoneNumber);
            }
        });

        btnVerify.setOnClickListener(v -> {
            if (TextUtils.isEmpty(InputOtpCode.getText().toString())) {
                Toast.makeText(this, "សូមបញ្ចូលលេខ OTP", Toast.LENGTH_SHORT).show();
            } else {
                getOTP = InputOtpCode.getText().toString();
                verifyCode(getOTP);
            }
        });
        GoogleSignInMethod.setOnClickListener(v -> startActivity(new Intent(this,GoogleAuthenticationClass.class)));
        back_arrow_login.setOnClickListener(v->{
            finish();
            startActivity(new Intent(GuestLogin.this,MainActivity.class));
        });
    }

    private void Initialize_var() {
        progressBar = findViewById(R.id.progressBarLogin);
        GoogleSignInMethod = findViewById(R.id.GoogleSignIn);//Btn SignInWithGoogle
        PhoneAuth = findViewById(R.id.PhoneAuth);//Btn SignInWithPhone Number
        btnVerify = findViewById(R.id.verifyCode);//Btn Verify Code OTP
        btnSendCode = findViewById(R.id.SendCodeOTP);//Btn send SMS code
        SignInText = findViewById(R.id.SignInText);

        SignInMethod = findViewById(R.id.SignInMethod);//Layout SignInMethod
        SignInWithPhone = findViewById(R.id.SignInWithPhone);//Layout input phone number
        verifyCodeWithPhone = findViewById(R.id.verifyCodeWithPhone);//Layout Verify Code

        SignInWithPhone.setVisibility(View.GONE);
        verifyCodeWithPhone.setVisibility(View.GONE);

        InputPhoneNumber = findViewById(R.id.PhoneNumber);//Input Phone Number
        InputOtpCode = findViewById(R.id.InputOtpCode);//Input OTP from SMS

        back_arrow_login = findViewById(R.id.back_arrow_login);

    }
    //Phone Authentication
    private void sendVerificationCode(String PhoneNumber) {
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder()
                        .setPhoneNumber("+855" + PhoneNumber)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(GuestLogin.this)                 // Activity (for callback binding)
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
            Toast.makeText(GuestLogin.this, "Error Code Send", Toast.LENGTH_SHORT).show();
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
        mAuth.signInWithCredential(phoneAuthCredential).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                startActivity(new Intent(GuestLogin.this, MainGuestActivity.class));
            }
        });
    }

    //google
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser mUser = FirebaseAuth.getInstance().getCurrentUser();
        if (mUser != null) {
            startActivity(new Intent(GuestLogin.this, MainGuestActivity.class));
        }
    }
}