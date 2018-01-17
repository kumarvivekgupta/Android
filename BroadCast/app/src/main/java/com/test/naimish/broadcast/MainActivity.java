package com.test.naimish.broadcast;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        if(Build.VERSION.SDK_INT>=23){
//            if(ContextCompat.checkSelfPermission(this,
//                    Manifest.permission.RECEIVE_MMS)!=PackageManager.PERMISSION_GRANTED){
//                requestPermissions(new String[]{Manifest.permission.RECEIVE_SMS},123);
//            }
//        }
//        IntentFilter filter=new IntentFilter();
//        filter.addAction("android.provider.Telephony.SMS_RECEIVED");
//        registerReceiver(new MyReceiver1(),filter);


    }

    //    public void sendBroadCastReceiver(View view) {
//        Intent intent = new Intent();
//        intent.addCategory(Intent.CATEGORY_DEFAULT);
//        intent.setAction("com.naimish.example");
//        sendBroadcast(intent);
//    }
    public void sendBroadCastReceiver(View view) {
        Intent intent = new Intent();
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setAction("com.naimish.example");
        //sendOrderedBroadcast(intent,null);
        sendOrderedBroadcast(intent, null, new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.i("Receive", "activity");
            }
        }, null, MainActivity.RESULT_OK, null, null);

    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if(requestCode==123){
//            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
//                Log.i("per","granted");
//            }
//        }
//    }
}
