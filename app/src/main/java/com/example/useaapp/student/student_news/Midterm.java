package com.example.useaapp.student.student_news;

public class Midterm {
    private final String subject_midterm, exam_date_midterm, time_midterm, room_midterm;

    public Midterm(String subject_midterm, String exam_date_midterm, String time_midterm, String room_midterm) {
        this.subject_midterm = subject_midterm;
        this.exam_date_midterm = exam_date_midterm;
        this.time_midterm = time_midterm;
        this.room_midterm = room_midterm;
    }
    public String getSubject_midterm() {
        return subject_midterm;
    }

    public String getExam_date_midterm() {
        return exam_date_midterm;
    }

    public String getTime_midterm() {
        return time_midterm;
    }

    public String getRoom_midterm() {
        return room_midterm;
    }
}
