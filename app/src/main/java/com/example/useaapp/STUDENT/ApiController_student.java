package com.example.useaapp.STUDENT;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiController_student
{
   private static final String url="https://myuseaapp.000webhostapp.com/Student/";
//   private static final String url="http://192.168.1.8:8080/hosting_api/Student/";
   private static ApiController_student client_object;
   private static Retrofit retrofit;

     ApiController_student()
     {
        retrofit=new Retrofit.Builder()
                     .baseUrl(url)
                     .addConverterFactory(GsonConverterFactory.create())
                     .build();
     }

     public static synchronized ApiController_student getInstance()
     {
          if(client_object ==null)
              client_object =new ApiController_student();
          return client_object;
     }

    //     get Student Study Plan data
    public Apiset_student getapi_stu_studyplan_y1s1() {
        return retrofit.create(Apiset_student.class);
    }
    //     get Student Study Plan data
    public Apiset_student getapi_stu_studyplan_y1s2() {
        return retrofit.create(Apiset_student.class);
    }
    //     get Student Study Plan data
    public Apiset_student getapi_stu_studyplan_y2s1() {
        return retrofit.create(Apiset_student.class);
    }
    //     get Student Study Plan data
    public Apiset_student getapi_stu_studyplan_y2s2() {
        return retrofit.create(Apiset_student.class);
    }
    //     get Student Study Plan data
    public Apiset_student getapi_stu_studyplan_y3s1() {
        return retrofit.create(Apiset_student.class);
    }
    //     get Student Study Plan data
    public Apiset_student getapi_stu_studyplan_y3s2() {
        return retrofit.create(Apiset_student.class);
    }
    //     get Student Study Plan data
    public Apiset_student getapi_stu_studyplan_y4s1() {
        return retrofit.create(Apiset_student.class);
    }
    //     get Student Study Plan data
    public Apiset_student getapi_stu_studyplan_y4s2() {
        return retrofit.create(Apiset_student.class);
    }

    //     get Student Attendance
    public Apiset_student getapi_stu_att() {
        return retrofit.create(Apiset_student.class);
    }


    //     get Student Score
    public Apiset_student getapi_stu_score_y1s1() {
        return retrofit.create(Apiset_student.class);
    }

    //     get Student Score
    public Apiset_student getapi_stu_score_y1s2() {
        return retrofit.create(Apiset_student.class);
    }

    //     get Student Score
    public Apiset_student getapi_stu_score_y2s1() {
        return retrofit.create(Apiset_student.class);
    }

    //     get Student Score
    public Apiset_student getapi_stu_score_y2s2() {
        return retrofit.create(Apiset_student.class);
    }

    //     get Student Score
    public Apiset_student getapi_stu_score_y3s1() {
        return retrofit.create(Apiset_student.class);
    }

    //     get Student Score
    public Apiset_student getapi_stu_score_y3s2() {
        return retrofit.create(Apiset_student.class);
    }

    //     get Student Score
    public Apiset_student getapi_stu_score_y4s1() {
        return retrofit.create(Apiset_student.class);
    }

    //     get Student Score
    public Apiset_student getapi_stu_score_y4s2() {
        return retrofit.create(Apiset_student.class);
    }

}
