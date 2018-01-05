package com.example.itakg.recyclerviewinfragments.Activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.itakg.recyclerviewinfragments.Fragments.Fragment1;
import com.example.itakg.recyclerviewinfragments.Fragments.Fragment2;
import com.example.itakg.recyclerviewinfragments.Fragments.Fragment3;
import com.example.itakg.recyclerviewinfragments.Fragments.Fragment4;
import com.example.itakg.recyclerviewinfragments.R;

public class Main2Activity extends AppCompatActivity {
private Fragment2 fragment2;
    private Toolbar toolbar;
    private TextView textView;

    public static String number[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        textView = (TextView) findViewById(R.id.toolbarTitle);
        toolbar.setVisibility(View.GONE);
        toolbar.setBackgroundColor(getResources().getColor(R.color.bg));
        if (true) {
            textView.setText("SORTED NUMBERS");
            toolbar.setVisibility(View.VISIBLE);

        }
        fragment2=new Fragment2();
        number=new String[10];
        number=getIntent().getExtras().getStringArray("Numbers");
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.add(R.id.constrain,fragment2,"");
        transaction.commit();
    }



}
