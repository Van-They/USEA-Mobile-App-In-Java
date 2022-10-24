package com.example.useaapp.STUDENT.Login;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("st_login.php")
    Call<ModelResponse> callUserLogin(
            @Field("student_id") String student_id,
            @Field("pwd") String pwd
    );
}
