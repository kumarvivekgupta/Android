package com.example.itakg.recyclerviewinfragments.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.itakg.recyclerviewinfragments.Activities.Main2Activity;
import com.example.itakg.recyclerviewinfragments.Informations.MyAdapter;
import com.example.itakg.recyclerviewinfragments.Informations.SortArray;
import com.example.itakg.recyclerviewinfragments.R;

/**
 * Created by itakg on 11/8/2017.
 */

public class Fragment2 extends Fragment implements Fragment3.Communicate {
    private FragmentTransaction transaction1, transaction2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment2, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Fragment3 fragment3 = new Fragment3();
        fragment3.setCommunicate(this);
        transaction1 = getChildFragmentManager().beginTransaction();
        transaction1.replace(R.id.parent1, fragment3).commit();

    }


    @Override
    public void respond(int data) {
        Bundle bundle=new Bundle();
        bundle.putInt("Data",data);
        Fragment4 fragment4 = new Fragment4();
        fragment4.setArguments(bundle);
        transaction2 = getChildFragmentManager().beginTransaction();
        transaction2.replace(R.id.parent2, fragment4).commit();
    }
}
