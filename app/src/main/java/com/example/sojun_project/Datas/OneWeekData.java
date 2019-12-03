package com.example.sojun_project.Datas;

import java.util.ArrayList;

public class OneWeekData {
    private ArrayList<OneDayData> oneweekData =new ArrayList<>();

    public OneWeekData(ArrayList<OneDayData> oneweekData) {
        this.oneweekData = oneweekData;
    }

    public ArrayList<OneDayData> getOneweekData() {
        return oneweekData;
    }

    public void setOneweekData(ArrayList<OneDayData> oneweekData) {
        this.oneweekData = oneweekData;
    }
}