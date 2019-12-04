package com.example.sojun_project.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
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
   Button morning,lunch,dinner,makedialogue,additembtn;
    EditText modifyfood_editname,modifyfood_editkalori,modifyfood_edithowmuch;
   Switch once;
  String TAG = "ModifyDateFooditem";
    ArrayList<ItemData> morninglis, lunchlist, dinnerlist,fuck;
    RecyclerView recyclerView; GimoringAdapter gimoringAdapter;
    ImageButton modify_foodprofile;

    int checkweek=1;
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
        modifyfood_edithowmuch=findViewById(R.id.modifyitem_howmuch);
        modify_foodprofile=findViewById(R.id.modifyitem_imgbtn);

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
                    checkweek++;
                    if(checkweek>6){// 1주 안에서 돌아야하기 때문임
                        checkweek=0;
                    }
                    makedialogue.setText(manageWeek(checkweek));
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
                    makedialogue.setText("MONDAY");
                }
            }
        });
        additembtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String foodname, foodkalori, foodhowmuch;
                foodname=modifyfood_editname.getText().toString();
                foodkalori=modifyfood_editkalori.getText().toString();
                foodhowmuch = modifyfood_edithowmuch.getText().toString();
                if(foodname!=null&&foodkalori!=null&&foodhowmuch!=null) {
                    fuck.add(addItem(foodname, foodkalori, foodhowmuch, modify_foodprofile.getDrawable()));
                    //함수 하나 만들어서 각자 switch로 list 저장하고 list 업데이트하기
                }
                else{
                    Toast.makeText(ModifyDateFooditem.this, "edit을 모두 채워주세용", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public ItemData addItem( String name, String kalori,String howmuch, Drawable foodpicture){
        ItemData item= new ItemData(name,kalori,howmuch,foodpicture);
        return item;
    }
    private DatePickerDialog.OnDateSetListener listener=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            makedialogue.setText(month+1+"월"+dayOfMonth+"일");
        }
    };
    public String manageWeek(int i){
        switch (i){
            case 0:
                return "SUNDAY";
            case 1:
                return "MONDAY";

            case 2:
                return "TUSEDAY";

            case 3:
                return "WENDSDAY";
            case 4:
                return "THURSDAY";

            case 5:
                return "FRIDAY";

            case 6:
                return "SATUREDAY";

                default:
                    Log.e("modifydata","failed manageweek");
                    return "ERROR";
        }
    }
}
