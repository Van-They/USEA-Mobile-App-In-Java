package com.example.useaapp.STUDENT.Score.Score;

import com.google.gson.annotations.SerializedName;

public class ModelScore {

    private final String name, year_name, semester_name, subject_name, sc_at, sc_ex, sc_hw, sc_as, sc_mt, sc_fn, Total_Score, Average_Score, Grade, RANK;

    public ModelScore(String name, String year_name, String semester_name, String subject_name, String sc_at, String sc_ex, String sc_hw, String sc_as, String sc_mt, String sc_fn, String Total_Score, String Average_Score, String Grade, String RANK) {
        this.name = name;
        this.year_name = year_name;
        this.semester_name = semester_name;
        this.subject_name = subject_name;
        this.sc_at = sc_at;
        this.sc_ex = sc_ex;
        this.sc_hw = sc_hw;
        this.sc_as = sc_as;
        this.sc_mt = sc_mt;
        this.sc_fn = sc_fn;
        this.Total_Score = Total_Score;
        this.Average_Score = Average_Score;
        this.Grade = Grade;
        this.RANK = RANK;
    }

    @SerializedName("name")
    public String getName() {
        return name;
    }

    @SerializedName("year_name")
    public String getYear_name() {
        return year_name;
    }

    @SerializedName("semester_name")
    public String getSemester_name() {
        return semester_name;
    }

    @SerializedName("subject_name")
    public String getSubject_name() {
        return subject_name;
    }

    @SerializedName("sc_at")
    public String getSc_at() {
        return sc_at;
    }

    @SerializedName("sc_ex")
    public String getSc_ex() {
        return sc_ex;
    }

    @SerializedName("sc_hw")
    public String getSc_hw() {
        return sc_hw;
    }

    @SerializedName("sc_as")
    public String getSc_as() {
        return sc_as;
    }

    @SerializedName("sc_mt")
    public String getSc_mt() {
        return sc_mt;
    }

    @SerializedName("sc_fn")
    public String getSc_fn() {
        return sc_fn;
    }

    @SerializedName("Total_Score")
    public String getTotal_Score() {
        return Total_Score;
    }

    @SerializedName("Average_Score")
    public String getAverage_Score() {
        return Average_Score;
    }

    @SerializedName("Grade")
    public String getGrade() {
        return Grade;
    }

    @SerializedName("RANK")
    public String getRANK() {
        return RANK;
    }
}
