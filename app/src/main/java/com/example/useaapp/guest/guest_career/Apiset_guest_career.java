package com.example.useaapp.guest.guest_career;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Apiset_guest_career
{
    @GET("fetch_guest_career.php")
    Call<List<com.example.useaapp.guest.guest_career.Response_model_guest_career>> getdata();
}
