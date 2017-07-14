package com.example.ashish.advanced;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Fragement1.Communicator {
    FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm=getFragmentManager();
        Fragement1 f1= (Fragement1) fm.findFragmentById(R.id.fragment1);
f1.setCommunicator(this);
    }

    @Override
    public void respond(int index) {

        fm=getFragmentManager();
        Fragement2 f2= (Fragement2) fm.findFragmentById(R.id.fragment2);
        f2.setData(index);

    }
}
