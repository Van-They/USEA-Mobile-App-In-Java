package com.example.useaapp.GUEST.Events.announcement;

public class Response_model_guest_event_announcement
{
    String id, announce_title, announce_detail,
            announce_image, announce_day, announce_month,
            announce_date, announce_year, announce_time;

    public Response_model_guest_event_announcement(String id, String announce_title, String announce_detail, String announce_image, String announce_day, String announce_month, String announce_date, String announce_year, String announce_time) {
        this.id = id;
        this.announce_title = announce_title;
        this.announce_detail = announce_detail;
        this.announce_image = announce_image;
        this.announce_day = announce_day;
        this.announce_month = announce_month;
        this.announce_date = announce_date;
        this.announce_year = announce_year;
        this.announce_time = announce_time;
    }

    public String getId() {
        return id;
    }

    public String getAnnounce_title() {
        return announce_title;
    }

    public String getAnnounce_detail() {
        return announce_detail;
    }

    public String getAnnounce_image() {
        return announce_image;
    }

    public String getAnnounce_day() {
        return announce_day;
    }

    public String getAnnounce_month() {
        return announce_month;
    }

    public String getAnnounce_date() {
        return announce_date;
    }

    public String getAnnounce_year() {
        return announce_year;
    }

    public String getAnnounce_time() {
        return announce_time;
    }
}
