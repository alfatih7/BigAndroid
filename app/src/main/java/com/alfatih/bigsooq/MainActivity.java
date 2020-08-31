package com.alfatih.bigsooq;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public Integer num = 0;
    TextView textView;
    Button buttonU, buttonD, buttonToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("Welcome to the first activity of my app");


        textView = (TextView) findViewById(R.id.textView);
        buttonU = findViewById(R.id.buttonUp);
        buttonD = findViewById(R.id.buttonDown);
        buttonToast = findViewById(R.id.toast_button);

        buttonU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num += 1;
                textView.setText(Integer.toString(num));
            }
        });
        buttonD.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                num -= 1;
                textView.setText(Integer.toString(num));
            }
        });
        final Intent intent = new Intent(this, LayoutEditor.class);
        buttonToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast();
                startActivity(intent);
            }
        });
    }

    public void showToast() {
        Toast toast = Toast.makeText(this, R.string.toast_message,
                Toast.LENGTH_SHORT);
        toast.show();
    }
}
