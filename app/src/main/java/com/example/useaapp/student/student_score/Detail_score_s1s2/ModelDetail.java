package com.example.useaapp.student.student_score.Detail_score_s1s2;
public class ModelDetail {
 private final String  Title,Attendance,Exercise,Homework,Assignment,Midterm, Semester_exam,Total,Grade,Average,Rank;

    public ModelDetail(String title, String attendance, String exercise, String homework, String assignment, String midterm, String semester_exam, String total, String grade, String average, String rank) {
        Title = title;
        Attendance = attendance;
        Exercise = exercise;
        Homework = homework;
        Assignment = assignment;
        Midterm = midterm;
        Semester_exam = semester_exam;
        Total = total;
        Grade = grade;
        Average = average;
        Rank = rank;
    }

    public String getTitle() {
        return Title;
    }

    public String getAttendance() {
        return Attendance;
    }

    public String getExercise() {
        return Exercise;
    }

    public String getHomework() {
        return Homework;
    }

    public String getAssignment() {
        return Assignment;
    }

    public String getMidterm() {
        return Midterm;
    }

    public String getSemester_exam() {
        return Semester_exam;
    }

    public String getTotal() {
        return Total;
    }

    public String getGrade() {
        return Grade;
    }

    public String getAverage() {
        return Average;
    }

    public String getRank() {
        return Rank;
    }
}
