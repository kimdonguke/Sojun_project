package com.example.sojun_project;

import com.example.sojun_project.fragments.FragmentChart;
import com.example.sojun_project.fragments.FragmentDatemeal;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class PagerAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> mainlist;
    ArrayList<Fragment> protoyupelist;
    String[] title=new String[]{"Borrow","Alert","connect","setting"};

    public PagerAdapter(FragmentManager fm) {
        super(fm);
        mainlist = new ArrayList<>();
        protoyupelist=new ArrayList<>();
        mainlist.add(new FragmentChart());
        mainlist.add(new FragmentDatemeal());
    }
    @Override
    public Fragment getItem(int i) {
        return mainlist.get(i);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

    @Override
    public int getCount() {
        return mainlist.size();
    }
}