package com.example.useaapp.guest.guest_career;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiController_guest_career
{
   private static final String url="https://myuseaapp.000webhostapp.com/Guest/";
   private static ApiController_guest_career clientobject;
   private static Retrofit retrofit;

     ApiController_guest_career()
     {
        retrofit=new Retrofit.Builder()
                     .baseUrl(url)
                     .addConverterFactory(GsonConverterFactory.create())
                     .build();
     }

     public static synchronized ApiController_guest_career getInstance()
     {
          if(clientobject==null)
              clientobject=new ApiController_guest_career();
          return clientobject;
     }

     Apiset_guest_career getapi()
     {
         return retrofit.create(Apiset_guest_career.class);
     }
}
