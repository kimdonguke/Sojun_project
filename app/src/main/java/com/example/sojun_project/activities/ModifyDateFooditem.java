package com.example.sojun_project.activities;

import androidx.appcompat.app.AppCompatActivity;

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

import com.example.sojun_project.R;

import java.util.Calendar;
import java.util.Date;

public class ModifyDateFooditem extends AppCompatActivity {
    private Button morning,lunch,dinner,makedialogue;
    private EditText modifyfood_editname,modifyfood_editkalori;
    private Switch once;
    private String TAG = "ModifyDateFooditem";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_date_fooditem);
        morning=findViewById(R.id.modifyitem_morning);
        lunch=findViewById(R.id.modifyitem_lunch);
        dinner=findViewById(R.id.modifyitem_dinner);
        makedialogue=findViewById(R.id.modifyitem_dialogue);
        once=findViewById(R.id.modifyitem_onceswitch);
        modifyfood_editname=findViewById(R.id.modifyitem_name);
        modifyfood_editkalori=findViewById(R.id.modifyitem_kalori);

        morning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("morning","pressed");
            }
        });
        lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("lunch","pressed");
            }
        });
        dinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("dinner","pressed");
            }
        });
        makedialogue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(once.isChecked()==true){
                    Log.e("modifyDatefooditem","switch is checked");
                    DatePickerDialog dialog=new DatePickerDialog(ModifyDateFooditem.this,listener,2019,9,22);
                    dialog.show();
                }
                else{
                    Log.e("modifyDatefooditem","switch is unchecked");
                }
            }
        });
        once.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {//스위치 바꼈을 때 디폴트 값 시발
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(once.isChecked()==true){
                    makedialogue.setText("gimoring");
                }
                else{
                    makedialogue.setText("Monday");
                }
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
