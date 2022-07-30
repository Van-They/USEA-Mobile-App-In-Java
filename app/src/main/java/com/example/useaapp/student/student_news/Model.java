package com.example.useaapp.student.student_news;

public class Model {
    private final int view;
    private final Object object;

    public Model(int view, Object object) {
        this.view = view;
        this.object = object;
    }

    public int getViewType() {
        return view;
    }

    public Object getObject() {
        return object;
    }
}
