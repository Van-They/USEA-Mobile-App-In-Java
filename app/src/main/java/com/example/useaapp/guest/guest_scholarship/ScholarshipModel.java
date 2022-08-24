package com.example.useaapp.guest.guest_scholarship;

public class ScholarshipModel {
    private final String Title,Fee,Degree,Date,Month,Year;

    public ScholarshipModel(String title, String degree, String fee, String date, String month, String year) {
        this.Title = title;
        this.Fee = fee;
        this.Degree = degree;
        this.Date = date;
        this.Month = month;
        this.Year = year;
    }

    public String getTitle() {
        return Title;
    }

    public String getFee() {
        return Fee;
    }

    public String getDegree() {
        return Degree;
    }

    public String getDate() {
        return Date;
    }

    public String getMonth() {
        return Month;
    }

    public String getYear() {
        return Year;
    }

}
