package com.example.useaapp.guest.guest_events.current;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Apiset_guest_event_current
{
    @GET("fetch_guest_event_current.php")
    Call<List<Response_model_guest_event_current>> getdata();
}
