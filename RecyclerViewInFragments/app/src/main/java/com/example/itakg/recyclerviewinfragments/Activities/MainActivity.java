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
import com.example.itakg.recyclerviewinfragments.R;

public class MainActivity extends AppCompatActivity {
    private Fragment1 fragment1;
    private Toolbar toolbar;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        textView = (TextView) findViewById(R.id.toolbarTitle);
        toolbar.setVisibility(View.GONE);
        if (true) {
            textView.setText("RANDOM NUMBERS");
            toolbar.setVisibility(View.VISIBLE);

        }
        fragment1 = new Fragment1();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.relativeLayout, fragment1, "");
        transaction.commit();
        Toast.makeText(this, "Click on a number to sort them", Toast.LENGTH_LONG).show();
    }
}
