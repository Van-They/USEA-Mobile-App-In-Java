package com.example.useaapp.guest.guest_more.about_us;

public class Response_model_guest_about_us_more
{
    String id, guest_usea_logo, guest_usea_name, guest_usea_detail;

    public Response_model_guest_about_us_more(String id, String guest_usea_logo, String guest_usea_name, String guest_usea_detail) {
        this.id = id;
        this.guest_usea_logo = guest_usea_logo;
        this.guest_usea_name = guest_usea_name;
        this.guest_usea_detail = guest_usea_detail;
    }

    public String getId() {
        return id;
    }

    public String getGuest_usea_logo() {
        return guest_usea_logo;
    }

    public String getGuest_usea_name() {
        return guest_usea_name;
    }

    public String getGuest_usea_detail() {
        return guest_usea_detail;
    }
}
