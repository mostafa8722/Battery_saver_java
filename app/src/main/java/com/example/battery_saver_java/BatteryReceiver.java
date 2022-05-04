package com.example.battery_saver_java;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.BatteryManager;
import android.widget.ImageView;
import android.widget.TextView;

public class BatteryReceiver extends BroadcastReceiver {
    private ImageView img_batter_saver;
    private TextView status_label,percent_label;
    @Override
    public void onReceive(Context context, Intent intent) {
        img_batter_saver = ((MainActivity)context).findViewById(R.id.img_batter_saver);
        percent_label = ((MainActivity)context).findViewById(R.id.percent_label);
        status_label = ((MainActivity)context).findViewById(R.id.status_label);

        String action = intent.getAction();

        if(action!=null && action.equals(Intent.ACTION_BATTERY_CHANGED)){

            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS,-1);
            String message  = "";
            switch (status) {
                case  BatteryManager.BATTERY_STATUS_FULL:
                    message  = "Full";
                break;
                case  BatteryManager.BATTERY_STATUS_CHARGING :
                    message  = "Charging";
                    break;
                case  BatteryManager.BATTERY_STATUS_DISCHARGING:
                    message  = "DisCharging";
                    break;
                case  BatteryManager.BATTERY_STATUS_NOT_CHARGING:
                    message  = "Not Charging";
                    break;
                case  BatteryManager.BATTERY_STATUS_UNKNOWN:

        }
            status_label.setText(message);

            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,-1);
            int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE,-1);
            int percentage = level *100 / scale ;
            percent_label.setText(percentage + "%");

            Resources res = context.getResources();

            if(percentage<5)
                img_batter_saver.setImageResource(R.drawable.b0);
            else if(percentage<18)
                img_batter_saver.setImageResource(R.drawable.b25);
            else if(percentage<55)
                img_batter_saver.setImageResource(R.drawable.b50);
            else if(percentage<80)
                img_batter_saver.setImageResource(R.drawable.b75);
               else
                img_batter_saver.setImageResource(R.drawable.b100);



    }
}
}
