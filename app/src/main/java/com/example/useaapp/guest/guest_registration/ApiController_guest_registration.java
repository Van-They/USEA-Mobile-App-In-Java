package com.example.useaapp.guest.guest_registration;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiController_guest_registration
{
   private static final String url="http://192.168.3.158/usea_app/";

   private static ApiController_guest_registration clientobject;
   private static Retrofit retrofit;

     ApiController_guest_registration()
     {
        retrofit=new Retrofit.Builder()
                     .baseUrl(url)
                     .addConverterFactory(GsonConverterFactory.create())
                     .build();
     }

     public static synchronized ApiController_guest_registration getInstance()
     {
          if(clientobject==null)
              clientobject=new ApiController_guest_registration();
          return clientobject;
     }
    Apiset_guest_registration getapi()
     {
         return retrofit.create(Apiset_guest_registration.class);
     }
}
