package com.example.sojun_project.Datas;

public class OneDayData {
    private OneMealData breakfast, lunch, dinner;

    public OneDayData(OneMealData breakfast, OneMealData lunch, OneMealData dinner) {
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
    }

    public OneMealData getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(OneMealData breakfast) {
        this.breakfast = breakfast;
    }

    public OneMealData getLunch() {
        return lunch;
    }

    public void setLunch(OneMealData lunch) {
        this.lunch = lunch;
    }

    public OneMealData getDinner() {
        return dinner;
    }

    public void setDinner(OneMealData dinner) {
        this.dinner = dinner;
    }
}
