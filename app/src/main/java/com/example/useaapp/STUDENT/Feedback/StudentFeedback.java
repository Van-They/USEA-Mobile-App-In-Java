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
import com.example.useaapp.STUDENT.ApiController_student;
import com.github.drjacky.imagepicker.ImagePicker;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentFeedback extends AppCompatActivity {

    private final static String SHARE_PREFNAME = "Student_Name";
    private static final String TAG = "Student_Feedback";
    SharedPreferences sharedPreferences;
    Button btnSubmit_feedback;
    ImageView image_feedback;
    RatingBar ratingBar;
    TextView text_feedback_image;
    EditText text_feed_back;
    File file;
    Uri uri;
    RequestBody requestBody, filename, St_id, Feedback, Star;
    Call<ServerResponse> call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_feedback);
        Toolbar toolbar = findViewById(R.id.CustomActionbarStudentFeedback);
        setSupportActionBar(toolbar);
        setTitle(R.string.Feedback);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
//        ApiSetLogin apiSetLogin = ApiControlFeedback.getRetrofit().create(ApiSetLogin.class);
        btnSubmit_feedback.setOnClickListener(v -> {
            String star = String.valueOf((int) ratingBar.getRating());
            String feedback = text_feed_back.getText().toString();
            loading.showDialog();
            if (feedback.isEmpty() || star.isEmpty() || uri == null) {
                loading.stopDialog();
                toast.showToast("សូមបញ្ចូលព័ត៌មានអោយបានត្រឹមត្រូវ");
            } else {
                loading.showDialog();
                file = new File(uri.getPath());
                requestBody = RequestBody.create(MediaType.parse("image/*"), file);//get image file
                MultipartBody.Part fileUpload = MultipartBody.Part.createFormData("file", file.getName(), requestBody);//get image name
                filename = RequestBody.create(MediaType.parse("text/plain"), file.getName());//push file name
                St_id = RequestBody.create(MediaType.parse("text/plain"), Student_ID);//get student id
                Feedback = RequestBody.create(MediaType.parse("text/plain"), feedback);//get text feedback
                Star = RequestBody.create(MediaType.parse("text/plain"), star);//get star rating
                call = ApiController_student.getInstance().feedback().sendFeedback(fileUpload, filename, St_id, Feedback, Star);
                call.enqueue(new Callback<ServerResponse>() {
                    @Override
                    public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                        String msg = response.body().getResponse();
                        if (msg.equals("OK")) {
                            toast.showToast("ការផ្ញើជោគជ័យ");
                            btnSubmit_feedback.setEnabled(false);
                            Log.d(TAG, "onResponse: " + msg);
                            loading.stopDialog();
                        } else {
                            toast.showToast("ការផ្ញើមិនជោគជ័យ");
                            loading.stopDialog();
                            Log.d(TAG, "onResponse: " + "Failed");
                        }
                    }

                    @Override
                    public void onFailure(Call<ServerResponse> call, Throwable t) {
                        loading.stopDialog();
                        toast.showToast("ការភ្ជាប់មានបញ្ហាសូមព្យាយាមពេលក្រោយ");
                        Log.d(TAG, "onFailure: "+t.toString());
                    }
                });
            }
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
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        assert data != null;
        uri = data.getData();
        image_feedback.setImageURI(uri);
    }
}