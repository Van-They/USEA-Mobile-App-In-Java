package com.example.useaapp.guest.guest_events.past;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiController_guest_event_past
{
   private static final String url="http://172.17.19.186/usea_app/";
   private static ApiController_guest_event_past clientobject;
   private static Retrofit retrofit;

     ApiController_guest_event_past()
     {
        retrofit=new Retrofit.Builder()
                     .baseUrl(url)
                     .addConverterFactory(GsonConverterFactory.create())
                     .build();
     }

     public static synchronized ApiController_guest_event_past getInstance()
     {
          if(clientobject==null)
              clientobject=new ApiController_guest_event_past();
          return clientobject;
     }

     Apiset_guest_event_past getapi()
     {
         return retrofit.create(Apiset_guest_event_past.class);
     }
}
