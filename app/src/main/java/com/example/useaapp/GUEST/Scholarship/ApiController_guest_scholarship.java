package com.example.useaapp.GUEST.Scholarship;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiController_guest_scholarship
{
   private static final String url="https://myuseaapp.000webhostapp.com/Guest/";
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
     Apiset_guest_scholarship getapi()
     {
         return retrofit.create(Apiset_guest_scholarship.class);
     }
}
