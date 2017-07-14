package com.example.ashish.advanced;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Ashish on 7/3/2017.
 */
public class Fragement2 extends Fragment
{
    TextView tv;
    String[] d;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragement2,container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tv= (TextView) getActivity().findViewById(R.id.textView);
         d=getResources().getStringArray(R.array.Description);
    }

    public  void setData(int index)
    {
      tv.setText(d[index]);
    }
}
