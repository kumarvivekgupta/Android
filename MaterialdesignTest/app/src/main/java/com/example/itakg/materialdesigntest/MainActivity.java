package com.example.itakg.materialdesigntest;

import android.content.Intent;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import Tabs.SlidingTabLayout;
import layout.NavigationDrawerFragment;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewPager pager;
    SlidingTabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.drawer_fragment);
        drawerFragment.setUp( (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        pager= (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        tabLayout= (SlidingTabLayout) findViewById(R.id.tabs);
        tabLayout.setDistributeEvenly(true);
        tabLayout.setCustomTabView(R.layout.tab_images,R.id.icon_text);
       tabLayout.setBackgroundColor(getResources().getColor(R.color.primaryColor));
        tabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.accentColor));
        tabLayout.setViewPager(pager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.iconSetting:
                Toast.makeText(this, "Settings selected!!", Toast.LENGTH_SHORT).show();
                break;
           }


        return super.onOptionsItemSelected(item);
    }
    class MyPagerAdapter extends FragmentPagerAdapter
    {
        int icons[]={R.drawable.go,R.drawable.heart,R.drawable.home};
        String tabs[]={"TAB 1","TAB 2","TAB 3"};
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);

        }

        @Override
        public Fragment getItem(int position) {
            MyFragment fragment=MyFragment.getInstance(position);
            return fragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Drawable drawable=getResources().getDrawable(icons[position]);
            drawable.setBounds(0,0,130,130);
            ImageSpan span=new ImageSpan(drawable);
            SpannableString spannableString=new SpannableString(" ");
            spannableString.setSpan(span,0,spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            return spannableString;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}


class MyFragment extends Fragment{
    private TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.tab_fragment,container,false);
        textView=view.findViewById(R.id.tab_frag_text_view);
        Bundle bundle=getArguments();
        if(bundle!=null)
        {
            textView.setText("This page is "+bundle.getInt("Pos"));
        }
        return view;
    }
    public static MyFragment getInstance(int pos)
    {
        MyFragment fragment=new MyFragment();
        Bundle args=new Bundle();
        args.putInt("Pos",pos);
        fragment.setArguments(args);
        return fragment;
    }
}
























