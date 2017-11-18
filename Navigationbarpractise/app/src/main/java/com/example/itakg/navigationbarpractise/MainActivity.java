package com.example.itakg.navigationbarpractise;

import android.content.Context;
import android.content.res.Resources;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String [] planets ;

    ListView listView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout= (DrawerLayout) findViewById(R.id.drawerLayout);
       planets=getResources().getStringArray(R.array.Planets);
        toggle=new ActionBarDrawerToggle(MainActivity.this,drawerLayout,R.string.open,R.string.close)
        {
            @Override
            public void onDrawerClosed(View drawerView) {
            Toast.makeText(MainActivity.this,"Drawer Close",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                Toast.makeText(MainActivity.this,"Drawer Open",Toast.LENGTH_SHORT).show();
            }
        };
        drawerLayout.setDrawerListener(toggle);
//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        listView = (ListView) findViewById(R.id.planet);

        listView.setAdapter(new MyAdapter(MainActivity.this));
        listView.setOnItemClickListener(MainActivity.this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(toggle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        toggle.syncState();
    }

    public void setTitle(int pos)
    {
        getSupportActionBar().setTitle(planets[pos]);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(MainActivity.this,planets[position]+" was selected!",Toast.LENGTH_SHORT).show();
        setTitle(position);
    }
}

class Single_row
{
    String planet;
    int image;

    public Single_row(String planet,int image) {
        this.planet = planet;
        this.image=image;
    }


}
class MyAdapter extends BaseAdapter
{
    ArrayList<Single_row> arrayList;
    Context context;

    public MyAdapter(Context ct) {
       context = ct;
        Resources res=context.getResources();
        arrayList=new ArrayList<Single_row>();
        String [] planets = res.getStringArray(R.array.Planets);
        int [] image={R.drawable.mercury,R.drawable.venus,R.drawable.earthjpg,R.drawable.mars,R.drawable.jupiter,R.drawable.saturn
                ,R.drawable.uranus,R.drawable.naptune};
        for(int i=0;i<8;i++)
        {
            arrayList.add(new Single_row(planets[i],image[i]));
        }

    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.list,parent,false);
        TextView planets=(TextView)view.findViewById(R.id.textView);
        ImageView imageView= (ImageView) view.findViewById(R.id.imageView);
        Single_row temp=arrayList.get(position);
        planets.setText(temp.planet);
        imageView.setImageResource(temp.image);
        return view;
    }
}