package com.example.sojun_project.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Switch;
import android.widget.Toast;

import com.example.sojun_project.R;

import java.util.Calendar;
import java.util.Date;

public class ModifyDateFooditem extends AppCompatActivity {
    private Button morning,lunch,dinner,makedialogue;
    private Switch once;
    private String TAG = "PickerActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_date_fooditem);
        morning=findViewById(R.id.modifyitem_morning);
        lunch=findViewById(R.id.modifyitem_lunch);
        dinner=findViewById(R.id.modifyitem_dinner);
        makedialogue=findViewById(R.id.modifyitem_dialogue);
        once=findViewById(R.id.modifyitem_onceswitch);
        morning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        dinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        makedialogue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(once.isChecked()==true){

                }
                else{

                }
            }
        });
    }
    private void init() {

        //Calendar를 이용하여 년, 월, 일, 시간, 분을 PICKER에 넣어준다.
        final Calendar cal = Calendar.getInstance();

        Log.e(TAG, cal.get(Calendar.YEAR) + "");
        Log.e(TAG, cal.get(Calendar.MONTH) + 1 + "");
        Log.e(TAG, cal.get(Calendar.DATE) + "");
        Log.e(TAG, cal.get(Calendar.HOUR_OF_DAY) + "");
        Log.e(TAG, cal.get(Calendar.MINUTE) + "");

        //DATE PICKER DIALOG
        findViewById(R.id.modifyitem_dialogue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog dialog = new DatePickerDialog(ModifyDateFooditem.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int date) {

                        String msg = String.format("%d 년 %d 월 %d 일", year, month + 1, date);
                        Toast.makeText(ModifyDateFooditem.this, msg, Toast.LENGTH_SHORT).show();
                    }
                }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));

                dialog.getDatePicker().setMaxDate(new Date().getTime());    //입력한 날짜 이후로 클릭 안되게 옵션
                dialog.show();

            }
        });
    }
}
