package com.alfatih.bigsooq.codec.cc5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.alfatih.bigsooq.R;

public class MainActivityChallenge5 extends AppCompatActivity {
    public static final int TEXT_REQUEST = 1;
    TextView[] item = new TextView[10];

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        for (TextView textView : item) {
            if (textView.getVisibility() == View.VISIBLE) {
                outState.putBoolean("text_visible", true);
                outState.putString("text_fav", textView.getText().toString());
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_challenge5);

        item[0] = findViewById(R.id.txt_item1);
        item[1] = findViewById(R.id.txt_item2);
        item[2] = findViewById(R.id.txt_item3);
        item[3] = findViewById(R.id.txt_item4);
        item[4] = findViewById(R.id.txt_item5);
        item[5] = findViewById(R.id.txt_item6);
        item[6] = findViewById(R.id.txt_item7);
        item[7] = findViewById(R.id.txt_item8);
        item[8] = findViewById(R.id.txt_item9);
        item[9] = findViewById(R.id.txt_item10);
        // Restore the state.
        if (savedInstanceState != null) {
            Boolean isVisable =
                    savedInstanceState.getBoolean("text_visible");
            if (isVisable) {
                for (TextView txt : item) {
                    //if(txt.getText().toString().isEmpty()){
                    txt.setVisibility(View.VISIBLE);

                }

            }
        }
        Intent getIntent = getIntent();
        String message = getIntent.getStringExtra(SecondActivityChallenge5.FAV_ITEM);
        for (TextView textView : item) {
            if (textView.getText().toString().isEmpty()) {
                textView.setText(message);
                textView.setVisibility(View.VISIBLE);
                break;
            }
            //textView.setVisibility(View.INVISIBLE);
        }


        Button buttonAdd = findViewById(R.id.button_add_item);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivityChallenge5.this,
                        SecondActivityChallenge5.class));
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onStop() {
        super.onStop();


    }
}