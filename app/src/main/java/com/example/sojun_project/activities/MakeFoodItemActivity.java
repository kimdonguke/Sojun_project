package com.example.sojun_project.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.sojun_project.R;
//아 되고있구나 저기 형 위쪽에 안드 앱에 엑스표 쳐지고 ㅆ~ㅂ client not yet 이지랄 존~나 났어
public class MakeFoodItemActivity extends AppCompatActivity {
    Button addbtn;
    EditText foodname,foodkalori;
    private final int GET_GALLERY_IMAGE = 200;
    private ImageButton imageview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_food_item);
        foodname=(EditText)findViewById(R.id.makefooditem_name);
        foodkalori=(EditText)findViewById(R.id.makefooditem_kalori);
        addbtn=(Button)findViewById(R.id.makefooditem_submit);
        imageview = (ImageButton) findViewById(R.id.makefooditem_imgbtn);
        imageview.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent. setDataAndType(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent, GET_GALLERY_IMAGE);
            }
        });
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences("MakeFoodItmeActivity", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                // key값에 value값을 저장한다.
                // String, boolean, int, float, long 값 모두 저장가능하다.
                editor.putString("foodname", foodname.getText().toString());
                editor.putString("foodkalori",foodkalori.getText().toString());
                // 메모리에 있는 데이터를 저장장치에 저장한다.
                editor.commit();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == GET_GALLERY_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri selectedImageUri = data.getData();
            imageview.setImageURI(selectedImageUri);
        }
    }
}
