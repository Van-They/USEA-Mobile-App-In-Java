package com.example.useaapp.STUDENT.Attendance;

import com.google.gson.annotations.SerializedName;

public class Response_model_student_attendance
{
    String subject_name, permission, absent, present, hours;

    public Response_model_student_attendance(String subject_name, String permission, String absent, String present, String hours) {
        this.subject_name = subject_name;
        this.permission = permission;
        this.absent = absent;
        this.present = present;
        this.hours = hours;
    }

    @SerializedName("subject_name")
    public String getSubject_name() {
        return subject_name;
    }
    @SerializedName("permission")
    public String getPermission() {
        return permission;
    }
    @SerializedName("absent")
    public String getAbsent() {
        return absent;
    }
    @SerializedName("present")
    public String getPresent() {
        return present;
    }
    @SerializedName("hours")
    public String getHours() {
        return hours;
    }
}
