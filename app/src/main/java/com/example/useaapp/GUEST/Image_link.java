package com.example.useaapp.GUEST;

public class Image_link {

    public static Image_link instant = null;

    public String url;

    private Image_link() {
        url = "http://192.168.0.170/USEA/Guest/event_image/";
    }

    public static Image_link getInstant() {
        if (instant == null) {
            instant = new Image_link();
        }
        return instant;
    }

}
