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
        if (convertView==null){
            convertView = inflater.inflate(R.layout.custom_item_schedule,parent,false);
        }
        TextView DayofMonth,Month,Year;
        DayofMonth = convertView.findViewById(R.id.DayofMonth_student_schedule);
        Month = convertView.findViewById(R.id.Month_student_schedule);
        Year = convertView.findViewById(R.id.Year_student_schedule);
        ScheduleModel scheduleModel = arrlist.get(position);
        DayofMonth.setText(String.valueOf(scheduleModel.getDayofMonth()));
        Month.setText(String.valueOf(scheduleModel.getMonth()+1));
        Year.setText(String.valueOf(scheduleModel.getYear()));

        return convertView;
    }
}
