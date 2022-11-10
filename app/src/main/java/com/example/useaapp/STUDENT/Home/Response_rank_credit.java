package com.example.useaapp.STUDENT.Home;

import com.google.gson.annotations.SerializedName;

public class Response_rank_credit {

    @SerializedName("Total Credit")
    String Credit;

    @SerializedName("name")
    String name;

//    String Rank;

    public Response_rank_credit(String credit, String name) {
        Credit = credit;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //    public String getRank() {
//        return Rank;
//    }

    public String getCredit() {
        return Credit;
    }
}
