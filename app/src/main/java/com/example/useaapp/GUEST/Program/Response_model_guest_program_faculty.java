package com.example.useaapp.GUEST.Program;

import com.google.gson.annotations.SerializedName;

public class Response_model_guest_program_faculty
{
    String id, faculty_name;

    public Response_model_guest_program_faculty(String id, String faculty_name) {
        this.id = id;
        this.faculty_name = faculty_name;
    }

    @SerializedName("id")
    public String getId() {
        return id;
    }

    @SerializedName("faculty_name")
    public String getFaculty_name() {
        return faculty_name;
    }
}
