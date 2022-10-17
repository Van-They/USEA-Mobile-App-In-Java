package com.example.useaapp.GUEST.Registration;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiController_guest_registration
{
   private static final String url="https://myuseaapp.000webhostapp.com/Guest/";
   private static ApiController_guest_registration client_object;
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
          if(client_object ==null)
              client_object =new ApiController_guest_registration();
          return client_object;
     }
    Apiset_guest_registration getapi()
     {
         return retrofit.create(Apiset_guest_registration.class);
     }
}
