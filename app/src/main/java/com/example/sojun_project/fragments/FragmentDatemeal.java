package com.example.sojun_project.fragments;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.sojun_project.Datas.ItemData;
import com.example.sojun_project.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentDatemeal extends Fragment {
    SimpleTextAdapter recyclerViewAdapter;
    RecyclerView recyclerView;
    Button button;
    ArrayList<ItemData> itemData = new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Context context=getContext();
        View v= inflater.inflate(R.layout.datemeal_fragment, container, false);

        recyclerView= v.findViewById(R.id.dateview_frag_daterecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));//아니 형 이거 ㅇ내가 전에 짯던 코드에선 잘 돌아갔는데 이게 맞ㅈ눈지 모르겠어
        recyclerViewAdapter=new SimpleTextAdapter(itemData);
        recyclerView.setAdapter(recyclerViewAdapter);
        button=v.findViewById(R.id.dateview_frag_addtestbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("fragmentdatemeal","add 버튼 눌렀어요 씨발");
                itemData.add(addItem("김민준","300kcal","5",getResources().getDrawable(R.drawable.justno)));
                recyclerViewAdapter.notifyDataSetChanged();
                // 형 디코 켜 ^^ㅣ발
            }
        });
        return  v;
    }
    public ItemData addItem( String name, String kalori,String howmuch, Drawable foodpicture){
        ItemData item= new ItemData(name,kalori,howmuch,foodpicture);
        return item;
    }
}
