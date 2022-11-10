package com.example.useaapp.STUDENT;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiController_student {
    //   private static final String url="https://myuseaapp.000webhostapp.com/Student/";
//   private static final String url="http://192.168.1.8:8080/hosting_api/Student/";
//    private static final String url = "http://192.168.1.12/USEA/Student/";
    private static final String url = "http://172.17.17.197/USEA/Student/";//ac
//    private static final String url = "http://192.168.0.170/USEA/Student/";

    private static ApiController_student client_object;
    private static Retrofit retrofit;
    Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    ApiController_student() {

        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public static synchronized ApiController_student getInstance() {
        if (client_object == null)
            client_object = new ApiController_student();
        return client_object;
    }

    public Apiset_student getApiCredit() {
        return retrofit.create(Apiset_student.class);
    }

    public Apiset_student login() {
        return retrofit.create(Apiset_student.class);
    }

    public Apiset_student feedback() {
        return retrofit.create(Apiset_student.class);
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
