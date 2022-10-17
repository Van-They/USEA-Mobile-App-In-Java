package com.example.useaapp.STUDENT.Schedule;

public class ScheduleModel {
    private final int DayofMonth,Month,Year;

    public ScheduleModel(int dayofMonth, int month, int year) {
        DayofMonth = dayofMonth;
        Month = month;
        Year = year;
    }

    public int getMonth() {
        return Month;
    }

    public int getYear() {
        return Year;
    }

    public int getDayofMonth() {
        return DayofMonth;
    }


}
