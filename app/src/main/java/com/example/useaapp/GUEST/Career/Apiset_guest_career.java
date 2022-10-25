package com.example.useaapp.GUEST.Career;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Apiset_guest_career
{
    @GET("fetch_guest_career.php")
    Call<List<Response_model_guest_career>> getdata();
}
