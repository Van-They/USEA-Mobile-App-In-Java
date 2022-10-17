package com.example.useaapp.GUEST.Scholarship;

public class Response_model_guest_scholarship
{
    String id, subject, university, degree, cost, date, month, year, usea_name,
        detail_description, app_open_date, app_open_final_day_date, learnmore_link,
        app_required, how_to_apply_link, single_pay, full_ben_detail_link,
        citizen_require_detail, total_value_price, applicable_study_areas_detail;

    public Response_model_guest_scholarship(String id, String subject, String university, String degree,
                                            String cost, String date, String month, String year, String usea_name,
                                            String detail_description, String app_open_date,
                                            String app_open_final_day_date, String learnmore_link,
                                            String app_required, String how_to_apply_link, String single_pay,
                                            String full_ben_detail_link, String citizen_require_detail, String total_value_price,
                                            String applicable_study_areas_detail) {
        this.id = id;
        this.subject = subject;
        this.university = university;
        this.degree = degree;
        this.cost = cost;
        this.date = date;
        this.month = month;
        this.year = year;
        this.usea_name = usea_name;
        this.detail_description = detail_description;
        this.app_open_date = app_open_date;
        this.app_open_final_day_date = app_open_final_day_date;
        this.learnmore_link = learnmore_link;
        this.app_required = app_required;
        this.how_to_apply_link = how_to_apply_link;
        this.single_pay = single_pay;
        this.full_ben_detail_link = full_ben_detail_link;
        this.citizen_require_detail = citizen_require_detail;
        this.total_value_price = total_value_price;
        this.applicable_study_areas_detail = applicable_study_areas_detail;

    }
    public String getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public String getUniversity() {
        return university;
    }

    public String getDegree() {
        return degree;
    }

    public String getCost() {
        return cost;
    }

    public String getDate() {
        return date;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getUsea_name() {
        return usea_name;
    }

    public String getDetail_description() {
        return detail_description;
    }

    public String getApp_open_date() {
        return app_open_date;
    }

    public String getApp_open_final_day_date() {
        return app_open_final_day_date;
    }

    public String getLearnmore_link() {
        return learnmore_link;
    }

    public String getApp_required() {
        return app_required;
    }

    public String getHow_to_apply_link() {
        return how_to_apply_link;
    }

    public String getSingle_pay() {
        return single_pay;
    }

    public String getFull_ben_detail_link() {
        return full_ben_detail_link;
    }

    public String getCitizen_require_detail() {
        return citizen_require_detail;
    }

    public String getTotal_value_price(){
        return total_value_price;
    }

    public String getApplicable_study_areas_detail() {
        return applicable_study_areas_detail;
    }
}
