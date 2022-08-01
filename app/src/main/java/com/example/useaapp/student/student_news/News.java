package com.example.useaapp.student.student_news;

public class News {
    private final String subject, date,duedate, time, room,creator,label;
    public News(String subject, String date, String duedate, String time, String room, String creator, String label) {
        this.subject = subject;
        this.date = date;
        this.duedate = duedate;
        this.time = time;
        this.room = room;
        this.creator = creator;
        this.label = label;
    }
    public String getDuedate() {
        return duedate;
    }

    public String getLabel() {
        return label;
    }

    public String getSubject() {
        return subject;
    }

    public String getDate() {
        return date;
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
}
