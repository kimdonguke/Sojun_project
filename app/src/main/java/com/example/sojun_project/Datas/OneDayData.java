package com.example.sojun_project.Datas;

import android.content.ClipData;

import java.util.ArrayList;

public class OneDayData {
   private ArrayList<ItemData> morning, lunch, dinner;

    public ArrayList<ItemData> getDinner() {
        return dinner;
    }

    public void setDinner(ArrayList<ItemData> dinner) {
        this.dinner = dinner;
    }

    public ArrayList<ItemData> getLunch() {
        return lunch;
    }

    public void setLunch(ArrayList<ItemData> lunch) {
        this.lunch = lunch;
    }

    public ArrayList<ItemData> getMorning() {
        return morning;
    }

    public void setMorning(ArrayList<ItemData> morning) {
        this.morning = morning;
    }

    public OneDayData(ArrayList<ItemData> morning, ArrayList<ItemData> lunch, ArrayList<ItemData> dinner) {
        this.morning = morning;
        this.lunch = lunch;
        this.dinner = dinner;
    }
}
