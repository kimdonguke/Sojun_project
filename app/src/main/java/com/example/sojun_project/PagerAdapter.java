package com.example.sojun_project;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class PagerAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> list;
    String[] title=new String[]{"Borrow","Alert","connect","setting"};

    public PagerAdapter(FragmentManager fm) {
        super(fm);
        list = new ArrayList<>();
    }
    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

    @Override
    public int getCount() {
        return list.size();
    }
}