package com.example.useaapp.guest.guest_events.current;

public class Response_model_guest_event_current
{
    String id, cur_title, cur_detail,
            cur_image, cur_day, cur_month,
            cur_date, cur_year, cur_time;

    public Response_model_guest_event_current(String id, String cur_title, String cur_detail, String cur_image, String cur_day, String cur_month, String cur_date, String cur_year, String cur_time) {
        this.id = id;
        this.cur_title = cur_title;
        this.cur_detail = cur_detail;
        this.cur_image = cur_image;
        this.cur_day = cur_day;
        this.cur_month = cur_month;
        this.cur_date = cur_date;
        this.cur_year = cur_year;
        this.cur_time = cur_time;
    }

    public String getId() {
        return id;
    }

    public String getCur_title() {
        return cur_title;
    }

    public String getCur_detail() {
        return cur_detail;
    }

    public String getCur_image() {
        return cur_image;
    }

    public String getCur_day() {
        return cur_day;
    }

    public String getCur_month() {
        return cur_month;
    }

    public String getCur_date() {
        return cur_date;
    }

    public String getCur_year() {
        return cur_year;
    }

    public String getCur_time() {
        return cur_time;
    }
}
