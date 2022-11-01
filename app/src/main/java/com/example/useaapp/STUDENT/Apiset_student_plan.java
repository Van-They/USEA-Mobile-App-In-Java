package com.example.useaapp.STUDENT;

import com.example.useaapp.STUDENT.StudyPlan.year1.Response_model_SemesterStudyPlan;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Apiset_student_plan
{
    @FormUrlEncoded
    //   Student StudyPlan
    @POST("student_studyplan_y1s1.php")
    Call<List<Response_model_SemesterStudyPlan>> get_stu_studyplan_y1s1(
            @Field("student_id") String student_id
    );

    @FormUrlEncoded
    //   Student StudyPlan
    @POST("student_studyplan_y1s2.php")
    Call<List<Response_model_SemesterStudyPlan>> get_stu_studyplan_y1s2(
            @Field("student_id") String student_id
    );

    @FormUrlEncoded
    //   Student StudyPlan
    @POST("student_studyplan_y2s1.php")
    Call<List<Response_model_SemesterStudyPlan>> get_stu_studyplan_y2s1(
            @Field("student_id") String student_id
    );

    @FormUrlEncoded
    //   Student StudyPlan
    @POST("student_studyplan_y2s2.php")
    Call<List<Response_model_SemesterStudyPlan>> get_stu_studyplan_y2s2(
            @Field("student_id") String student_id
    );

    @FormUrlEncoded
    //   Student StudyPlan
    @POST("student_studyplan_y3s1.php")
    Call<List<Response_model_SemesterStudyPlan>> get_stu_studyplan_y3s1(
            @Field("student_id") String student_id
    );

    @FormUrlEncoded
    //   Student StudyPlan
    @POST("student_studyplan_y3s2.php")
    Call<List<Response_model_SemesterStudyPlan>> get_stu_studyplan_y3s2(
            @Field("student_id") String student_id
    );

    @FormUrlEncoded
    //   Student StudyPlan
    @POST("student_studyplan_y4s1.php")
    Call<List<Response_model_SemesterStudyPlan>> get_stu_studyplan_y4s1(
            @Field("student_id") String student_id
    );

    @FormUrlEncoded
    //   Student StudyPlan
    @POST("student_studyplan_y4s2.php")
    Call<List<Response_model_SemesterStudyPlan>> get_stu_studyplan_y4s2(
            @Field("student_id") String student_id
    );

}
