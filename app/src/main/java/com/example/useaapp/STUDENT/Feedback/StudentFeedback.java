package com.example.useaapp.STUDENT.Feedback;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.useaapp.Custom_toast;
import com.example.useaapp.Data_Progressing;
import com.example.useaapp.R;
import com.example.useaapp.STUDENT.Login.ApiSetLogin;
import com.github.drjacky.imagepicker.ImagePicker;

import java.io.File;
import java.util.Objects;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentFeedback extends AppCompatActivity {

    private final static String SHARE_PREFNAME = "Student_Name";
    SharedPreferences sharedPreferences;
    Button btnSubmit_feedback;
    ImageView image_feedback;
    RatingBar ratingBar;
    TextView text_feedback_image;
    EditText text_feed_back;
    File file;
    Uri uri;
    private static final String TAG = "Student_Feedback";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_feedback);
        Toolbar toolbar = findViewById(R.id.CustomActionbarStudentFeedback);
        setSupportActionBar(toolbar);
        setTitle(R.string.Feedback);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(view -> finish());
        sharedPreferences = getSharedPreferences(SHARE_PREFNAME, Context.MODE_PRIVATE);

        String Student_ID = sharedPreferences.getString("Student_ID", "");

        btnSubmit_feedback = findViewById(R.id.submit_btn_feedback);
        ratingBar = findViewById(R.id.rating_star);
        text_feed_back = findViewById(R.id.text_feed_back);
        image_feedback = findViewById(R.id.image_feedback);
        text_feedback_image = findViewById(R.id.text_feedback_image);


        Data_Progressing loading = new Data_Progressing(StudentFeedback.this);
        Custom_toast toast = new Custom_toast(StudentFeedback.this);
        btnSubmit_feedback.setOnClickListener(v -> {
            String star = String.valueOf((int) ratingBar.getRating());
            String feedback = text_feed_back.getText().toString();
            loading.showDialog();
            file = new File(uri.getPath());
            RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), file);
            MultipartBody.Part fileUpload = MultipartBody.Part.createFormData("file", file.getName(), requestBody);
            RequestBody filename = RequestBody.create(MediaType.parse("text/plain"), file.getName());
            RequestBody St_id = RequestBody.create(MediaType.parse("text/plain"),Student_ID);
            RequestBody Feedback = RequestBody.create(MediaType.parse("text/plain"),feedback);
            RequestBody Star = RequestBody.create(MediaType.parse("text/plain"),star);
            ApiSetLogin apiSetLogin = ApiControlFeedback.getRetrofit().create(ApiSetLogin.class);
            Call<ServerResponse> call = apiSetLogin.sendFeedback(fileUpload, filename, St_id, Feedback, Star);
            call.enqueue(new Callback<ServerResponse>() {
                @Override
                public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                    String msg = response.body().getResponse();
                    if (msg.equals("OK")) {
                        Log.d(TAG, "onResponse: " + msg);
                    } else {
                        Log.d(TAG, "onResponse: " + "Failed");
                    }
                    loading.stopDialog();
                }

                @Override
                public void onFailure(Call<ServerResponse> call, Throwable t) {
                    loading.stopDialog();
                    toast.showToast("ការភ្ជាប់មានបញ្ហាសូមព្យាយាមពេលក្រោយ");
                }
            });
            btnSubmit_feedback.setEnabled(false);
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void getImage(View view) {
        ImagePicker.Companion.with(this)
                .maxResultSize(1080, 1080)
                .crop().compress(1024)
                .start(10);
        text_feedback_image.setVisibility(View.GONE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        assert data != null;
        uri = data.getData();
        image_feedback.setImageURI(uri);
    }
}