package com.example.sojun_project.activities;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sojun_project.Datas.ItemData;
import com.example.sojun_project.R;
import com.example.sojun_project.fragments.SimpleTextAdapter;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class MakePrototype extends AppCompatActivity {
    GimoringAdapter gimoringAdapter;
    RecyclerView recyclerView;
    ArrayList<ItemData> morning, lunch, dinner;
    ArrayList<ItemData> itemData = new ArrayList<>();
    Button save, next, add;
    SharedPreferences sharedPreferences;
    TextView nowTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_prototype);

        sharedPreferences= getSharedPreferences("sFile",MODE_PRIVATE);

        morning=new ArrayList<>();
        lunch=new ArrayList<>();
        dinner=new ArrayList<>();

        recyclerView= findViewById(R.id.makeprototype_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));//아니 형 이거 ㅇ내가 전에 짯던 코드에선 잘 돌아갔는데 이게 맞ㅈ눈지 모르겠어
        gimoringAdapter=new GimoringAdapter(itemData);
        recyclerView.setAdapter(gimoringAdapter);

        save=findViewById(R.id.makeprototype_savebtn);
        next=findViewById(R.id.makeprototype_gonextbtn);
        add=findViewById(R.id.makeprototype_addbtn);
        nowTime=findViewById(R.id.makeprototype_timetext);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (nowTime.getText().toString()){
                    case "MORNING":
                        setStringArrayPref(MakePrototype.this,nowTime.getText().toString(),morning);
                        break;
                    case "LUNCH":
                        setStringArrayPref(MakePrototype.this,nowTime.getText().toString(),morning);
                        break;
                    case "DINNER":
                        setStringArrayPref(MakePrototype.this,nowTime.getText().toString(),morning);
                        break;
                        default:
                            Log.e("make_prototype","timetext is null");
                            break;

                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
    }

    private ArrayList<String> getStringArrayPref(Context context, String key) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String json = prefs.getString(key, null);
        ArrayList<String> urls = new ArrayList<String>();
        if (json != null) {
            try {
                JSONArray a = new JSONArray(json);
                for (int i = 0; i < a.length(); i++) {
                    String url = a.optString(i);
                    urls.add(url);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return urls;
    }
}
