package com.example.ashish.diceroll;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public void rollClicked(View v)
    {
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.animationdef);

        int f=0;
       int images[]={R.drawable.one,R.drawable.two,R.drawable.three,
       R.drawable.four,R.drawable.five,R.drawable.six};
        Random r=new Random();
        int rn=r.nextInt(6);
        ImageView iv= (ImageView) findViewById(R.id.imageView);
        iv.setImageResource(images[rn]);
        iv.startAnimation(animation);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
