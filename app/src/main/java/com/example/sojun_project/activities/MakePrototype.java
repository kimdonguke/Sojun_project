package com.example.sojun_project.activities;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sojun_project.Datas.ItemData;
import com.example.sojun_project.R;
import com.example.sojun_project.fragments.SimpleTextAdapter;

import java.util.ArrayList;

public class MakePrototype extends AppCompatActivity {
    GimoringAdapter gimoringAdapter;
    RecyclerView recyclerView;
    ArrayList<ItemData> morning, lunch, dinner;
    ArrayList<ItemData> itemData = new ArrayList<>();
    Button save, next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_prototype);

        morning=new ArrayList<>();
        lunch=new ArrayList<>();
        dinner=new ArrayList<>();

        recyclerView= findViewById(R.id.makeprototype_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));//아니 형 이거 ㅇ내가 전에 짯던 코드에선 잘 돌아갔는데 이게 맞ㅈ눈지 모르겠어
        gimoringAdapter=new GimoringAdapter(itemData);
        recyclerView.setAdapter(gimoringAdapter);

        save=findViewById(R.id.makeprototype_savebtn);
        next=findViewById(R.id.makeprototype_gonextbtn);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
