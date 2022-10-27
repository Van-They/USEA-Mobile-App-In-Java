package com.example.useaapp.GUEST.Program.associative;

import com.google.gson.annotations.SerializedName;

public class Response_model_guest_program_faculty_asso
{
    String id, major_name;

    public Response_model_guest_program_faculty_asso(String id, String major_name) {
        this.id = id;
        this.major_name = major_name;
    }

    @SerializedName("id")
    public String getId() {
        return id;
    }

    @SerializedName("major_name")
    public String getMajor_name() {
        return major_name;
    }
}
