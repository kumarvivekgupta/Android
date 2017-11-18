package com.example.itakg.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String pos=getIntent().Extras()get.getString("Position");
        textView= (TextView) findViewById(R.id.textView);
//        textView.setText(pos);
        int num=Integer.parseInt(pos);
        String table="";
        num=num+1;
        for(int i=1;i<=10;i++)
        {
           table=table+String.valueOf(num*i)+"\n";
        }
        textView.setText(table);

    }
}
