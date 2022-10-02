package com.example.useaapp.guest.guest_more.about_us;

import com.example.useaapp.guest.guest_more.faq.Response_model_guest_faq_more;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Apiset_guest_about_us_more
{
   @GET("fetch_guest_more_about_us.php")
    Call<List<Response_model_guest_about_us_more>> getData();
}
