package com.example.itakg.recyclerviewinfragments.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.itakg.recyclerviewinfragments.Informations.MyAdapter;
import com.example.itakg.recyclerviewinfragments.Informations.SortArray;
import com.example.itakg.recyclerviewinfragments.Informations.Table;

import com.example.itakg.recyclerviewinfragments.R;

/**
 * Created by itakg on 11/8/2017.
 */

public class Fragment4 extends Fragment {
    private RecyclerView recyclerView;
    private int no;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment4, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView = getActivity().findViewById(R.id.recycler_view4);
        no = getArguments().getInt("Data");
        MyAdapter adapter = new MyAdapter(Table.getTable(no), getActivity(), 3);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }


}
