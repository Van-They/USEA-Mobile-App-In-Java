package com.example.useaapp.guest.guest_events.upcoming;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Apiset_guest_event_upcoming
{
    @GET("fetch_guest_event_upcoming.php")
    Call<List<Response_model_guest_event_upcoming>> getdata();
}
