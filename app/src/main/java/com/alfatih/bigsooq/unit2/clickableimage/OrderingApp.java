package com.alfatih.bigsooq.unit2.clickableimage;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.alfatih.bigsooq.R;
import com.alfatih.bigsooq.unit2.CmenuActivity;
import com.alfatih.bigsooq.unit2.DialogActivity;
import com.alfatih.bigsooq.unit2.picker.PickersActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class OrderingApp extends AppCompatActivity {
    public static final String ORDER_MESSAGE =
            "orderingApp.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;
    Intent intent;
    private int orderCounts = 0;
    private int orderPrice = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordering_app);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = findViewById(R.id.fab_order);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                startActivity(intent);
            }
        });
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void orderDonuts(View view) {
        orderCounts += 1;
        displayToast(getString(R.string.donut_order_message) + " " + String.valueOf(orderCounts));
        intent = new Intent(this, OrderdActivity.class);
        intent.putExtra(ORDER_MESSAGE, getString(R.string.donut_order_message) +
                "\n" + "Number of orders: " + String.valueOf(orderCounts) +
                "\n" + "Price: " + String.valueOf(orderPrice * orderCounts) + "$");
    }

    /**
     * Shows a message that the ice cream sandwich image was clicked.
     */
    public void showIceCreamOrder(View view) {
        displayToast(getString(R.string.ice_cream_order_message));
    }

    /**
     * Shows a message that the froyo image was clicked.
     */
    public void showFroyoOrder(View view) {
        displayToast(getApplicationContext().toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_order:
                if (orderCounts > 0) {
                    displayToast("Order Selected");
                    startActivity(new Intent(this, OrderdActivity.class));
                } else {
                    displayToast("please choose an order !");
                }
                return true;
            case R.id.action_contact:
                displayToast("contact Selected");
                return true;
            case R.id.action_favorite:
                displayToast("Favorite Selected");
                return true;
            case R.id.action_status:
                displayToast("status Selected");
                return true;
            case R.id.menu_chal_id:
                startActivity(new Intent(this, CmenuActivity.class));
                return true;
            case R.id.dialog_item_id:
                startActivity(new Intent(this, DialogActivity.class));
                return true;
            case R.id.picker_id:
                startActivity(new Intent(this, PickersActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}