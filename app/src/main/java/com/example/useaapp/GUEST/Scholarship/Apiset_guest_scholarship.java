package com.example.useaapp.GUEST.Scholarship;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Apiset_guest_scholarship
{
    @GET("fetch_guest_scholarship.php")
    Call<List<Response_model_guest_scholarship>> getdata();
}
