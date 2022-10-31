package com.example.useaapp.GUEST.Login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.useaapp.Custom_toast;
import com.example.useaapp.GUEST.MainGuestActivity;
import com.example.useaapp.R;
import com.example.useaapp.databinding.ActivityGuestLoginBinding;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class GoogleAuthActivity extends AppCompatActivity {

    ActivityGuestLoginBinding bindView;
    private FirebaseAuth mAuth;
    private final static String TAG = "ApiException";
    private GoogleSignInClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindView = ActivityGuestLoginBinding.inflate(getLayoutInflater());
        View view = bindView.getRoot();
        setContentView(view);
        //Configure google sign In
        GoogleSignInOptions options = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        client = GoogleSignIn.getClient(this, options);
        bindView.GoogleSignIn.setOnClickListener(v -> {
            Intent intent = client.getSignInIntent();
            startActivityForResult.launch(intent);
        });
    }

    //alternative way of StartActivity for Result that deprecated
    private final ActivityResultLauncher<Intent> startActivityForResult =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result != null && result.getResultCode() == RESULT_OK) {
                    Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(result.getData());
                    try {
                        task.getResult(ApiException.class);
                        GoogleSignInAccount account = task.getResult(ApiException.class);
                        firebaseAuthWithGoogle(account.getIdToken());
                    } catch (ApiException e) {
                        Log.d(TAG, "onActivityResult: " + e);
                    }
                } else {
                    //not success
                    Custom_toast toast = new Custom_toast(getApplicationContext());
                    toast.showToast("មានបញ្ហាជាមួយការចូលសូមព្យាមពេលក្រោយ");
                }
            });

    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser mUser = mAuth.getCurrentUser();
                        updateUI(mUser);
                    } else {
                        Log.d(TAG, "signInWithCredential:failure ", task.getException());
                        updateUI(null);
                    }
                });
    }

    private void updateUI(FirebaseUser mUser) {
        finish();
        Intent intent = new Intent(this, MainGuestActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
    }
}

