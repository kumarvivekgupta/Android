package com.example.itakg.timerapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TimerMain extends AppCompatActivity {
    TextView total;
    TextView left;
    TextView result;
    Button dismiss;
    Button start;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_main);
        total= (TextView) findViewById(R.id.total);
        left= (TextView) findViewById(R.id.left);
        result= (TextView) findViewById(R.id.result);
        dismiss= (Button) findViewById(R.id.dismiss);
        start= (Button) findViewById(R.id.startAgain);

        String time=getIntent().getExtras().getString("time");
        total.setText("TOTAL TIME : "+time);
        long myTime=Long.parseLong(time);
        myTime=myTime*1000;
       CountDownTimer timer =new CountDownTimer(myTime,1000) {
           @Override
           public void onTick(long millisUntilFinished) {
               left.setText("TIME LEFT : "+String.valueOf(millisUntilFinished/1000));
           }

           @Override
           public void onFinish() {
               mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.ringtone);
               mediaPlayer.start();
               left.setText("TIME LEFT : 0");
               result.setText("TASK COMPLETED!!!!");
               dismiss.setVisibility(View.VISIBLE);
               start.setVisibility(View.VISIBLE);

           }
       };
       timer.start();
    }
    public void dismiss(View v)
    {
        mediaPlayer.stop();
    }
    public void startAgain(View v)
    {
        mediaPlayer.stop();
        Intent i=new Intent(TimerMain.this,MainActivity.class);
        startActivity(i);
    }
}
