package com.example.useaapp.GUEST.Events.upcoming;

public class Response_model_guest_event_upcoming
{
    String id, upcoming_title, upcoming_detail,
            upcoming_image, upcoming_day, upcoming_month,
            upcoming_date, upcoming_year, upcoming_time;

    public Response_model_guest_event_upcoming(String id, String upcoming_title, String upcoming_detail, String upcoming_image, String upcoming_day, String upcoming_month, String upcoming_date, String upcoming_year, String upcoming_time) {
        this.id = id;
        this.upcoming_title = upcoming_title;
        this.upcoming_detail = upcoming_detail;
        this.upcoming_image = upcoming_image;
        this.upcoming_day = upcoming_day;
        this.upcoming_month = upcoming_month;
        this.upcoming_date = upcoming_date;
        this.upcoming_year = upcoming_year;
        this.upcoming_time = upcoming_time;
    }

    public String getId() {
        return id;
    }

    public String getUpcoming_title() {
        return upcoming_title;
    }

    public String getUpcoming_detail() {
        return upcoming_detail;
    }

    public String getUpcoming_image() {
        return upcoming_image;
    }

    public String getUpcoming_day() {
        return upcoming_day;
    }

    public String getUpcoming_month() {
        return upcoming_month;
    }

    public String getUpcoming_date() {
        return upcoming_date;
    }

    public String getUpcoming_year() {
        return upcoming_year;
    }

    public String getUpcoming_time() {
        return upcoming_time;
    }
}
