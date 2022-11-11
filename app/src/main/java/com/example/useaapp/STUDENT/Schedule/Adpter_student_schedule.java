package com.example.useaapp.STUDENT.Schedule;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.useaapp.R;

import java.util.List;

public class Adpter_student_schedule extends BaseAdapter {
    Context context;
    List<ScheduleModel> arrlist;
    LayoutInflater inflater;

    public Adpter_student_schedule(Context context, List<ScheduleModel> arrlist) {
        this.context = context;
        this.arrlist = arrlist;
        inflater = LayoutInflater.from(context.getApplicationContext());
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    @Override
    public int getCount() {
        return arrlist.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.custom_item_schedule, parent, false);
        }
        TextView day_study, subject;
        day_study = convertView.findViewById(R.id.day_study);

        subject = convertView.findViewById(R.id.subject_study);
        ScheduleModel scheduleModel = arrlist.get(position);

        switch (position) {
            case 0:
                day_study.setText("ច័ន្ទ");
                if (scheduleModel.getMon().equals("")) {
                    subject.setTextColor(Color.RED);
                    subject.setText("Group Study");
                } else {
                    subject.setTextColor(Color.BLACK);
                    subject.setText(scheduleModel.getMon());
                }
                break;
            case 1:
                day_study.setText("អង្គារ");

                if (scheduleModel.getTu().equals("")) {
                    subject.setTextColor(Color.RED);
                    subject.setText("Group Study");
                } else {
                    subject.setTextColor(Color.BLACK);
                    subject.setText(scheduleModel.getTu());
                }
                break;
            case 2:
                day_study.setText("ពុធ");

                if (scheduleModel.getWed().equals("")) {
                    subject.setTextColor(Color.RED);
                    subject.setText("Group Study");
                } else {
                    subject.setTextColor(Color.BLACK);
                    subject.setText(scheduleModel.getWed());
                }
                break;
            case 3:
                day_study.setText("ព្រហស្បត៏");

                if (scheduleModel.getTh().equals("")) {
                    subject.setTextColor(Color.RED);
                    subject.setText("Group Study");
                } else {
                    subject.setTextColor(Color.BLACK);
                    subject.setText(scheduleModel.getTh());
                }
                break;
            case 4:
                day_study.setText("សុក្រ");

                if (scheduleModel.getFri().equals("")) {
                    subject.setTextColor(Color.RED);
                    subject.setText("Group Study");
                } else {
                    subject.setTextColor(Color.BLACK);
                    subject.setText(scheduleModel.getFri());
                }
                break;
            case 5:
                day_study.setText("សៅរ៍");

                if (scheduleModel.getSat().equals("")) {
                    subject.setTextColor(Color.RED);
                    subject.setText("Group Study");
                } else {
                    subject.setTextColor(Color.BLACK);
                    subject.setText(scheduleModel.getSat());
                }
                break;
        }
        return convertView;
    }
}
