package com.example.sojun_project.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.sojun_project.Datas.ItemData;
import com.example.sojun_project.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ModifyDateFooditem extends AppCompatActivity {
    private Button morning,lunch,dinner,makedialogue,additembtn;
    private EditText modifyfood_editname,modifyfood_editkalori;
    private Switch once;
    private String TAG = "ModifyDateFooditem";
    ArrayList<ItemData> morninglis, lunchlist, dinnerlist,fuck;
    RecyclerView recyclerView; GimoringAdapter gimoringAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        morninglis = new ArrayList<>();
        lunchlist =new ArrayList<>();
        dinnerlist = new ArrayList<>();
        fuck= new ArrayList<>();

        final Date currentTime = Calendar.getInstance().getTime();
        final SimpleDateFormat dayFormat = new SimpleDateFormat("dd", Locale.getDefault());
        final SimpleDateFormat monthFormat = new SimpleDateFormat("MM", Locale.getDefault());

        setContentView(R.layout.activity_modify_date_fooditem);

        recyclerView= findViewById(R.id.modifyitem_recyclerview); //recyclered view connect
        recyclerView.setLayoutManager(new LinearLayoutManager(this));//아니 형 이거 ㅇ내가 전에 짯던 코드에선 잘 돌아갔는데 이게 맞ㅈ눈지 모르겠어
        gimoringAdapter=new GimoringAdapter(fuck);
        recyclerView.setAdapter(gimoringAdapter);

        morning=findViewById(R.id.modifyitem_morning);
        lunch=findViewById(R.id.modifyitem_lunch);
        dinner=findViewById(R.id.modifyitem_dinner);
        makedialogue=findViewById(R.id.modifyitem_dialogue);
        once=findViewById(R.id.modifyitem_onceswitch);
        modifyfood_editname=findViewById(R.id.modifyitem_name);
        modifyfood_editkalori=findViewById(R.id.modifyitem_kalori);
        additembtn=findViewById(R.id.modifyitem_modifybtn);

        morning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("morning","pressed");
                gimoringAdapter.updateData(morninglis);
            }
        });
        lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("lunch","pressed");
                gimoringAdapter.updateData(lunchlist);
            }
        });
        dinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("dinner","pressed");
                gimoringAdapter.updateData(dinnerlist);
            }
        });
        makedialogue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(once.isChecked()==true){
                    Log.e(TAG,"switch is checked");
                    DatePickerDialog dialog=new DatePickerDialog(ModifyDateFooditem.this,listener,2019,9,22);
                    dialog.show();
                }
                else{
                    Log.e(TAG,"switch is unchecked");
                }
            }
        });
        once.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {//스위치 바꼈을 때 디폴트 값 시발
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(once.isChecked()==true){
                    String month = monthFormat.format(currentTime);
                    String day = dayFormat.format(currentTime);
                    makedialogue.setText(month+"월"+day+"일");
                }
                else{
                    makedialogue.setText("Monday");
                }
            }
        });
        additembtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String foodname, foodcalori, foodhowmuch;
            }
        });
    }

    private DatePickerDialog.OnDateSetListener listener=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            Toast.makeText(getApplicationContext(), year+"년"+month+"월"+dayOfMonth+"일", Toast.LENGTH_SHORT).show();
            makedialogue.setText(month+"월"+dayOfMonth+"일");
        }
    };
}
