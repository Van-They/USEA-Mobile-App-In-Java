package com.example.useaapp.STUDENT;

import com.example.useaapp.STUDENT.Attendance.Response_model_student_attendance;
import com.example.useaapp.STUDENT.Score.Score.ModelScore;
import com.example.useaapp.STUDENT.StudyPlan.year1.Response_model_SemesterStudyPlan;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Apiset_student
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


    @FormUrlEncoded
    //   Student Attendance
    @POST("student_attendance.php")
    Call<List<Response_model_student_attendance>> get_stu_att(
            @Field("student_id") String student_id
    );

    @FormUrlEncoded
    //   Student Score
    @POST("student_score_y1s1.php")
    Call<List<ModelScore>> get_stu_score_y1s1(
            @Field("student_id") String student_id
    );

    @FormUrlEncoded
    //   Student Score
    @POST("student_score_y1s2.php")
    Call<List<ModelScore>> get_stu_score_y1s2(
            @Field("student_id") String student_id
    );

    @FormUrlEncoded
    //   Student Score
    @POST("student_score_y2s1.php")
    Call<List<ModelScore>> get_stu_score_y2s1(
            @Field("student_id") String student_id
    );

    @FormUrlEncoded
    //   Student Score
    @POST("student_score_y2s2.php")
    Call<List<ModelScore>> get_stu_score_y2s2(
            @Field("student_id") String student_id
    );

    @FormUrlEncoded
    //   Student Score
    @POST("student_score_y3s1.php")
    Call<List<ModelScore>> get_stu_score_y3s1(
            @Field("student_id") String student_id
    );

    @FormUrlEncoded
    //   Student Score
    @POST("student_score_y3s2.php")
    Call<List<ModelScore>> get_stu_score_y3s2(
            @Field("student_id") String student_id
    );

    @FormUrlEncoded
    //   Student Score
    @POST("student_score_y4s1.php")
    Call<List<ModelScore>> get_stu_score_y4s1(
            @Field("student_id") String student_id
    );

    @FormUrlEncoded
    //   Student Score
    @POST("student_score_y4s2.php")
    Call<List<ModelScore>> get_stu_score_y4s2(
            @Field("student_id") String student_id
    );

}
