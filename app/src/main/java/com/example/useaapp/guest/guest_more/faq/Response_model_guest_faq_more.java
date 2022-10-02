package com.example.useaapp.guest.guest_more.faq;

public class Response_model_guest_faq_more
{
    String id, faq_que, faq_ans;

    public Response_model_guest_faq_more(String id, String faq_que, String faq_ans) {
        this.id = id;
        this.faq_que = faq_que;
        this.faq_ans = faq_ans;
    }

    public String getId() {
        return id;
    }

    public String getFaq_que() {
        return faq_que;
    }

    public String getFaq_ans() {
        return faq_ans;
    }
}
