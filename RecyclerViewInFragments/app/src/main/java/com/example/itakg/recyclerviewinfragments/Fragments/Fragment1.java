package com.example.itakg.recyclerviewinfragments.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.itakg.recyclerviewinfragments.Activities.Main2Activity;
import com.example.itakg.recyclerviewinfragments.Informations.MyAdapter;
import com.example.itakg.recyclerviewinfragments.R;

import java.util.Random;

/**
 * Created by itakg on 11/8/2017.
 */

public class Fragment1 extends Fragment implements MyAdapter.ItemClicked {
    private RecyclerView recyclerView;
    private String number[] = new String[30];
    private Random random;
    private MyAdapter myAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment1, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        random = new Random();

        recyclerView = getActivity().findViewById(R.id.recycler_view1);
        for (int i = 0; i < 30; i++) {
            number[i] = String.valueOf(random.nextInt(100));
        }
        myAdapter = new MyAdapter(number, getActivity(),1);
        myAdapter.setitemClicked(this);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void clicked(String n) {

        Intent intent=new Intent(getActivity(),Main2Activity.class);
        intent.putExtra("Numbers",number);
        startActivity(intent);
    }
}
