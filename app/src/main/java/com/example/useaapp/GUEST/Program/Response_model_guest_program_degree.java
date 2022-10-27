package com.example.useaapp.GUEST.Program;

import com.google.gson.annotations.SerializedName;

public class Response_model_guest_program_degree
{
    String id, degree_name;

    public Response_model_guest_program_degree(String id, String degree_name) {
        this.id = id;
        this.degree_name = degree_name;
    }

    @SerializedName("id")
    public String getId() {
        return id;
    }

    @SerializedName("degree_name")
    public String getDegree_name() {
        return degree_name;
    }
}
