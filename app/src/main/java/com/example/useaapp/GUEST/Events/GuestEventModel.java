package com.example.useaapp.GUEST.Events;

public class GuestEventModel {
    private final String Detail, Title, Date, Day, Month, Year, Time;
    private final Integer Image;


    public GuestEventModel(Integer image, String title,String detail, String day, String date, String month, String year, String time ) {
        Detail = detail;
        Title = title;
        Date = date;
        Month = month;
        Year = year;
        Time = time;
        Image = image;
        Day = day;
    }

    public String getDetail() {
        return Detail;
    }

    public String getTitle() {
        return Title;
    }

    public String getDate() {
        return Date;
    }

    public String getDay() {
        return Day;
    }

    public String getMonth() {
        return Month;
    }

    public String getYear() {
        return Year;
    }

    public String getTime() {
        return Time;
    }

    public Integer getImage() {
        return Image;
    }
}
