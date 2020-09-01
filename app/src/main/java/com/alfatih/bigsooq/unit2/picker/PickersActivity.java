package com.alfatih.bigsooq.unit2.picker;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.alfatih.bigsooq.R;

public class PickersActivity extends AppCompatActivity {
    TextView textViewDate, textViewTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pickers);

        textViewDate = findViewById(R.id.textView_picker_date);
        textViewTime = findViewById(R.id.time_textView);
//        Calendar c = Calendar.getInstance();
//        String date = String.valueOf(c.get(Calendar.YEAR))+ "/"+
//                String.valueOf(c.get(Calendar.MONTH))+"/"+
//                String.valueOf(c.get(Calendar.DAY_OF_MONTH));
//        textView.setText(date);
    }

    public void showDatePicke(View view) {
        DialogFragment dialogFragment = new DatePickerFragment();
        dialogFragment.show(getSupportFragmentManager(), "dataPicker");
    }

    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month + 1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (month_string +
                "/" + day_string + "/" + year_string);
        textViewDate.setText("Date: " + dateMessage);
    }

    public void showTimeDialog(View view) {
        DialogFragment dialogFragment = new TimePickerFragment();
        dialogFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public void processTimePickerResult(int hour, int minute) {
        String hour_string = Integer.toString(hour);
        String minute_string = Integer.toString(minute);
        String timeMessage = ("time chosen:" +
                hour_string + ":" + minute_string);
        textViewTime.setText(timeMessage);

    }
}