package com.example.useaapp.STUDENT.Login;

import com.example.useaapp.STUDENT.Feedback.ServerResponse;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiSetLogin {

    @FormUrlEncoded
    @POST("st_login.php")
    Call<ModelResponse> callUserLogin(
            @Field("student_id") String student_id,
            @Field("pwd") String pwd
    );

    @Multipart
    @POST("st_feedback.php")
    Call<ServerResponse> sendFeedback(
            @Part MultipartBody.Part file,
            @Part ("file") RequestBody name,
            @Part ("student_id") RequestBody student_id,
            @Part ("feedback") RequestBody feedback,
            @Part ("rating") RequestBody rating);

//    @FormUrlEncoded
//    @POST("student_feedback.php")
//    Call<ServerResponse> sendFeedback(@Field("student_id") String student_id,
//                                      @Field("feedback") String feedback,
//                                      @Field("image") String image,
//                                      @Field("rating") String rating
//    );

}
