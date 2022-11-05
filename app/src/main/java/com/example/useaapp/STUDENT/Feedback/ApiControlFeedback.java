package com.example.useaapp.STUDENT.Feedback;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiControlFeedback {
    private static final String url = "https://myuseaapp.000webhostapp.com/Student/";
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            OkHttpClient client = new OkHttpClient()
                    .newBuilder().build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


}
