package com.alfatih.bigsooq;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.alfatih.bigsooq.activities.FirstActivity;
import com.alfatih.bigsooq.activities.ImplicitActivity;
import com.alfatih.bigsooq.codec.cc5.MainActivityChallenge5;
import com.alfatih.bigsooq.debugger.SimpleCalc;
import com.alfatih.bigsooq.supportlib.SupportActivity;
import com.alfatih.bigsooq.unit2.clickableimage.OrderingApp;

import java.util.Random;

public class LauncherActivity extends AppCompatActivity {
    public static final String LOG_TAG =
            LauncherActivity.class.getSimpleName();
    int TIME = 2000; //5000 ms (5 Seconds)
    int colorRandom;
    private TextView textView_head;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        Button buttonActivities = findViewById(R.id.tut_activities_btn);
        Button buttonCodingChallenge5 = findViewById(R.id.button_challeng_coding_activity);
        //buttonActivities.setBackgroundColor(Color.RED);
        textView_head = findViewById(R.id.head_text);
        changeColorBackground();
        /*int i =0;
        while (i <= 10 ){
            // random color choose
            Random rnd = new Random();
            colorRandom = Color.argb(255, rnd.nextInt(256),
                    rnd.nextInt(256), rnd.nextInt(256));
            textView_head.setBackgroundColor(colorRandom);
            i++;
        }*/
        textView_head.setTextSize(23);
        textView_head.setText("Android Developer Fundamentals Course");


        buttonActivities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LauncherActivity.this, FirstActivity.class));
            }
        });
        buttonCodingChallenge5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LauncherActivity.this, MainActivityChallenge5.class));

            }
        });
        Button button_implicit = findViewById(R.id.button_implicit);
        button_implicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LauncherActivity.this,
                        ImplicitActivity.class));

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "on Start " +
                LOG_TAG, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "on Stop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "You are looser", Toast.LENGTH_SHORT).show();

    }


    @Override
    protected void onResume() {
        super.onResume();
        for (int i = 1; i < 2000; i++) {
            //the handler of timer in millisecond
            new Handler().postDelayed(new Runnable() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void run() {
                    changeColorBackground();
                }
            }, TIME);
        }

    }

    private void changeColorBackground() {
        for (int i = 1; i < 10; i++) {
            Random rnd = new Random();
            colorRandom = Color.argb(255, rnd.nextInt(256),
                    rnd.nextInt(256), rnd.nextInt(256));
            TextView mytxt = findViewById(R.id.head_text);
            mytxt.setBackgroundColor(colorRandom);
        }


    }

    public void openDebuer(View view) {
        startActivity(new Intent(this, SimpleCalc.class));
    }

    public void goToSupport(View view) {
        startActivity(new Intent(this, SupportActivity.class));
    }

    public void goToShop(View view) {
        startActivity(new Intent(this, OrderingApp.class));
    }
}
