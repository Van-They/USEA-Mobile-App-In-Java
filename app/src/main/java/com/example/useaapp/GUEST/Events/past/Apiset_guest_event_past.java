package com.example.useaapp.GUEST.Events.past;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Apiset_guest_event_past
{
    @GET("fetch_guest_event_past.php")
    Call<List<Response_model_guest_event_past>> getdata();
}
