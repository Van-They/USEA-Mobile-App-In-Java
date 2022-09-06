package com.example.useaapp.guest.guest_registration;

public class Response_model_guest_registration
{
   String id, reg_question, reg_answer;

    public Response_model_guest_registration(String id, String reg_question, String reg_answer) {
        this.id = id;
        this.reg_question = reg_question;
        this.reg_answer = reg_answer;
    }

    public String getId() {
        return id;
    }

    public String getReg_question() {
        return reg_question;
    }

    public String getReg_answer() {
        return reg_answer;
    }
}
