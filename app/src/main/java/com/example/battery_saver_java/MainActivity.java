package com.example.battery_saver_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {



    private BatteryReceiver batteryReceiver = new BatteryReceiver();
    private IntentFilter intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(batteryReceiver,intentFilter);
    }

    @Override
    protected void onPause() {
        unregisterReceiver(batteryReceiver);
        super.onPause();
    }
}