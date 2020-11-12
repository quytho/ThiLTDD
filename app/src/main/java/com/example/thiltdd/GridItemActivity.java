package com.example.thiltdd;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GridItemActivity extends AppCompatActivity {

    TextView iddongho;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_click);
//set dữ liệu cho trang sau click vào 1 item
        iddongho = findViewById(R.id.tv_click);
        imageView = findViewById(R.id.im_click);

        Intent intent = getIntent();
        String receivedName =  intent.getStringExtra("name");
        int receivedImage = intent.getIntExtra("image",0);


        iddongho.setText(receivedName);
        imageView.setImageResource(receivedImage);

    }
}