package com.example.useaapp.STUDENT.Home;

import com.google.gson.annotations.SerializedName;

public class Response_rank_credit {

    @SerializedName("Total Credit")
    String Credit;

    @SerializedName("Rank")
    String Rank;

    @SerializedName("response")
    String Response;

    public Response_rank_credit(String credit, String rank, String response) {
        Credit = credit;
        Rank = rank;
        Response = response;
    }

    public String getResponse() {
        return Response;
    }

    public String getRank() {
        return Rank;
    }

    public String getCredit() {
        return Credit;
    }
}
