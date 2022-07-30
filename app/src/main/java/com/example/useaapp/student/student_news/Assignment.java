package com.example.useaapp.student.student_news;

public class Assignment {
    private final String subject_assignment, due_date_assignment, create_by_assigment;

    public Assignment(String subject_assignment, String due_date_assignment, String create_by_assigment) {
        this.subject_assignment = subject_assignment;
        this.due_date_assignment = due_date_assignment;
        this.create_by_assigment = create_by_assigment;
    }

    public String getSubject_assignment() {
        return subject_assignment;
    }

    public String getDue_date_assignment() {
        return due_date_assignment;
    }

    public String getCreate_by_assigment() {
        return create_by_assigment;
    }
}
