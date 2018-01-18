package com.test.naimish.eventbusbasics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {
    private Intent intent;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.event_text);
        EventBus.getDefault().register(this);
    }

    public void launchEvent(View view) {
        intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    @Subscribe
    public void seeResult(Sample sample) {
        textView.setText(sample.getText());
    }
}
