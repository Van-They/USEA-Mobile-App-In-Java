package com.example.useaapp.guest.guest_more.faq;

import com.example.useaapp.guest.guest_registration.Apiset_guest_registration;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiController_guest_faq_more
{
   private static final String url="http://172.20.10.14/usea_app/";
   private static ApiController_guest_faq_more client_object;
   private static Retrofit retrofit;

     ApiController_guest_faq_more()
     {
        retrofit=new Retrofit.Builder()
                     .baseUrl(url)
                     .addConverterFactory(GsonConverterFactory.create())
                     .build();
     }

     public static synchronized ApiController_guest_faq_more getInstance()
     {
          if(client_object ==null)
              client_object =new ApiController_guest_faq_more();
          return client_object;
     }
    Apiset_guest_faq_more getApi()
     {
         return retrofit.create(Apiset_guest_faq_more.class);
     }
}
