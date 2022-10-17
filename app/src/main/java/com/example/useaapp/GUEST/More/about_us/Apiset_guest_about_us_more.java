package com.example.useaapp.GUEST.More.about_us;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Apiset_guest_about_us_more
{
   @GET("fetch_guest_more_about_us.php")
    Call<List<Response_model_guest_about_us_more>> getData();
}
