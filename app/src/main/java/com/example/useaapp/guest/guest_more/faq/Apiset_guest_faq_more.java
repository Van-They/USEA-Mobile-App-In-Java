package com.example.useaapp.guest.guest_more.faq;

import com.example.useaapp.guest.guest_registration.Response_model_guest_registration;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Apiset_guest_faq_more
{
   @GET("fetch_guest_more_faq.php")
    Call<List<Response_model_guest_faq_more>> getData();
}
