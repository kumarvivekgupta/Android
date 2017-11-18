package com.example.itakg.timerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText time;
    Button start;
    String myTime;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        time= (EditText) findViewById(R.id.time);
        start= (Button) findViewById(R.id.start);
    }
    public void Start(View view)
    {
        myTime=time.getText().toString();
        i=Integer.parseInt(myTime);
        if(i==0)
        {
            Toast.makeText(this,"Please enter the time!!",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent intent=new Intent(MainActivity.this,TimerMain.class);
            intent.putExtra("time",myTime);
            startActivity(intent);
        }
    }
}
