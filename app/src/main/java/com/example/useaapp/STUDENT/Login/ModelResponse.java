package com.example.useaapp.STUDENT.Login;

import com.google.gson.annotations.SerializedName;

public class ModelResponse {
    @SerializedName("response")
    String response;
    @SerializedName("name")
    String name;

    public ModelResponse(String response, String name) {
        this.response = response;
        this.name = name;
    }

    public String getResponse() {
        return response;
    }

    public String getName() {
        return name;
    }
}

