package com.example.useaapp.student.student_score;

public class ModelScore {
    private final String Subject_score,Rank_score,Grade_score,Total_score;

    public ModelScore(String subject_score, String rank_score, String grade_score, String total_score) {
        Subject_score = subject_score;
        Rank_score = rank_score;
        Grade_score = grade_score;
        Total_score = total_score;
    }

    public String getSubject_score() {
        return Subject_score;
    }

    public String getRank_score() {
        return Rank_score;
    }

    public String getGrade_score() {
        return Grade_score;
    }

    public String getTotal_score() {
        return Total_score;
    }
}
