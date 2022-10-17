package com.example.useaapp.GUEST.Events.announcement;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Apiset_guest_event_announcement
{
    @GET("fetch_guest_event_announcement.php")
    Call<List<Response_model_guest_event_announcement>> getdata();
}
