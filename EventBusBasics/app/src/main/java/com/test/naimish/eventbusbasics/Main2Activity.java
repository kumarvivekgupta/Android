package com.test.naimish.eventbusbasics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;

public class Main2Activity extends AppCompatActivity {
    private EditText editText;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText=findViewById(R.id.text_for_event);
        intent=new Intent(this,MainActivity.class);
    }

    public void sendEvent(View view){
        String s=editText.getText().toString();
        String d="xnbcasc";
        Sample sample=new Sample();
        sample.setText(s);
        EventBus.getDefault().post(sample);
        finish();
       // startActivity(intent);
    }
}
