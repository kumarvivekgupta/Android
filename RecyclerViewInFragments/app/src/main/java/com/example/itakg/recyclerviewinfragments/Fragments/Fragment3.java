package com.example.itakg.recyclerviewinfragments.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.itakg.recyclerviewinfragments.Activities.Main2Activity;
import com.example.itakg.recyclerviewinfragments.Informations.MyAdapter;
import com.example.itakg.recyclerviewinfragments.Informations.SortArray;
import com.example.itakg.recyclerviewinfragments.R;

/**
 * Created by itakg on 11/8/2017.
 */

public class Fragment3 extends Fragment implements MyAdapter.ItemClicked {
    private String[] numbers;
    private RecyclerView recyclerView;
    private int clickedNumber;
    private Communicate communicate;

    public void setCommunicate(Communicate communicate) {
        this.communicate = communicate;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment3, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView = getActivity().findViewById(R.id.recycler_view_3);
        numbers = new String[30];

        numbers = Main2Activity.number;
        MyAdapter adapter = new MyAdapter(SortArray.getSortedArray(numbers), getActivity(), 2);
        adapter.setitemClicked(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
    @Override
    public void clicked(String n) {
        clickedNumber = Integer.parseInt(n);
        Toast.makeText(getActivity(), n, Toast.LENGTH_SHORT).show();
        communicate.respond(clickedNumber);

    }
    public interface Communicate {
        public void respond(int data);
    }

}
