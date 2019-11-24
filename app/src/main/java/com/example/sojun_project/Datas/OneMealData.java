package com.example.sojun_project.Datas;

import java.util.ArrayList;

public class OneMealData {
    private ArrayList<ItemData> onemealData=new ArrayList<>();

    public OneMealData(ArrayList<ItemData> onemealData) {
        this.onemealData = onemealData;
    }

    public ArrayList<ItemData> getOnemealData() {
        return onemealData;
    }

    public void setOnemealData(ArrayList<ItemData> onemealData) {
        this.onemealData = onemealData;
    }
}
