package com.alfatih.bigsooq.codec.cc5;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.alfatih.bigsooq.R;


public class SecondActivityChallenge5 extends AppCompatActivity {

    public static final String FAV_ITEM = "this.extra.FAV";

    TextView[] text_fav = new TextView[4];

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_challenge5);
        text_fav[0] = findViewById(R.id.fav_list1);
        text_fav[0].setText("Milk");
        text_fav[0].setTextColor(Color.WHITE);
        text_fav[0].setGravity(Gravity.CENTER);
        text_fav[0].setBackgroundColor(R.color.blue_grey_700);

        text_fav[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SecondActivityChallenge5.this,
                        MainActivityChallenge5.class);
                String fav = text_fav[0].getText().toString();
                intent.putExtra(FAV_ITEM, fav);
                startActivity(intent);
            }
        });
    }
}