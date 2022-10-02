package com.example.useaapp.guest.guest_scholarship;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiController_guest_scholarship
{
   private static final String url="http://10.10.10.185/usea_app/";
   private static ApiController_guest_scholarship clientobject;
   private static Retrofit retrofit;

     ApiController_guest_scholarship()
     {
        retrofit=new Retrofit.Builder()
                     .baseUrl(url)
                     .addConverterFactory(GsonConverterFactory.create())
                     .build();
     }

     public static synchronized ApiController_guest_scholarship getInstance()
     {
          if(clientobject==null)
              clientobject=new ApiController_guest_scholarship();
          return clientobject;
     }

     com.example.useaapp.guest.guest_scholarship.Apiset_guest_scholarship getapi()
     {
         return retrofit.create(com.example.useaapp.guest.guest_scholarship.Apiset_guest_scholarship.class);
     }
}
