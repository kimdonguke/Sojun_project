package com.example.sojun_project.Datas;

import android.graphics.drawable.Drawable;

public class ItemData {
    private String foodname;
    private String foodkalori;
    private String foodhowmuch;
    private Drawable foodimg;

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getFoodkalori() {
        return foodkalori;
    }

    public void setFoodkalori(String foodkalori) {
        this.foodkalori = foodkalori;
    }

    public Drawable getFoodimg() {
        return foodimg;
    }

    public void setFoodimg(Drawable foodimg) {
        this.foodimg = foodimg;
    }

    public String getFoodhowmuch() {
        return foodhowmuch;
    }

    public void setFoodhowmuch(String foodhowmuch) {
        this.foodhowmuch = foodhowmuch;
    }

    public ItemData(String foodname, String foodkalori, String foodhowmuch, Drawable foodimg) {
        this.foodname = foodname;
        this.foodkalori = foodkalori;
        this.foodhowmuch = foodhowmuch;
        this.foodimg = foodimg;
    }
}
