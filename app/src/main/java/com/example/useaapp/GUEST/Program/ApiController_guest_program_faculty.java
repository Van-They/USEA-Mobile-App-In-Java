package com.example.useaapp.GUEST.Program;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiController_guest_program_faculty
{
   private static final String url="https://myuseaapp.000webhostapp.com/Guest/";
   private static ApiController_guest_program_faculty client_object;
   private static Retrofit retrofit;

     ApiController_guest_program_faculty()
     {
        retrofit=new Retrofit.Builder()
                     .baseUrl(url)
                     .addConverterFactory(GsonConverterFactory.create())
                     .build();
     }

     public static synchronized ApiController_guest_program_faculty getInstance()
     {
          if(client_object ==null)
              client_object =new ApiController_guest_program_faculty();
          return client_object;
     }

//     get data from Faculty
    public Apiset_guest_program_faculty getapi_fac()
     {
         return retrofit.create(Apiset_guest_program_faculty.class);
     }

//     get data from Faculty វិទ្យាសាស្ត្រ សង្គម និងនីតិសាស្ត្រ
    public Apiset_guest_program_faculty getapi_fac1_bach_major_id1()
    {
        return retrofit.create(Apiset_guest_program_faculty.class);
    }

    //    get data from Faculty សេដ្ឋកិច្ច ពាណិជ្ជកម្ម និងទេសចរណ៍
    public Apiset_guest_program_faculty getapi_fac2_asso_major_id2()
    {
        return retrofit.create(Apiset_guest_program_faculty.class);
    }

    //    get data from Faculty សេដ្ឋកិច្ច ពាណិជ្ជកម្ម និងទេសចរណ៍
    public Apiset_guest_program_faculty getapi_fac2_bach_major_id2()
    {
        return retrofit.create(Apiset_guest_program_faculty.class);
    }

    //    get data from Faculty វិទ្យាសាស្ត្រ និងបច្ចេកវិទ្យា
    public Apiset_guest_program_faculty getapi_fac3_bach_major_id3()
    {
        return retrofit.create(Apiset_guest_program_faculty.class);
    }

    //    get data from Faculty វិទ្យាសាស្ត្រ និងបច្ចេកវិទ្យា
    public Apiset_guest_program_faculty getapi_fac3_bach_major_id3_it_y1s1()
    {
        return retrofit.create(Apiset_guest_program_faculty.class);
    }

    //    get data from Faculty សិល្បៈ មនុស្សសាស្ត្រ និងការអប់រំ
    public Apiset_guest_program_faculty getapi_fac4_bach_major_id4()
    {
        return retrofit.create(Apiset_guest_program_faculty.class);
    }
}
