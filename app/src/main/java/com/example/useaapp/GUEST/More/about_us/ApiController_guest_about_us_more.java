package com.example.useaapp.GUEST.More.about_us;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiController_guest_about_us_more
{
   private static final String url="https://myuseaapp.000webhostapp.com/Guest/";
   private static ApiController_guest_about_us_more client_object;
   private static Retrofit retrofit;

     ApiController_guest_about_us_more()
     {
        retrofit=new Retrofit.Builder()
                     .baseUrl(url)
                     .addConverterFactory(GsonConverterFactory.create())
                     .build();
     }

     public static synchronized ApiController_guest_about_us_more getInstance()
     {
          if(client_object ==null)
              client_object =new ApiController_guest_about_us_more();
          return client_object;
     }
    Apiset_guest_about_us_more getApi()
     {
         return retrofit.create(Apiset_guest_about_us_more.class);
     }
}
