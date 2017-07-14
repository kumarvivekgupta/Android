package com.example.ashish.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Calculator extends AppCompatActivity {
    private static String a="";
    private static String b="";
    private static String o="";
    private static double x=0.0d;
    private static double y=0.0d;
    private static double z=0.0d;
    private int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        final EditText et=(EditText)findViewById(R.id.editText);
        Button one=(Button)findViewById(R.id.one);
        Button two=(Button)findViewById(R.id.two);
        Button three=(Button)findViewById(R.id.three);
        Button four=(Button)findViewById(R.id.four);
        Button five=(Button)findViewById(R.id.five);
        Button six=(Button)findViewById(R.id.six);
        Button seven=(Button)findViewById(R.id.seven);
        Button eight=(Button)findViewById(R.id.eight);
        Button nine=(Button)findViewById(R.id.nine);
        Button zero=(Button)findViewById(R.id.zero);
        Button back=(Button)findViewById(R.id.back);
        Button clear=(Button)findViewById(R.id.clear);
        Button dot=(Button)findViewById(R.id.dot);
        Button plus=(Button)findViewById(R.id.plus);
        Button minus=(Button)findViewById(R.id.minus);
        Button multiply=(Button)findViewById(R.id.multiply);
        Button divide=(Button)findViewById(R.id.divide);
        Button sqrt=(Button)findViewById(R.id.squareroot);
        Button modulus=(Button)findViewById(R.id.modulus);
        Button equals=(Button)findViewById(R.id.equals);
        et.setTextSize(50);
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              a=a+"0";
                et.setText(a);
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = a + "1";
                et.setText(a);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a=a+"2";
                et.setText(a);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = a + "3";
                et.setText(a);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = a + "4";
                et.setText(a);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = a + "5";
                et.setText(a);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = a + "6";
                et.setText(a);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = a + "7";
                et.setText(a);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = a + "8";
                et.setText(a);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = a + "9";
                et.setText(a);
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = a + ".";
                et.setText(a);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a ="";
                et.setText(null);
                count=0;
                b="";
                x=0.0;
                y=0.0;
                z=0.0;

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = a.substring(0, a.length() - 1);
                et.setText(a);     }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                o="+";
                b=et.getText().toString();
                a="";

            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                o="-";
                b=et.getText().toString();
                a="";
                if(count==0)
                {    et.setText("-");
                a=a+"-";}

            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                o = "*";
                b=et.getText().toString();
                a = "";

            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                o = "/";
                b=et.getText().toString();
                a = "";

            }
        });
        modulus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                o = "%";
                b=et.getText().toString();
                a = "";

            }
        });
        sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                o="sqrt";
            }
        });
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(o=="+")

                  {x = Double.parseDouble(b);
                      y=Double.parseDouble(a);
                  count=1;
                      z=x+y;
                      a=Double.toString(z);

                      et.setText(a);
                      x=z;
             }
                else if(o=="-")
                {x = Double.parseDouble(b);
                    y=Double.parseDouble(a);
                    count=1;
                    z=x-y;
                    a=Double.toString(z);
                    et.setText(a);
                    x=z;
                   }
                else if(o=="*")
                {x = Double.parseDouble(b);
                    y=Double.parseDouble(a);
                    count=1;
                    z=x*y;
                    a=Double.toString(z);
                    et.setText(a);
                    x=z;}
                else if(o=="/")
                { x = Double.parseDouble(b);
                    y=Double.parseDouble(a);
                    count=1;
                    z=x/y;
                    a=Double.toString(z);
                    et.setText(a);
                    x=z;}
                else if(o=="%")
                {x = Double.parseDouble(b);
                    y=Double.parseDouble(a);
                    count=1;
                    z=x%y;
                    a=Double.toString(z);
                    et.setText(a);
                    x=z;}
                else
              {
                 String q=et.getText().toString();
                  double i=Double.parseDouble(q);
                  a=Double.toString(Math.sqrt(i));
                          et.setText(a);
              }
            }
        });
    }
}
