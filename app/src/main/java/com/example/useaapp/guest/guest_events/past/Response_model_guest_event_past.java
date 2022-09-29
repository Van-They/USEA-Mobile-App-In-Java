package com.example.useaapp.guest.guest_events.past;

public class Response_model_guest_event_past
{
    String id, past_title, past_detail,
            past_image, past_day, past_month,
            past_date, past_year, past_time;

    public Response_model_guest_event_past(String id, String past_title, String past_detail, String past_image, String past_day, String past_month, String past_date, String past_year, String past_time) {
        this.id = id;
        this.past_title = past_title;
        this.past_detail = past_detail;
        this.past_image = past_image;
        this.past_day = past_day;
        this.past_month = past_month;
        this.past_date = past_date;
        this.past_year = past_year;
        this.past_time = past_time;
    }

    public String getId() {
        return id;
    }

    public String getPast_title() {
        return past_title;
    }

    public String getPast_detail() {
        return past_detail;
    }

    public String getPast_image() {
        return past_image;
    }

    public String getPast_day() {
        return past_day;
    }

    public String getPast_month() {
        return past_month;
    }

    public String getPast_date() {
        return past_date;
    }

    public String getPast_year() {
        return past_year;
    }

    public String getPast_time() {
        return past_time;
    }
}
