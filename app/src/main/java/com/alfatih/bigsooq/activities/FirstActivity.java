package com.alfatih.bigsooq.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alfatih.bigsooq.R;

public class FirstActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE =
            "activities.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;
    private EditText mMessageEditText;
    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mReplyHeadTextView.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible", true);
            outState.putString("reply_text", mReplyTextView.getText().toString());

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        mMessageEditText = findViewById(R.id.send_editText);
        Button buttonSend = findViewById(R.id.send_button);
        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);

        // Restore the saved state.
        // See onSaveInstanceState() for what gets saved.
        if (savedInstanceState != null) {
            boolean isVisible =
                    savedInstanceState.getBoolean("reply_visible");
            // Show both the header and the message views. If isVisible is
            // false or missing from the bundle, use the default layout.
            if (isVisible) {
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(savedInstanceState
                        .getString("reply_text"));
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                String message = mMessageEditText.getText().toString();
                //to get extra with key and value pairs
                intent.putExtra(EXTRA_MESSAGE, message);
                /*When you use an explicit Intent to start another Activity,
                 you may not expect to get any data back—you're just activating that Activity.
                 In that case, you use startActivity() to start the new Activity,
                 as you did earlier in this practical.
                 If you want to get data back from the activated Activity,
                 however, you need to start it with startActivityForResult()*/
                startActivityForResult(intent, TEXT_REQUEST);
//                startActivity(intent);
            }
        });

    }

    /*The three arguments to onActivityResult() contain all the information you need
    to handle the return data: the requestCode you set when you launched
    the Activity with startActivityForResult(), the resultCode set in
    the launched Activity (usually one of RESULT_OK or RESULT_CANCELED),
    and the Intent data that contains the data returned from the launch Activity*/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply =
                        data.getStringExtra(SecondActivity.EXTRA_REPLAY);
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }
}