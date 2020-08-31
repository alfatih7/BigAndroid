package com.alfatih.bigsooq;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LayoutEditor extends AppCompatActivity {
    Button button, bScrol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_editor);

        button = findViewById(R.id.button4);
        bScrol = findViewById(R.id.scrol_btn);
        final Intent intent = new Intent(this, TestLayout.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
        bScrol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LayoutEditor.this, ScrollTextActivity.class);
                startActivity(i);
            }
        });
    }
}