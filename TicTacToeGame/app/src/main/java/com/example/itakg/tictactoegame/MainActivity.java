package com.example.itakg.tictactoegame;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int myActivePlayer=0;// 0 for cross and 1 for circle
   public static int myGameState[]={2,2,2,2,2,2,2,2,2};
    private GridLayout gl;

    public void tapped(View view) {
        ImageView imageView = (ImageView) view;
        String tag = imageView.getTag().toString();
        int position = Integer.parseInt(tag);
        Log.i("Tag :", "Tag is : " + tag);
        if (myGameState[position] == 2)

        {
            if (myActivePlayer == 0)
            {
                imageView.setImageResource(R.drawable.cross);
                imageView.animate().rotation(360);
                myActivePlayer = 1;
                myGameState[position]=0;
                boolean flag=Logic.checkIntersection1(0);
                if(flag==true) {
                   for(int q=0;q<myGameState.length;q++)
                       myGameState[q]=0;
                    Toast.makeText(MainActivity.this, "Player 1 wins", Toast.LENGTH_SHORT).show();

                }
            }
            else
                {
                imageView.setImageResource(R.drawable.circle);
                myActivePlayer = 0;
                    myGameState[position]=1;
                    boolean flag=Logic.checkIntersection1(1);
                    if(flag==true) {
                        for(int q=0;q<myGameState.length;q++)
                            myGameState[q]=1;
                        Toast.makeText(MainActivity.this, "Player 2 wins", Toast.LENGTH_SHORT).show();

                    }
            }

        }
        else
            Toast.makeText(MainActivity.this,"Not Allowed!!",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gl= (GridLayout) findViewById(R.id.gridLayout);
    }
    public  void playAgain(View view)
    {
        Log.i("Play Again:","pressed");
        int r=gl.getRowCount();
        int c=gl.getColumnCount();
        for(int b=0;b<(r*c);b++)
        {
            ((ImageView)gl.getChildAt(b)).setImageResource(R.mipmap.ic_launcher);
        }

        for(int a=0;a<myGameState.length;a++)
        {
            myGameState[a]=2;
        }

        myActivePlayer=0;


    }
}


















