package com.example.useaapp.sample;

public class ModelNews {
    private final String subject, date,duedate, time, room,creator,label;

    public ModelNews(String subject, String date, String duedate, String time, String room, String creator, String label) {
        this.subject = subject;
        this.date = date;
        this.duedate = duedate;
        this.time = time;
        this.room = room;
        this.creator = creator;
        this.label = label;
    }

    public String getSubject() {
        return subject;
    }

    public String getDate() {
        return date;
    }

    public String getDuedate() {
        return duedate;
    }

    public String getTime() {
        return time;
    }

    public String getRoom() {
        return room;
    }

    public String getCreator() {
        return creator;
    }

    public String getLabel() {
        return label;
    }
}
