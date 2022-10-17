package com.example.useaapp.GUEST.Career;

public class Response_model_guest_career
{
    String id, position_avail, department, job, province, exp_month, exp_date, exp_year, requirement_detail;

    public Response_model_guest_career(String id, String position_avail, String department, String job, String province, String exp_month, String exp_date, String exp_year, String requirement_detail) {
        this.id = id;
        this.position_avail = position_avail;
        this.department = department;
        this.job = job;
        this.province = province;
        this.exp_month = exp_month;
        this.exp_date = exp_date;
        this.exp_year = exp_year;
        this.requirement_detail = requirement_detail;
    }

    public String getId() {
        return id;
    }

    public String getPosition_avail() {
        return position_avail;
    }

    public String getDepartment() {
        return department;
    }

    public String getJob() {
        return job;
    }

    public String getProvince() {
        return province;
    }

    public String getExp_month() {
        return exp_month;
    }

    public String getExp_date() {
        return exp_date;
    }

    public String getExp_year() {
        return exp_year;
    }

    public String getRequirement_detail() {
        return requirement_detail;
    }
}
