package com.example.useaapp.guest.guest_login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.useaapp.R;
import com.example.useaapp.guest.MainGuestActivity;
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

public class GoogleAuthenticationClass extends GuestLogin {
    GoogleSignInClient googleSignInClient;
    private static final int REQ_CODE = 2100;
    ProgressDialog progressDialog;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Configure google sign In
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Google Sign In");
        progressDialog.show();
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
      mAuth = FirebaseAuth.getInstance();
      mUser = mAuth.getCurrentUser();
        //build interface for use to sign in
        googleSignInClient = GoogleSignIn.getClient(this, gso);
        Intent signInIntent = googleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, REQ_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                //Sign In with Google success
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account.getIdToken());

            } catch (ApiException e) {
                Toast.makeText(this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
                finish();
            }
        }
    }

    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken,null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        progressDialog.dismiss();
                        FirebaseUser User = mAuth.getCurrentUser();
                        updateUI(User);
                    } else {
                        progressDialog.dismiss();
                        Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
    }

    private void updateUI(FirebaseUser mUser) {
    Intent intent = new Intent(GoogleAuthenticationClass.this, MainGuestActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
    startActivity(intent);
    }
}
