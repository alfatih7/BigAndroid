package com.alfatih.bigsooq;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class TestLayout extends AppCompatActivity {
    public int count = 1;
    TextView textView, mReplyTextView;
    Button bz, bc, bs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_layout);
        textView = findViewById(R.id.c_test);

        bz = findViewById(R.id.zero_btn);
        bc = findViewById(R.id.count_btn);
        bs = findViewById(R.id.button_basic);


        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count();
            }
        });

        bz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                textView.setText(Integer.toString(0));

            }
        });
        bs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

    }

    public void count() {
        textView.setText(Integer.toString(count));
        count += 1;
    }

}