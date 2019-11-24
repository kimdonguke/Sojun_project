package com.example.sojun_project.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageButton;

import com.example.sojun_project.R;
//아 되고있구나 저기 형 위쪽에 안드 앱에 엑스표 쳐지고 ㅆ~ㅂ client not yet 이지랄 존~나 났어
public class MakeFoodItemActivity extends AppCompatActivity {

    private final int GET_GALLERY_IMAGE = 200;
    private ImageButton imageview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_food_item);

        imageview = (ImageButton) findViewById(R.id.makefooditem_imgbtn);
        imageview.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_PICK);
                intent. setDataAndType(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent, GET_GALLERY_IMAGE);
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
