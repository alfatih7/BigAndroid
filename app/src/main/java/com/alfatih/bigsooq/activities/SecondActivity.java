package com.alfatih.bigsooq.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.alfatih.bigsooq.R;

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_REPLAY =
            "activities.extra.REPLAY";
    Button buttonReplay;
    private EditText mReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mReply = findViewById(R.id.editText_second);
        buttonReplay = findViewById(R.id.button_second);
        Intent intent = getIntent();
        String message = intent.getStringExtra(FirstActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.text_message);
        textView.setText(message);

        buttonReplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String replay = mReply.getText().toString();
                Intent replyIntent = new Intent();
                replyIntent.putExtra(EXTRA_REPLAY, replay);

                //set the result code for replay intent
                setResult(RESULT_OK, replyIntent);
                finish();
            }
        });
    }
}