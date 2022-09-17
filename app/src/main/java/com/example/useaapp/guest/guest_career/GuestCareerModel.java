package com.example.useaapp.guest.guest_career;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.useaapp.R;

public class GuestCareerModel {
    private final String Title, Detail, Province,Month, Date , Year;
    public GuestCareerModel(String title, String detail, String province, String month, String date, String year) {
        Title = title;
        Detail = detail;
        Province = province;
        Month = month;
        Date= date;
        Year = year;

    }

    public String getTitle() {
        return Title;
    }

    public String getDetail() {
        return Detail;
    }

    public String getProvince() {
        return Province;
    }

    public String getMonth() {
        return Month;
    }

    public String getDate() {
        return Date;
    }

    public String getYear() {
        return Year;
    }

}