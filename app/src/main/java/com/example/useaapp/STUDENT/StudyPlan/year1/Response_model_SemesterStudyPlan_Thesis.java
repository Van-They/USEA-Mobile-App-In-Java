package com.example.useaapp.STUDENT.StudyPlan.year1;

public class Response_model_SemesterStudyPlan_Thesis
{
    String subject_name, credits;

    public Response_model_SemesterStudyPlan_Thesis(String subject_name, String credits) {
        this.subject_name = subject_name;
        this.credits = credits;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public String getCredits() {
        return credits;
    }
}
