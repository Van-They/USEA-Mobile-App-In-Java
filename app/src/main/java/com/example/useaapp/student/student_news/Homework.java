package com.example.useaapp.student.student_news;

public class Homework {
    private final String subject_homework, due_date_homework, create_by_homework;

    public Homework(String subject_homework, String due_date_homework, String create_by_homework) {
        this.subject_homework = subject_homework;
        this.due_date_homework = due_date_homework;
        this.create_by_homework = create_by_homework;
    }

    public String getSubject_homework() {
        return subject_homework;
    }

    public String getDue_date_homework() {
        return due_date_homework;
    }

    public String getCreate_by_homework() {
        return create_by_homework;
    }
}
