package com.example.useaapp.STUDENT.Feedback;

import com.google.gson.annotations.SerializedName;

public class ServerResponse {
    @SerializedName("response")
    String response;

    public ServerResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }
}
