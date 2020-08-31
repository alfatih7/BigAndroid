package com.alfatih.bigsooq.supportlib;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.alfatih.bigsooq.R;

import java.util.Random;

public class SupportActivity extends AppCompatActivity {
    private TextView mHelloTextView;
    private String[] mColorArray = {"red_400", "pink_400", "purple_500", "deep_purple_300",
            "indigo_600", "blue_400", "light_blue_300", "cyan_700", "teal_800", "green_900",
            "light_green_500", "lime_400", "yellow_700", "amber_600", "orange_500",
            "deep_orange_600", "brown_400", "grey_600", "blue_grey_400", "black"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);

//        for(String color: mColorArray){
//            int resourceIdentifierName = getResources().getIdentifier(color,"color",
//                    getApplicationContext().getPackageName());
//            if(String.valueOf(resourceIdentifierName).isEmpty()){
//                System.out.println(String.valueOf(resourceIdentifierName) + " is not found");
//            }
//        }
        mHelloTextView = findViewById(R.id.textView_support);
        // restore saved instance state (the text color)
        if (savedInstanceState != null) {
            mHelloTextView.setTextColor(savedInstanceState.getInt("color"));
        }


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("color", mHelloTextView.getCurrentTextColor());
    }

    public void changeColor(View view) {
        // Get a random color name from the color array (20 colors).
        Random random = new Random();
        String colorName = mColorArray[random.nextInt(20)];

        // Get the color identifier that matches the color name.
        int colorResourceName = getResources().getIdentifier(colorName,
                "color", getApplicationContext().getPackageName());

        // Get the color ID from the resources less than 23 SDK
        int colorRes = ContextCompat.getColor(this, colorResourceName);

        //to use minimum sdk 23 in gradle
        //int colorRes = getResources.getColor(color, this.getTheme());

        // Set the text color.
        mHelloTextView.setTextColor(colorRes);
    }
}