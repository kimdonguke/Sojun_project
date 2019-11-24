package com.example.sojun_project.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sojun_project.R;

public class ModifyDateFooditem extends AppCompatActivity {
    private Button morning,lunch,dinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_date_fooditem);
        morning=findViewById(R.id.modifyitem_morning);
        lunch=findViewById(R.id.modifyitem_lunch);
        dinner=findViewById(R.id.modifyitem_dinner);
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
    }
}
