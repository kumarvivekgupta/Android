package layout;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.itakg.materialdesigntest.Information;
import com.example.itakg.materialdesigntest.Main2Activity;
import com.example.itakg.materialdesigntest.MyAdapter;
import com.example.itakg.materialdesigntest.R;

import java.util.ArrayList;

public class NavigationDrawerFragment extends Fragment implements MyAdapter.ItemCickedInView{
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private  View view;
    private DrawerLayout mDrawerLayout;
    public NavigationDrawerFragment() {
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        recyclerView=view.findViewById(R.id.myRecyclerView);
       myAdapter=new MyAdapter(getActivity(),getdata());
        myAdapter.getView(this);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

public ArrayList<Information> getdata()
{
    ArrayList<Information> list=new ArrayList<>();
    String title[]={"Jupiter","Mars","Mercury","Venus"};
    int image[]={R.drawable.jupiter,R.drawable.mars,R.drawable.mercury,R.drawable.venus};
    for(int i=0;i<4;i++)
    {
        Information current=new Information();
        current.title=title[i];
        current.image=image[i];
        list.add(current);
    }
    return list;
}

    public void setUp( DrawerLayout drawerLayout, Toolbar toolbar) {
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });
    }

    @Override
    public void itemClicked(int position) {
        getContext().startActivity(new Intent(getActivity(), Main2Activity.class));
    }
}
