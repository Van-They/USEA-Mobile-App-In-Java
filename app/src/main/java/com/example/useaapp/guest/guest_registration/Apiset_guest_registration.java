package com.example.useaapp.guest.guest_registration;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Apiset_guest_registration
{
   @GET("fetch_guest_registration.php")
    Call<List<Response_model_guest_registration>> getdata();
}
