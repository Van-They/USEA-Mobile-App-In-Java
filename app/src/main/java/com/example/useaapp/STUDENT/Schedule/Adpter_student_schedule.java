package com.example.useaapp.STUDENT.Schedule;

import android.content.Context;
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
        TextView day_study, subject_mon, subject_tue, subject_wed, subject_thu, subject_fri, subject_sat, subject;
        day_study = convertView.findViewById(R.id.day_study);

        subject = convertView.findViewById(R.id.subject_study);
//        subject_mon = convertView.findViewById(R.id.subject_mon);
//        subject_tue = convertView.findViewById(R.id.subject_tue);
//        subject_wed = convertView.findViewById(R.id.subject_wed);
//        subject_thu = convertView.findViewById(R.id.subject_thu);
//        subject_fri = convertView.findViewById(R.id.subject_fri);
//        subject_sat = convertView.findViewById(R.id.subject_sat);
        ScheduleModel scheduleModel = arrlist.get(position);

        switch (position) {
            case 0:
                day_study.setText("ច័ន្ទ");
                subject.setText(scheduleModel.getMon());
                break;
            case 1:
                day_study.setText("អង្គារ");
                subject.setText(scheduleModel.getTu());
                break;
            case 2:
                day_study.setText("ពុធ");
                subject.setText(scheduleModel.getWed());
                break;
            case 3:
                day_study.setText("ព្រហស្បតិ៍");
                subject.setText(scheduleModel.getTh());
                break;
            case 4:
                day_study.setText("សុក្រ");
                subject.setText(scheduleModel.getFri());
                break;
            case 5:
                day_study.setText("សៅរ៍");
                subject.setText(scheduleModel.getSat());
                break;
        }
//        subject_tue.setText(scheduleModel.getTu());
//        subject_wed.setText(scheduleModel.getWed());
//        subject_thu.setText(scheduleModel.getTh());
//        subject_fri.setText(scheduleModel.getFri());
//        subject_sat.setText(scheduleModel.getSat());
        return convertView;
    }
}
