package com.alfatih.bigsooq.unit2.clickableimage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.alfatih.bigsooq.R;

public class OrderdActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String msg;
    private TextView mOrderedTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderd);
        mOrderedTextView = findViewById(R.id.donat_orderd_textView);
        Intent intentOrder = getIntent();
        msg = intentOrder.getStringExtra(OrderingApp.ORDER_MESSAGE);
        mOrderedTextView.setText(msg);
        mOrderedTextView.setVisibility(View.VISIBLE);

        //create the spinner
        Spinner spinner = findViewById(R.id.spinner_phone);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }
        // Create ArrayAdapter using the string array and default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears.

        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
        EditText editText = findViewById(R.id.editTextPhone);
        if (editText != null)
            editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    boolean handled = false;
                    if (actionId == EditorInfo.IME_ACTION_SEND) {
                        dialNumber();
                        handled = true;
                    }
                    return handled;
                }

                // If view is found, set the listener for editText.
            });
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked.
        switch (view.getId()) {
            case R.id.sameday:
                if (checked)
                    // Same day service
                    displayToast(getString(R.string.same_day_messenger_service));
                break;
            case R.id.nextday:
                if (checked)
                    // Next day delivery
                    //to do your code
                    displayToast(getString(R.string.next_day_ground_delivery));
                break;
            case R.id.pickup:
                if (checked)
                    // Pick up
                    displayToast(getString(R.string.pick_up));
                break;
            default:
                // Do nothing.
                break;
        }
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //to do your code after when selected
        String spinnerLabel = parent.getItemAtPosition(position).toString();
        displayToast(spinnerLabel);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void dialNumber() {
        // Find the editText_main view.
        EditText editText = findViewById(R.id.editTextPhone);
        String phoneNum = null;
        // If the editText field is not null,
        // concatenate "tel: " with the phone number string.
        if (editText != null) phoneNum = "tel:" +
                editText.getText().toString();
        // Optional: Log the concatenated phone number for dialing.
        //Log.d(TAG, "dialNumber: " + phoneNum);
        // Specify the intent.
        Intent intent = new Intent(Intent.ACTION_DIAL);
        // Set the data for the intent as the phone number.
        intent.setData(Uri.parse(phoneNum));
        // If the intent resolves to a package (app),
        // start the activity with the intent.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
            EditText phoneEdit = findViewById(R.id.editTextPhone);
            phoneEdit.setFocusable(false);
        } else {
            Log.d("ImplicitIntents", "Can't handle this!");
        }
    }

    public void onClickCheckBox(View view) {
        TextView textView_check = findViewById(R.id.textView_checkBox);
        Boolean checked_box = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkBox_lable1:
                if (checked_box) {
                    displayToast(getString(R.string.item_1) + " selected !");
                    textView_check.setText(getString(R.string.item_1));
                }
                break;
            case R.id.checkBox2:
                if (checked_box) {
                    displayToast(getString(R.string.item_2_checkBox) + " selected !");
                }
                break;
            case R.id.checkBox3:
                if (checked_box) {
                    displayToast(getString(R.string.item_3_checkBox) + " selected !");
                }
                break;
            default:
                // do nothing
                break;
        }
    }
}