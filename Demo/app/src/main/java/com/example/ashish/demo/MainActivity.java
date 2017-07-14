package com.example.ashish.demo;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.ActionBar;


public class MainActivity extends FragmentActivity implements ActionBar.TabListener {
ViewPager viewPager;
    android.app.ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar=getActionBar();
        if(actionBar!=null)
        actionBar.setNavigationMode(actionBar.NAVIGATION_MODE_TABS);


        android.app.ActionBar.Tab tab1=actionBar.newTab();
        tab1.setText("TAB 1");
        tab1.setTabListener((android.app.ActionBar.TabListener) this);

        android.app.ActionBar.Tab tab2=actionBar.newTab();
        tab2.setText("TAB 2");
        tab2.setTabListener((android.app.ActionBar.TabListener)this);

        android.app.ActionBar.Tab tab3=actionBar.newTab();
        tab3.setText("TAB 3");
        tab3.setTabListener((android.app.ActionBar.TabListener) this);

        actionBar.addTab(tab1);
        actionBar.addTab(tab2);
        actionBar.addTab(tab3);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}

