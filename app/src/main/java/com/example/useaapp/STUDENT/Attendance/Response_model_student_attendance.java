package com.example.useaapp.STUDENT.Attendance;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response_model_student_attendance {
    @SerializedName("subject_name")
    @Expose
    String subject_name;
    @SerializedName("permission")
    @Expose
    String permission;
    @SerializedName("absent")
    @Expose
    String absent;
    @SerializedName("present")
    @Expose
    String present;
    @SerializedName("hours")
    @Expose
    String hours;

    public Response_model_student_attendance(String subject_name, String permission, String absent, String present, String hours) {
        this.subject_name = subject_name;
        this.permission = permission;
        this.absent = absent;
        this.present = present;
        this.hours = hours;
    }


    public String getSubject_name() {
        return subject_name;
    }


    public String getPermission() {
        return permission;
    }


    public String getAbsent() {
        return absent;
    }


    public String getPresent() {
        return present;
    }


    public String getHours() {
        return hours;
    }
}
