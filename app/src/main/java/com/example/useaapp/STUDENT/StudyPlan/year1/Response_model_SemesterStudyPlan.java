package com.example.useaapp.STUDENT.StudyPlan.year1;

import com.google.gson.annotations.SerializedName;

public class Response_model_SemesterStudyPlan
{
    @SerializedName("subject_name")
    String subject_name;

    @SerializedName("hours")
    String hours;

    @SerializedName("credits")
    String credits;

    public Response_model_SemesterStudyPlan(String subject_name, String hours, String credits) {
        this.subject_name = subject_name;
        this.hours = hours;
        this.credits = credits;
    }

    public String getSubject_name() {
        return subject_name;
    }
    public String getHours() {
        return hours;
    }
    public String getCredits() {
        return credits;
    }
}
