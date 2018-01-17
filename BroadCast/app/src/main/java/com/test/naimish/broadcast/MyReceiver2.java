package com.test.naimish.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by itakg on 1/17/2018.
 */

public class MyReceiver2 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Received2", Toast.LENGTH_SHORT).show();
        Log.i("Receive", "received2");
    }
}
