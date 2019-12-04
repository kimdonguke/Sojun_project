package com.example.sojun_project.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sojun_project.Datas.ItemData;
import com.example.sojun_project.Datas.OneWeekData;
import com.example.sojun_project.R;
import com.example.sojun_project.activities.ModifyDateFooditem;
import com.example.sojun_project.activities.ViewPagerActivity;

import org.json.JSONArray;
import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentDatemeal extends Fragment {
    SimpleTextAdapter recyclerViewAdapter;
    RecyclerView recyclerView;
    Button button,moning,luch,diner;
    ArrayList<ItemData> itemData,morning,lunch,dinner;
    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Context context=getContext();
        View v= inflater.inflate(R.layout.datemeal_fragment, container, false);

        ViewPagerActivity viewPagerActivity=(ViewPagerActivity)getActivity();
        //OneWeekData oneWeekData=viewPagerActivity.oneWeekData;

        itemData=new ArrayList<>();
        morning = new ArrayList<>();
        lunch = new ArrayList<>();
        dinner=new ArrayList<>();

        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat sdfNow = new SimpleDateFormat("HH:mm");
        String formatDate = sdfNow.format(date);

        recyclerView= v.findViewById(R.id.dateview_frag_daterecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));//아니 형 이거 ㅇ내가 전에 짯던 코드에선 잘 돌아갔는데 이게 맞ㅈ눈지 모르겠어
        recyclerViewAdapter=new SimpleTextAdapter(itemData);
        recyclerView.setAdapter(recyclerViewAdapter);

        button=v.findViewById(R.id.dateview_frag_addtestbtn);
        moning=v.findViewById(R.id.datemeal_morning);
        luch=v.findViewById(R.id.datemeal_lunch);
        diner=v.findViewById(R.id.datemeal_dinner);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), ModifyDateFooditem.class);
                startActivity(intent);
            }
        });
        moning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("datemeal fragment","-morning");
                recyclerViewAdapter.updateData(morning);
                recyclerViewAdapter.notifyDataSetChanged();
            }
        });
        luch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("datemeal fragment","-lunch");
                recyclerViewAdapter.updateData(lunch);
                recyclerViewAdapter.notifyDataSetChanged();
            }
        });
        diner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("datemeal fragment","-dinner");
                recyclerViewAdapter.updateData(dinner);
                recyclerViewAdapter.notifyDataSetChanged();
            }
        });
        return  v;
    }
}
