package com.practise.naimish.navbar;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private static final int COUNT = 7;
    private Screen screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.view_pager);
        screen = new Screen(this);
        viewPager.setAdapter(screen);

    }

    class Screen extends PagerAdapter {
        private Context context;
        private LayoutInflater inflater;
        int id[] = {R.drawable.bulbblue, R.drawable.bulbgreen, R.drawable.green,
                R.drawable.like, R.drawable.logo
                , R.drawable.notification, R.drawable.icon};

        public Screen(Context context) {
            this.context = context;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return COUNT;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = inflater.inflate(R.layout.slide_fragment, container, false);
            ImageView imageView = view.findViewById(R.id.image_view);
            imageView.setImageResource(id[position]);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((LinearLayout)object);
        }
    }
}
