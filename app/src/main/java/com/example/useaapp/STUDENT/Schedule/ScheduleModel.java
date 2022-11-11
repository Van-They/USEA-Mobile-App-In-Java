package com.example.useaapp.STUDENT.Schedule;

import com.google.gson.annotations.SerializedName;

public class ScheduleModel {
    @SerializedName("class_mon")
    String mon;
    @SerializedName("class_tue")
    String Tu;
    @SerializedName("class_thu")
    String Th;
    @SerializedName("class_wed")
    String Wed;
    @SerializedName("class_fri")
    String Fri;
    @SerializedName("class_sat")
    String Sat;

    public ScheduleModel(String mon, String tu, String th, String wed, String fri, String sat) {
        this.mon = mon;
        Tu = tu;
        Th = th;
        Wed = wed;
        Fri = fri;
        Sat = sat;
    }

    public String getMon() {
        return mon;
    }

    public String getTu() {
        return Tu;
    }

    public String getTh() {
        return Th;
    }

    public String getWed() {
        return Wed;
    }

    public String getFri() {
        return Fri;
    }

    public String getSat() {
        return Sat;
    }
}
