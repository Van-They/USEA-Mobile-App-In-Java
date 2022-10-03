package com.example.useaapp.guest.guest_events.announcement;

import com.example.useaapp.guest.guest_career.Apiset_guest_career;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiController_guest_event_announcement
{
   private static final String url="https://myuseaapp.000webhostapp.com/Guest/";
   private static ApiController_guest_event_announcement clientobject;
   private static Retrofit retrofit;

     ApiController_guest_event_announcement()
     {
        retrofit=new Retrofit.Builder()
                     .baseUrl(url)
                     .addConverterFactory(GsonConverterFactory.create())
                     .build();
     }

     public static synchronized ApiController_guest_event_announcement getInstance()
     {
          if(clientobject==null)
              clientobject=new ApiController_guest_event_announcement();
          return clientobject;
     }

     Apiset_guest_event_announcement getapi()
     {
         return retrofit.create(Apiset_guest_event_announcement.class);
     }
}
