package com.example.useaapp.STUDENT.Login;

public class ModelResponse {
    String response, faculty_name, degree_name, major_name, year_name, semester_name, name, stage_name, academic_year,
            shift_name, date_of_birth, phone_number, profile_pic;

    public ModelResponse(String response, String faculty_name, String degree_name, String major_name,
                         String year_name, String semester_name, String name, String stage_name,
                         String academic_year, String shift_name, String date_of_birth, String phone_number,
                         String profile_pic) {
        this.response = response;
        this.faculty_name = faculty_name;
        this.degree_name = degree_name;
        this.major_name = major_name;
        this.year_name = year_name;
        this.semester_name = semester_name;
        this.name = name;
        this.stage_name = stage_name;
        this.academic_year = academic_year;
        this.shift_name = shift_name;
        this.date_of_birth = date_of_birth;
        this.phone_number = phone_number;
        this.profile_pic = profile_pic;
    }

    public String getResponse() {
        return response;
    }

    public String getFaculty_name() {
        return faculty_name;
    }

    public String getDegree_name() {
        return degree_name;
    }

    public String getMajor_name() {
        return major_name;
    }

    public String getYear_name() {
        return year_name;
    }

    public String getSemester_name() {
        return semester_name;
    }

    public String getName() {
        return name;
    }

    public String getStage_name() {
        return stage_name;
    }

    public String getAcademic_year() {
        return academic_year;
    }

    public String getShift_name() {
        return shift_name;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public String getPhone_number() {
        return phone_number;
    }
    public String getProfile_pic() {
        return profile_pic;
    }
}

