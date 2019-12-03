package com.example.sojun_project.activities;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sojun_project.Datas.ItemData;
import com.example.sojun_project.Datas.OneDayData;
import com.example.sojun_project.Datas.OneWeekData;
import com.example.sojun_project.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class MakePrototype extends AppCompatActivity {

    String TAG="MakePrototype.activity";

    GimoringAdapter gimoringAdapter;
    RecyclerView recyclerView;
    ArrayList<ItemData> morning, lunch, dinner;
    ArrayList<ItemData> itemData = new ArrayList<>();
    Button save, next, add;
    SharedPreferences sharedPreferences;
    TextView nowTime;

    final int GET_GALLERY_IMAGE = 200; // 갤러리 호출 코드

    ImageButton foodProfile;
    EditText foodName, foodKalori, foodHowmuch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_prototype);


        sharedPreferences= getSharedPreferences("sFile",MODE_PRIVATE); // 셰어드 프리페런스 실행

        morning=new ArrayList<>(); //ArrayList 초기화
        lunch=new ArrayList<>();
        dinner=new ArrayList<>();

        recyclerView= findViewById(R.id.makeprototype_recyclerview); //recyclered view connect
        recyclerView.setLayoutManager(new LinearLayoutManager(this));//아니 형 이거 ㅇ내가 전에 짯던 코드에선 잘 돌아갔는데 이게 맞ㅈ눈지 모르겠어
        gimoringAdapter=new GimoringAdapter(itemData);
        recyclerView.setAdapter(gimoringAdapter);

        save=findViewById(R.id.makeprototype_savebtn); //각 뷰들 연결
        next=findViewById(R.id.makeprototype_gonextbtn);
        add=findViewById(R.id.makeprototype_addbtn);
        nowTime=findViewById(R.id.makeprototype_timetext);
        foodProfile=findViewById(R.id.makeprototype_imgbtn);
        foodName=findViewById(R.id.makeprototype_foodname);
        foodKalori=findViewById(R.id.makeprototype_kalori);
        foodHowmuch=findViewById(R.id.makeprototype_howmuch);

        save.setOnClickListener(new View.OnClickListener() { //셰어드 프리페런스에 저장, 각 값은 MORNING LUNCH DINNER로 저장됨 (nowText)
            @Override
            public void onClick(View v) {
                Log.e(TAG,"save button pressed");
                switch (nowTime.getText().toString()){
                    case "MORNING":
                        if(morning.isEmpty()) {//recyclered view 비었는지 확인
                            Toast.makeText(MakePrototype.this, "적어도 하나의 아이템을 추가해주세요", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            setStringArrayPref(MakePrototype.this, nowTime.getText().toString(), morning);
                        }
                        break;
                    case "LUNCH":
                        if(lunch.isEmpty()) {
                            Toast.makeText(MakePrototype.this, "적어도 하나의 아이템을 추가해주세요", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            setStringArrayPref(MakePrototype.this, nowTime.getText().toString(), morning);
                        }
                        break;
                    case "DINNER":
                        if(dinner.isEmpty()) {
                            Toast.makeText(MakePrototype.this, "적어도 하나의 아이템을 추가해주세요", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            setStringArrayPref(MakePrototype.this, nowTime.getText().toString(), morning);
                        }
                        break;
                        default:
                            Log.e("make_prototype","timetext is null");
                            break;
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {// 다음 시간으로 넘어가기
            @Override
            public void onClick(View v) {
                Toast.makeText(MakePrototype.this, "pressed", Toast.LENGTH_SHORT).show();
                switch (nowTime.getText().toString()){
                    case "MORNING":
                        if(morning.isEmpty()){
                            Toast.makeText(MakePrototype.this, "아이템을 저장해주세요", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            next.setText("DINNER");//버튼 시간, 한 시간 압선걸 알려줌 (ex 만약 지금이 아침이라면 lunch)
                            nowTime.setText("LUNCH");//현재 시간임
                            gimoringAdapter.updateData(lunch);
                        }
                        break;
                    case "LUNCH":
                        if (lunch.isEmpty()){
                            Toast.makeText(MakePrototype.this, "아이템을 저장해주세요", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            nowTime.setText("DINNER");
                            next.setText("FINISH");
                            gimoringAdapter.updateData(dinner);
                        }
                        break;
                    case "DINNER":
                        if (dinner.isEmpty()){
                            Toast.makeText(MakePrototype.this,"아이템을 저장해주세요",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Intent intent = new Intent(getApplicationContext(), ViewPagerActivity.class);
                            startActivity(intent);
                        }
                        break;
                        default:
                            Toast.makeText(MakePrototype.this, "nowTIme is warn", Toast.LENGTH_SHORT).show();
                            break;
                }
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG,foodName.getText().toString()+foodKalori.getText());
                if(foodName.getText().toString().matches("")&&foodKalori.getText().toString().matches("")&&foodHowmuch.getText().toString().matches("")) {
                    Toast.makeText(MakePrototype.this, "각 입력 칸을 모두 채워주세요", Toast.LENGTH_SHORT).show();
                }
                else {
                    switch (nowTime.getText().toString()) {
                        case "MORNING":
                            itemData.add(addItem(foodName.getText().toString(),foodKalori.getText().toString(),foodHowmuch.getText().toString(),foodProfile.getDrawable()));
                            morning.add(addItem(foodName.getText().toString(),foodKalori.getText().toString(),foodHowmuch.getText().toString(),foodProfile.getDrawable()));
                            gimoringAdapter.notifyDataSetChanged();
                            break;
                        case "LUNCH":
                            itemData.add(addItem(foodName.getText().toString(),foodKalori.getText().toString(),foodHowmuch.getText().toString(),foodProfile.getDrawable()));
                            lunch.add(addItem(foodName.getText().toString(),foodKalori.getText().toString(),foodHowmuch.getText().toString(),foodProfile.getDrawable()));
                            gimoringAdapter.notifyDataSetChanged();
                            break;
                        case "DINNER":
                            itemData.add(addItem(foodName.getText().toString(),foodKalori.getText().toString(),foodHowmuch.getText().toString(),foodProfile.getDrawable()));
                            dinner.add(addItem(foodName.getText().toString(),foodKalori.getText().toString(),foodHowmuch.getText().toString(),foodProfile.getDrawable()));
                            gimoringAdapter.notifyDataSetChanged();
                            break;
                        default:
                            Log.e(TAG, "something is wrong");
                            break;
                    }
                }
            }
        });
        foodProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent. setDataAndType(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent, GET_GALLERY_IMAGE);
            }
        });
    }
    private void setStringArrayPref(Context context, String key, ArrayList<ItemData> values) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        JSONArray a = new JSONArray();
        for (int i = 0; i < values.size(); i++) {
            a.put(values.get(i));
        }
        if (!values.isEmpty()) {
            editor.putString(key, a.toString());
        } else {
            editor.putString(key, null);
        }
        editor.apply();
        Log.e(TAG,key+"has saved");
    }
    private void setStringArrayPref_oneday(Context context, String key, ArrayList<ItemData> values) { // save to sharedpreference onedaydata
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        JSONArray a = new JSONArray();
        for (int i = 0; i < values.size(); i++) {
            a.put(values.get(i));
        }
        if (!values.isEmpty()) {
            editor.putString(key, a.toString());
        } else {
            editor.putString(key, null);
        }
        editor.apply();
        Log.e(TAG,key+"has saved");
    }
    private void setStringArrayPref_oneweek(Context context, String key, ArrayList<ItemData> values) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        JSONArray a = new JSONArray();
        for (int i = 0; i < values.size(); i++) {
            a.put(values.get(i));
        }
        if (!values.isEmpty()) {
            editor.putString(key, a.toString());
        } else {
            editor.putString(key, null);
        }
        editor.apply();
        Log.e(TAG,key+"has saved");
    }
    public ItemData addItem( String name, String kalori,String howmuch, Drawable foodpicture){
        ItemData item= new ItemData(name,kalori,howmuch,foodpicture);
        return item;
    }
    public void makefullPrototype(ArrayList<ItemData> moring, ArrayList<ItemData> luch, ArrayList<ItemData> diner){

        OneDayData oneDayData = null;
        OneWeekData oneWeekData=null;
        ArrayList<OneDayData> onedaydata_list=new ArrayList<>();
        oneDayData.setMorning(moring);
        oneDayData.setLunch(luch);
        oneDayData.setDinner(diner);
        for(int i=0;i<7;i++){
            onedaydata_list.add(oneDayData);
        }
        oneWeekData.setOneweekData(onedaydata_list);

    }
}
